package com.imageboard.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.board.vo.PageVO;
import com.imageboard.service.ImageBoardService;
import com.imageboard.vo.ImageBoardVO;
 
@Controller
public class ImageBoardController {
    @Resource(name="imageboardService")
    private ImageBoardService imageboardService;
    
    //사진게시판 목록
    @RequestMapping(value="/imageboard/imageboardList")
    public ModelAndView imageboardList(@ModelAttribute("search") ImageBoardVO info,ModelMap model)
    {
    	
        ModelAndView view = new ModelAndView();
        int totalCount = imageboardService.imageboardListCnt(info);
        PageVO page = new PageVO();
        page.setDisplayRow(info.getListNum());       
        page.setTotalCount(totalCount);
        page.setPage(info.getPage());
        
        List<ImageBoardVO> resultlist = imageboardService.imageboardList(info);
        
        view.addObject("resultlist", resultlist);
        view.addObject("page",page);
        
        //조건값 유지를 위한 model
        view.addObject("search",info);
        view.setViewName("imageBoard/imageBoard_List.view");
        return view;
    }
    
    
    //사진 업로드 화면
    @RequestMapping(value="/imageboard/fileUploadForm")
    public ModelAndView fileUploadForm(@ModelAttribute("search") ImageBoardVO info,ModelMap model)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("imageBoard/fileUploadForm.page");
        return view;
    }
    
    
    //파일 업로드 수행
    @RequestMapping(value="/imageboard/fileupload", method= RequestMethod.POST)
    public ModelAndView fileupload(MultipartHttpServletRequest mtfRequest,ImageBoardVO info) throws Exception
    {
    	
    	System.out.println("fileupload 타는지 확인");
    	List<MultipartFile> fileList = mtfRequest.getFiles("file");

    	System.out.println("vo확인1 : " + info.toStringMultiline());
    	
        ModelAndView view = new ModelAndView();
        String uploadDir =this.getClass().getResource("").getPath();

        uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"daramzi/src/main/webapp/resources/uploadImage";

        
        for(MultipartFile f : fileList){
        	String uuid = UUID.randomUUID().toString();
        	uuid = uuid.replace("-", "");
        	
        	// 파일이 실제 저장될때 고유의 값으로 저장 되도록 random 값으로 파일명 설정
        	String savedName = uuid + "_" + f.getOriginalFilename();
        	
        	File target = new File(uploadDir,savedName);
        	FileCopyUtils.copy(f.getBytes(), target);
        	
        	info.setFileName(f.getOriginalFilename());
        	info.setFileRealName(savedName);
        	info.setFileSize(f.getSize());
        	
        	imageboardService.fileupload(info);
        }

        view.setViewName("imageBoard/fileUploadForm.page");
        return view;
    }
    
    //파일 삭제 수행
    @RequestMapping(value="/imageboard/fileDel", method= RequestMethod.POST)
    public ResponseEntity<String> fileDel(String fileIdx){
System.out.println("삭제타는지확인");
System.out.println("삭제타는지확인 222: " + "daramzi/src/main/webapp/resources/uploadImage/" + fileIdx);


		ImageBoardVO fileSelct= imageboardService.selectFile(fileIdx);
		
        String uploadDir =this.getClass().getResource("").getPath();

        uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"daramzi/src/main/webapp/resources/uploadImage";
		
    		
		File f = new File(uploadDir +"/" + fileSelct.getFileRealName()); // 파일 객체생성
    	if( f.exists()) {// 파일이 존재하면 파일을 삭제한다. 
    		imageboardService.deleteFile(fileIdx);
    		f.delete(); 
    	}
    	
	   return new ResponseEntity<String>("deleted",HttpStatus.OK);


    }
    
    
    //게시판 view
    @RequestMapping(value="/imageboard/imageboardView", method=RequestMethod.POST)
    public ModelAndView imageboardView(@ModelAttribute("read") ImageBoardVO searchInfo,ModelMap model)
    {
        ModelAndView view = new ModelAndView();
        
        //내용불러오기
        int seq = searchInfo.getSeq();
        ImageBoardVO viewContent = imageboardService.imageviewContent(seq);
        view.addObject("viewContent",viewContent);
        
        //검색조건 유지
        view.addObject("search",searchInfo);
        view.setViewName("imageBoard/Board_View.view");
        return view;        
    }
    
}
