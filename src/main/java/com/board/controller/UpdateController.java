package com.board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dto.BoardDto;
import com.board.service.BoardService;
 
@Controller
public class UpdateController {
    @Resource(name="boardService")
    private BoardService boardService;
    
    @RequestMapping(value="boardUpdate.action",method=RequestMethod.GET)
    public ModelAndView updateView(@RequestParam int seq){
        ModelAndView view = new ModelAndView();
        System.out.println(seq);
        BoardDto dto = boardService.findBySeq(seq);
        view.addObject("dto",dto);
        view.setViewName("Board_Update");
        return view;        
    }
 
    @RequestMapping(value="boardUpdate.action", method=RequestMethod.POST)
    public ModelAndView updateView(@ModelAttribute BoardDto board,@RequestParam String pass)
    {
        ModelAndView view = new ModelAndView();
        int result = boardService.updateBoard(board, pass);
        
        if(result == 1){
            System.out.println("수정 완료");
            view.setViewName("redirect:boardList.action");
        }else{
            System.out.println("수정 실패 이유 :" + result);
            view.addObject("result",result);
            view.setViewName("redirect:boardUpdate.action?seq="+board.getSeq());;
        }return view;
    }
}
