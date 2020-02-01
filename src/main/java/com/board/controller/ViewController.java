package com.board.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dto.BoardDto;
import com.board.service.BoardService;
 
@Controller
public class ViewController {
    @Resource(name="boardService")
    
    private BoardService boardService;
    
    @RequestMapping(value="/boardView.action", method=RequestMethod.POST)
    public ModelAndView read(@RequestParam int seq, String keyField, String keyWord)
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("Board_View");
        BoardDto dto = boardService.viewContent(seq);
        view.addObject("dto",dto);
        view.addObject("keyField",keyField);
        view.addObject("keyWord",keyWord);
        return view;        
    }
 
}
