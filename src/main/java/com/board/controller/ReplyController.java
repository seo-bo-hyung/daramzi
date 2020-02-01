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
public class ReplyController {
    @Resource(name="boardService")
    private BoardService boardService;
    
    
    @RequestMapping(value="/boardReply.action",method=RequestMethod.GET)
    public ModelAndView read(@RequestParam int seq){
        ModelAndView view = new ModelAndView();
        BoardDto dto = boardService.findBySeq(seq);
        view.addObject("dto",dto);
        view.setViewName("Board_Reply");
        return view;
    }
    
    //답변작성후 Board_List로 돌아가는 컨트롤러
    // 부모의 dto = board
    @RequestMapping(value="/boardReply.action",method=RequestMethod.POST)
    public String read(@ModelAttribute BoardDto dto,@RequestParam int temp_seq){
        ModelAndView view =new ModelAndView();
        view.setViewName("Board_List");
        
        BoardDto board = boardService.findBySeq(temp_seq);
        boardService.replyUpPos(board);
        dto.setPos(board.getPos());
        dto.setDepth(board.getDepth());
        System.out.println("원본 Pos" + board.getPos());
        String content = dto.getContent();
        String content2 = content.replace("\n", "<br/>");
        dto.setContent(content2);
        boardService.replyBoard(dto);
        
        return "redirect:boardList.action";
    }
}
