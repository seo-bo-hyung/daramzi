package com.imageboard.controller;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.imageboard.service.ImageBoardService;
import com.imageboard.vo.ImageBoardVO;
 
@Controller
public class ImageBoardController {
    @Resource(name="imageboardService")
    private ImageBoardService imageboardService;
    
    //게시판 글 목록
    @RequestMapping(value="/imageboard/imageboardList")
    public ModelAndView imageboardList(@ModelAttribute("search") ImageBoardVO info,ModelMap model)
    {
    	
        ModelAndView view = new ModelAndView();
//        int totalCount = imageboardService.imageboardListCnt(info);
//        PageVO page = new PageVO();
//        page.setDisplayRow(info.getListNum());       
//        page.setTotalCount(totalCount);
//        page.setPage(info.getPage());
//        
//        List<ImageBoardVO> resultlist = imageboardService.imageboardList(info);
//        
//        view.addObject("resultlist", resultlist);
//        view.addObject("page",page);
//        
//        //조건값 유지를 위한 model
//        view.addObject("search",info);
        view.setViewName("imageBoard/fileUploadForm.page");
        return view;
    }
    
//  //게시판 글 목록
//    @RequestMapping(value="/imageboard/fileupload", method= RequestMethod.POST,headers = ("content-type=multipart/*"))
//    public ModelAndView fileupload(ImageBoardVO info,HttpServletRequest request, HttpServletResponse response)
//    {
//    	System.out.println("fileupload타는지 확인");
//    	System.out.println("vo확인1 : " + info.toStringMultiline());
//        ModelAndView view = new ModelAndView();
//        String uploadDir =this.getClass().getResource("").getPath();
//
//        
//        String fileName = request.getParameter("file");
//
//        System.out.println("fileName 확인 ImageBoardController : " + fileName);
//        
//        uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"daramzi/src/main/webapp/resources/uploadImage";
//
//		// 총 100M 까지 저장 가능하게 함
//		int maxSize = 1024 * 1024 * 100;
//		String encoding = "UTF-8";
// 
//		// 사용자가 전송한 파일정보 토대로 업로드 장소에 파일 업로드 수행할 수 있게 함
//		MultipartRequest multipartRequest;
//		try {
//			multipartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding,new DefaultFileRenamePolicy());
//			// 중복된 파일이름이 있기에 fileRealName이 실제로 서버에 저장된 경로이자 파일
//			// fineName은 사용자가 올린 파일의 이름이다
//			// 이전 클래스 name = "file" 실제 사용자가 저장한 실제 네임
//			
//			info.setFileName(multipartRequest.getOriginalFileName("file"));
//			// 실제 서버에 업로드 된 파일시스템 네임
//			info.setFileRealName(multipartRequest.getFilesystemName("file"));
//			
//			// 디비에 업로드 메소드
//			imageboardService.fileupload(info);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//        view.setViewName("imageBoard/fileUploadForm.page");
//        return view;
//    }
    
    //파일 업로드 수행
    @RequestMapping(value="/imageboard/fileupload", method= RequestMethod.POST)
    public ModelAndView fileupload(MultipartFile file,ImageBoardVO info) throws Exception
    {
    	System.out.println("fileupload타는지 확인");
    	System.out.println("vo확인1 : " + info.toStringMultiline());
    	
        ModelAndView view = new ModelAndView();
        String uploadDir =this.getClass().getResource("").getPath();

        
        System.out.println("파일이름 : " + file.getOriginalFilename());
        System.out.println("파일크기 : " + file.getSize());
        System.out.println("컨텐트타입 : " + file.getContentType());
        
        uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"daramzi/src/main/webapp/resources/uploadImage";

		// 총 100M 까지 저장 가능하게 함

		String savedName = file.getOriginalFilename();
		
		File target = new File(uploadDir,savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		
		
		info.setFileName(file.getOriginalFilename());
		info.setFileRealName(file.getOriginalFilename());
		info.setFileRealName(file.getOriginalFilename());
		info.setFileSize(file.getSize());
		
		// 디비에 업로드 메소드
		imageboardService.fileupload(info);
		
 
        view.setViewName("imageBoard/fileUploadForm.page");
        return view;
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
