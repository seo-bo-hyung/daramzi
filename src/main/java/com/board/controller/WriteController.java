package com.board.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
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
    
    @RequestMapping(value="/board/boardWrite", method=RequestMethod.GET)
    public ModelAndView wirteView(@ModelAttribute("writeRequest") BoardVO vo){
    	ModelAndView view = new ModelAndView();
        view.setViewName("board/Board_Write.page");
        
        return view;
    }
    
    @RequestMapping(value="/board/boardWrite", method=RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute("writeRequest") BoardVO vo){
    	ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/board/boardList");
    	
        String content = vo.getContent();
        String content2 = content.replace("\n", "<br/>");
        vo.setContent(content2);
        boardService.insertBoard(vo);
        System.out.println("여기 까지 오나?");
        return view;
    }
}

