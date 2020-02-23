package com.imageBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.vo.BoardVO;
import com.board.vo.PageVO;

@Controller
public class ImageBoardController {

    //사진게시판 글 목록
    @RequestMapping(value="/imageboard/imageBoardList")
    public ModelAndView imageBoardList(@ModelAttribute("search") BoardVO info,ModelMap model)
    {
    	
        ModelAndView view = new ModelAndView();
        //int totalCount = boardService.boardListCnt(info);
        PageVO page = new PageVO();
        page.setDisplayRow(info.getListNum());       
        //page.setTotalCount(totalCount);
        page.setPage(info.getPage());
        
        //List<BoardVO> resultlist = boardService.boardList(info);
        
        //view.addObject("resultlist", resultlist);
        view.addObject("page",page);
        
        //조건값 유지를 위한 model
        view.addObject("search",info);
        view.setViewName("imageBoard/list.page");
        return view;
    }
    	
	
}
