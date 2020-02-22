package com.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.BoardService;
import com.board.vo.BoardVO;
import com.board.vo.PageVO;
 
@Controller
public class BoardController {
    @Resource(name="boardService")
    private BoardService boardService;
    
    //게시판 글 목록
    @RequestMapping(value="/board/boardList")
    public ModelAndView boardList(@ModelAttribute("search") BoardVO info,ModelMap model)
    {
    	
        ModelAndView view = new ModelAndView();
        int totalCount = boardService.boardListCnt(info);
        PageVO page = new PageVO();
        page.setDisplayRow(info.getListNum());       
        page.setTotalCount(totalCount);
        page.setPage(info.getPage());
        
        List<BoardVO> resultlist = boardService.boardList(info);
        
        view.addObject("resultlist", resultlist);
        view.addObject("page",page);
        
        //조건값 유지를 위한 model
        view.addObject("search",info);
        view.setViewName("board/Board_List.page");
        return view;
    }
    
    //게시판 view
    @RequestMapping(value="/board/boardView", method=RequestMethod.POST)
    public ModelAndView boardView(@ModelAttribute("read") BoardVO searchInfo,ModelMap model)
    {
        ModelAndView view = new ModelAndView();
        
        //내용불러오기
        int seq = searchInfo.getSeq();
        BoardVO viewContent = boardService.viewContent(seq);
        view.addObject("viewContent",viewContent);
        
        //검색조건 유지
        view.addObject("search",searchInfo);
        view.setViewName("board/Board_View.view");
        return view;        
    }
    
    

}
