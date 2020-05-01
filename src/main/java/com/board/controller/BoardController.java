package com.board.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.BoardService;
import com.board.vo.BoardVO;
import com.board.vo.PageVO;
import com.common.util.GetSession;
import com.common.vo.FileVO;
 
@Controller
public class BoardController {
    @Resource(name="boardService")
    private BoardService boardService;
    
    //게시판 글 목록
    @RequestMapping(value="/board/boardList")
    public ModelAndView boardList(@ModelAttribute("search") BoardVO info,ModelMap model)
    {
    	System.out.println("인자값 확인 boardList: " + info.toStringMultiline());
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
    public ModelAndView boardView(@ModelAttribute("read") BoardVO searchInfo,ModelMap model,HttpServletRequest request)
    {
    	System.out.println("인자값 확인 searchInfo: " + searchInfo.toStringMultiline());
    	
        ModelAndView view = new ModelAndView();
        
    	String id = GetSession.GetSessionId(request); //세션아이디 가져오기
    	searchInfo.setId(id);
        
        //내용불러오기
        int boardIdx = searchInfo.getBoardIdx();
        BoardVO viewContent = boardService.viewContent(searchInfo);
        view.addObject("viewContent",viewContent);
        
        List<FileVO> resultlist = boardService.fileList(boardIdx);
        
        view.addObject("resultlist", resultlist);
        
        
        //검색조건 유지
        view.addObject("search",searchInfo);
        
        view.setViewName("board/Board_View.view");
        return view;        
    }
    
    //파일 추천 상태 변경
    @RequestMapping(value="/board/boardRecommend", method= RequestMethod.POST)
    public @ResponseBody BoardVO fileRecommend(BoardVO info,HttpServletRequest request) throws Exception {
    	
    	System.out.println("info인자값 확인 : " + info.toStringMultiline());
    	
    	String id = GetSession.GetSessionId(request); //세션아이디 가져오기
    	info.setId(id);
    	
    	//추천 상태 바꾸기전 기존 정보 삭제
    	int delresult = boardService.deleteBoardRecommend(info);
    	
    	if(delresult == 1) {
    		boardService.insertBoardRecommend(info);
    	}
    	
    	BoardVO getCnt = new BoardVO();
    	getCnt = boardService.selectBoardRecommendCnt(info);
    	
    	info.setRecommendYcnt(getCnt.getRecommendYcnt());
    	info.setRecommendNcnt(getCnt.getRecommendNcnt());
    	
    	System.out.println("나중 info인자값 확인 : " + info.toStringMultiline());
    	
    	
	   return info;
    }
    
    

}
