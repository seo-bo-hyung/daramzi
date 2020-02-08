package com.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
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
        List<BoardVO> list = boardService.boardList(boardListVO);
        PageVO page = null;
        
        page = boardService.pagingProc(0, 0, list.size());
        
        view.addObject("dao", new BoardDao());
        view.addObject("list", list);
        view.addObject("page",page);
        view.addObject("boardListVO",boardListVO);
        
        view.setViewName("board/Board_List.page");
        return view;
    }
}
