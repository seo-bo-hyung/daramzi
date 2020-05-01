package com.board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.board.service.BoardService;
 
@Controller
public class ReplyController {
    @Resource(name="boardService")
    private BoardService boardService;
    
    /*
    @RequestMapping(value="/boardReply.action",method=RequestMethod.GET)
    public ModelAndView read(@RequestParam int seq){
        ModelAndView view = new ModelAndView();
        BoardVO dto = boardService.findByIdx(seq);
        view.addObject("dto",dto);
        view.setViewName("Board_Reply");
        return view;
    }
    
    //답변작성후 Board_List로 돌아가는 컨트롤러
    // 부모의 dto = board
    @RequestMapping(value="/boardReply.action",method=RequestMethod.POST)
    public String read(@ModelAttribute BoardVO dto,@RequestParam int temp_seq){
        ModelAndView view =new ModelAndView();
        view.setViewName("Board_List");
        
        BoardVO board = boardService.findByIdx(temp_seq);
        boardService.replyUpPos(board);
        String content = dto.getContent();
        String content2 = content.replace("\n", "<br/>");
        dto.setContent(content2);
        boardService.replyBoard(dto);
        
        return "redirect:boardList.action";
    }
    */
}
