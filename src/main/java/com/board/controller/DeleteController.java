package com.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.BoardService;
 
@Controller
public class DeleteController {
    @Resource(name="boardService")
    
    private BoardService boardService;
    
    @RequestMapping(value="/boardDelete.action", method=RequestMethod.GET)
    public ModelAndView deleteView(@RequestParam int seq){
        ModelAndView view = new ModelAndView();
        view.setViewName("Board_Delete");
        
        String storPass = boardService.deleteView(seq);
        Map map = new HashMap();
        map.put("seq",seq);
        map.put("storPass", storPass);
        view.addAllObjects(map);
        return view;
    }
    
    @RequestMapping(value="boardDelete.action",method=RequestMethod.POST)
    public ModelAndView delete(@RequestParam int seq, @RequestParam String storPass){
        ModelAndView view = new ModelAndView();
        int result = boardService.deleteBoard(seq, storPass);
        System.out.println("딜레트의 결과값은 : " + result);
        if(result == 1){
            System.out.println("삭제에 성공하였습니다.");
            view.setViewName("redirect:boardList.action");
        }else{
            System.out.println("삭제에 실패하였습니다.");
            view.setViewName("redirect:boardDelete.action?seq="+ seq);
            view.addObject("result",result);
        } return view;
    }
 
}
