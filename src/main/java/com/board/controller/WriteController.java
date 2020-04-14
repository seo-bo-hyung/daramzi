package com.board.controller;


import java.io.IOException;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.BoardService;
import com.board.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
 
@Controller
public class WriteController {
 
    @Resource(name="boardService")
    private BoardService boardService;
    
    //글쓰기 화면가기
    @RequestMapping(value="/board/boardWrite", method=RequestMethod.GET)
    public ModelAndView wirteView(@ModelAttribute("writeRequest") BoardVO vo){
    	ModelAndView view = new ModelAndView();
        view.setViewName("board/Board_Write.view");
        
        return view;
    }
    
    //글쓰기
    @RequestMapping(value="/board/boardWrite", method=RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute("writeRequest") BoardVO vo,MultipartHttpServletRequest request, HttpServletResponse response){
    	System.out.println("vo확인1 : " + vo.toStringMultiline());
    	ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/board/boardList");
        
        String content = vo.getContent();
        String content2 = content.replace("\n", "<br/>");
        
        vo.setContent(content2);
        boardService.insertBoard(vo);
        String uploadDir =this.getClass().getResource("").getPath();
        String fileName = request.getParameter("file");
        
      MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
      Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
      MultipartFile multipartFile = null;
      while(iterator.hasNext()){
      	multipartFile = multipartHttpServletRequest.getFile(iterator.next());
      	if(multipartFile.isEmpty() == false){
      		System.out.println("------------- file start -------------");
      	}
      	
      	System.out.println("name : "+multipartFile.getName());
      	System.out.println("filename : "+multipartFile.getOriginalFilename());
      	System.out.println("size : "+multipartFile.getSize());
      	System.out.println("-------------- file end --------------\n");
  	}        
        
        
        System.out.println("fileName 확인 : " + fileName);
        
        uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"daramzi/src/main/webapp/resources/uploadImage";
        System.out.println("어디까지 들어오는가5");
		// 총 100M 까지 저장 가능하게 함
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		System.out.println("어디까지 들어오는가6");
		// 사용자가 전송한 파일정보 토대로 업로드 장소에 파일 업로드 수행할 수 있게 함
		MultipartRequest multipartRequest;
		System.out.println("어디까지 들어오는가7");
		try {
			System.out.println("어디까지 들어오는가8");
			multipartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding,new DefaultFileRenamePolicy());
			// 중복된 파일이름이 있기에 fileRealName이 실제로 서버에 저장된 경로이자 파일
			// fineName은 사용자가 올린 파일의 이름이다
			// 이전 클래스 name = "file" 실제 사용자가 저장한 실제 네임
			System.out.println("어디까지 들어오는가9");
			vo.setFileName(multipartRequest.getOriginalFileName("file"));
			// 실제 서버에 업로드 된 파일시스템 네임
			vo.setFileRealName(multipartRequest.getFilesystemName("file"));
			System.out.println("vo확인 : " + vo.toStringMultiline());
			// 디비에 업로드 메소드
			boardService.fileupload(vo);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return view;
    }
    
    //수정화면가기
    @RequestMapping(value="/board/boardUpdate", method=RequestMethod.POST)
    public ModelAndView boardUpdate(@ModelAttribute("modContent") BoardVO searchInfo)
    {
        ModelAndView view = new ModelAndView();
        int seq = searchInfo.getSeq();
        BoardVO modContent = boardService.findBySeq(seq);
        
        view.addObject("search",searchInfo);
        view.addObject("modContent",modContent);
        
        view.setViewName("board/Board_Update.view");
        return view; 
    }
    
    
    //글수정
    @RequestMapping(value="/board/boardUpdateComp", method=RequestMethod.POST)
    public ModelAndView boardUpdateComp(@ModelAttribute("modComp") BoardVO modComp,HttpServletRequest request, HttpServletResponse response)
    {
    	ModelAndView view = new ModelAndView();
        int result = boardService.updateBoard(modComp);
        
        String uploadDir =this.getClass().getResource("").getPath();
        String fileName = request.getParameter("file");

        
//        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
//        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//        MultipartFile multipartFile = null;
//        while(iterator.hasNext()){
//        	multipartFile = multipartHttpServletRequest.getFile(iterator.next());
//        	if(multipartFile.isEmpty() == false){
//        		System.out.println("------------- file start -------------");
//        	}
//        	
//        	System.out.println("name : "+multipartFile.getName());
//        	System.out.println("filename : "+multipartFile.getOriginalFilename());
//        	System.out.println("size : "+multipartFile.getSize());
//        	System.out.println("-------------- file end --------------\n");
//    	}

        
        System.out.println("fileName 확인 : " + fileName);
        
        uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"daramzi/src/main/webapp/resources/uploadImage";

		// 총 100M 까지 저장 가능하게 함
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
 
		// 사용자가 전송한 파일정보 토대로 업로드 장소에 파일 업로드 수행할 수 있게 함
		MultipartRequest multipartRequest;
		try {
			multipartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding,new DefaultFileRenamePolicy());
			// 중복된 파일이름이 있기에 fileRealName이 실제로 서버에 저장된 경로이자 파일
			// fineName은 사용자가 올린 파일의 이름이다
			// 이전 클래스 name = "file" 실제 사용자가 저장한 실제 네임
			
			modComp.setFileName(multipartRequest.getOriginalFileName("file"));
			// 실제 서버에 업로드 된 파일시스템 네임
			modComp.setFileRealName(multipartRequest.getFilesystemName("file"));
			
			// 디비에 업로드 메소드
			boardService.fileupload(modComp);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        
        
        if(result == 1){
        	
            view.addObject("search",modComp);
            view.setViewName("forward:/board/boardList");
        }else{
            view.addObject("modContent",modComp);
            view.setViewName("board/Board_Update.view");
        }return view;
    }   
    
    //글삭제
    @RequestMapping(value="/board/boardDelete", method=RequestMethod.POST)
    public ModelAndView boardDelete(@ModelAttribute("modContent") BoardVO modContent)
    {
    	ModelAndView view = new ModelAndView();
        int result = boardService.deleteBoard(modContent);
        if(result == 1){
            view.addObject("search",modContent);
            view.setViewName("forward:/board/boardList");
        }else{
            view.addObject("modContent",modContent);
            view.setViewName("board/Board_View.view");
        }return view;
    } 
}

