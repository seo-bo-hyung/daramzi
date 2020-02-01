package com.board.controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dto.BoardDto;
import com.board.service.BoardService;
 
@Controller
public class WriteController {
 
    @Resource(name="boardService")
    private BoardService boardService;
    
    @RequestMapping(value="/boardWrite.action", method=RequestMethod.GET)
    public String wirteView(){
        return "Board_Write";
    }
    
    @RequestMapping(value="/boardWrite.action", method=RequestMethod.POST)
    public String insert(@ModelAttribute BoardDto dto){
        String content = dto.getContent();
        String content2 = content.replace("\n", "<br/>");
        dto.setContent(content2);
        boardService.insertBoard(dto);
        return "redirect:boardList.action";
    }
}

