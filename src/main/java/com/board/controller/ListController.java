package com.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.BoardService;
import com.board.vo.BoardListVO;
import com.board.vo.BoardVO;
import com.board.vo.PageVO;
 
@Controller
public class ListController {
    @Resource(name="boardService")
    private BoardService boardService;
 
    @RequestMapping(value="/board/boardList")
    public ModelAndView list(@ModelAttribute BoardListVO boardListVO,ModelMap model)
    {
        ModelAndView view = new ModelAndView();
        int totalCount = boardService.boardListCnt(boardListVO);
        PageVO page = new PageVO();
        page.setDisplayRow(boardListVO.getListNum());       
        page.setTotalCount(totalCount);
        page.setPage(boardListVO.getPage());
        
        List<BoardVO> resultlist = boardService.boardList(boardListVO);
        
        view.addObject("resultlist", resultlist);
        view.addObject("page",page);
        
        //조건값 유지를 위한 model
        view.addObject("boardListVO",boardListVO);
        view.setViewName("board/Board_List.page");
        return view;
    }
}
