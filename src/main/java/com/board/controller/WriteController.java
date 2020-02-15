package com.board.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.BoardService;
import com.board.vo.BoardVO;
 
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
    public ModelAndView insert(@ModelAttribute("writeRequest") BoardVO vo){
    	ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/board/boardList");
    	
        String content = vo.getContent();
        String content2 = content.replace("\n", "<br/>");
        vo.setContent(content2);
        boardService.insertBoard(vo);
        return view;
    }
    
    //수정화면가기
    @RequestMapping(value="/board/boardUpdate", method=RequestMethod.POST)
    public ModelAndView boardUpdate(@ModelAttribute("modContent") BoardVO searchInfo,ModelMap model)
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
    public ModelAndView boardUpdateComp(@ModelAttribute("modComp") BoardVO modComp,ModelMap model)
    {
    	ModelAndView view = new ModelAndView();
        int result = boardService.updateBoard(modComp);
        if(result == 1){
        	
            view.addObject("search",modComp);
            view.setViewName("forward:/board/boardList");
        }else{
            view.addObject("modContent",modComp);
            view.setViewName("board/Board_Update.view");
        }return view;
    }    
}

