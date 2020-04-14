package com.imageboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    	
    	System.out.println("인자값 확인: " + info.toStringMultiline());
    	
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
    
    //선택 파일 액션
    @RequestMapping(value="/imageboard/fileChk", method= RequestMethod.POST)
    public ModelAndView fileChk(@ModelAttribute("chkFile") ImageBoardVO info,ModelMap model,HttpServletRequest request, HttpServletResponse response){
    	ModelAndView view = new ModelAndView();
    	System.out.println("getSendStyle  확인 : " + info.getSendStyle());
        for( String value : info.getIdxArr() ){
        	
        	if(info.getSendStyle().equals("del")) { // 체크파일 삭제일경우
        		fileDel(value);
        	}
        	
        	if(info.getSendStyle().equals("down")) { // 체크파일 다운로드일경우
        		try {
        			System.out.println("down  확인 ");
					fileDown(value,request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        	}
        }
         
        //조건값 유지를 위한 model
        view.setViewName("imageBoard/imageBoard_List.view");
        return view;
    }
    
    
    // 브라우저 정보 get
    public String getBrowser(HttpServletRequest request) {

        String header = request.getHeader("User-Agent");

		   if (header.indexOf("MSIE") > -1) {
		
		       return "MSIE";
		
		   } else if (header.indexOf("Trident") > -1) {   // IE11 문자열 깨짐 방지
		
		       return "Trident";
		
		   } else if (header.indexOf("Chrome") > -1) {
		
		       return "Chrome";
		
		   } else if (header.indexOf("Opera") > -1) {
		
		       return "Opera";
		
		   } else if (header.indexOf("Safari") > -1) {
		
		       return "Safari";
		
		   }
		
		   return "Firefox";

    }

    
    
    //파일 다운로드 수행
    @RequestMapping(value="/imageboard/fileDown")
    public ResponseEntity<String> fileDown(@RequestParam String fileIdx, HttpServletRequest request,HttpServletResponse response) throws Exception{
		ImageBoardVO fileSelct= imageboardService.selectFile(fileIdx);
		System.out.println("왜 네번이 돌아");
        String uploadDir =this.getClass().getResource("").getPath();

        uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"daramzi/src/main/webapp/resources/uploadImage";
        
	    request.setCharacterEncoding("UTF-8");

	    // 파일 업로드된 경로
	    String savePath = uploadDir;

	    // 서버에 실제 저장된 파일명
	    String filename = fileSelct.getFileRealName() ;

	    // 실제 내보낼 파일명
	    String orgfilename = fileSelct.getFileName() ;
	 
	    InputStream in = null;
	    OutputStream os = null;
	    File file = null;
	    boolean skip = false;
	    String client = "";
	    
	    String browser = getBrowser(request);

        

        String dispositionPrefix = "attachment; filename=";

        String encodedFilename = null;

	    
	    

	    try{
	        // 파일을 읽어 스트림에 담기
	        try{
	            file = new File(savePath, filename);
	            in = new FileInputStream(file);
	        }catch(FileNotFoundException fe){
	            skip = true;
	        }

	        client = request.getHeader("User-Agent");

	        // 파일 다운로드 헤더 지정
	        response.reset() ;
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Description", "JSP Generated Data");

	        if(!skip){
	        	
		        //브라우저별 한글깨짐현상 방지	
	        	if (browser.equals("MSIE")) {
	
	                    encodedFilename = URLEncoder.encode(orgfilename, "UTF-8").replaceAll("\\+", "%20");
	
	             } else if (browser.equals("Trident")) {       // IE11 문자열 깨짐 방지
	
	                    encodedFilename = URLEncoder.encode(orgfilename, "UTF-8").replaceAll("\\+", "%20");
	
	             } else if (browser.equals("Firefox")) {
	
	                    encodedFilename = "\"" + new String(orgfilename.getBytes("UTF-8"), "8859_1") + "\"";
	
	                    encodedFilename = URLDecoder.decode(encodedFilename);
	
	             } else if (browser.equals("Opera")) {
	
	                    encodedFilename = "\"" + new String(orgfilename.getBytes("UTF-8"), "8859_1") + "\"";
	
	             } else if (browser.equals("Chrome")) {
	
	                    StringBuffer sb = new StringBuffer();
	
	                    for (int i = 0; i < orgfilename.length(); i++) {
	
	                           char c = orgfilename.charAt(i);
	
	                           if (c > '~') {
	
	                                 sb.append(URLEncoder.encode("" + c, "UTF-8"));
	
	                           } else {
	
	                                 sb.append(c);
	
	                           }
	
	                    }
	
	                    encodedFilename = sb.toString();
	
	             } else if (browser.equals("Safari")){
	
	                    encodedFilename = "\"" + new String(orgfilename.getBytes("UTF-8"), "8859_1")+ "\"";
	
	                    encodedFilename = URLDecoder.decode(encodedFilename);
	
	             }
	
	             else {
	
	                    encodedFilename = "\"" + new String(orgfilename.getBytes("UTF-8"), "8859_1")+ "\"";
	
	             }
	        	

	            // IE
	            if(client.indexOf("MSIE") != -1){
	                response.setHeader ("Content-Disposition", dispositionPrefix + encodedFilename);
	            }else{
	                // 한글 파일명 처리
	                response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
	                response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
	            }  

	            response.setHeader ("Content-Length", ""+file.length() );

	            os = response.getOutputStream();
	            byte b[] = new byte[(int)file.length()];
	            int leng = 0;

	            while( (leng = in.read(b)) > 0 ){
	                os.write(b,0,leng);
	            }
	        }else{
	            response.setContentType("text/html;charset=UTF-8");
	            System.out.println("파일을 찾을 수 없습니다");
	        }

	        in.close();
	        os.close();

	    }catch(Exception e){
	      e.printStackTrace();
	    }
		
    	
	   return new ResponseEntity<String>("deleted",HttpStatus.OK);
    }
    
    
    //파일 삭제 수행
    @RequestMapping(value="/imageboard/fileDel", method= RequestMethod.POST)
    public ResponseEntity<String> fileDel(String fileIdx){
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
    
   
    
    //폴더생성
    @RequestMapping(value="/imageboard/mkDir", method= RequestMethod.POST)
    public ModelAndView mkDir(@ModelAttribute("mkDir") ImageBoardVO info,ModelMap model){
    	ModelAndView view = new ModelAndView();
    	
         String uploadDir =this.getClass().getResource("").getPath();

         uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"daramzi/src/main/webapp/resources/uploadImage";
    	 
         String filePath = uploadDir + "/" + info.getFolderName()+ "/";
         
    	 File fPath = new File(filePath); //경로생성

    	 if ( !fPath.exists() ) {
    	   fPath.mkdirs(); //상위 디렉토리가 존재하지 않으면 상위디렉토리부터 생성.
    	   imageboardService.mkDir(info);
    	  }


        //조건값 유지를 위한 model
        view.setViewName("imageBoard/imageBoard_List.view");
        return view;
    }   
    
    //폴더 삭제
    @RequestMapping(value="/imageboard/delDir", method= RequestMethod.POST)
    public ModelAndView delDir(@ModelAttribute("delDir") ImageBoardVO info,ModelMap model){
		ModelAndView view = new ModelAndView();
		System.out.println("delDir확인1 : " + info.toStringMultiline());
		 String uploadDir =this.getClass().getResource("").getPath();
		
		 uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"daramzi/src/main/webapp/resources/uploadImage";
		 
		 String filePath = uploadDir + "/" + info.getFolderName()+ "/";
		 
		 File fPath = new File(filePath); //경로생성
		
		 if ( fPath.exists() ) {
		   fPath.delete(); //상위 디렉토리가 존재하지 않으면 상위디렉토리부터 생성.
		   imageboardService.delDir(info);
		  }


        //조건값 유지를 위한 model
        view.setViewName("imageBoard/imageBoard_List.view");
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
