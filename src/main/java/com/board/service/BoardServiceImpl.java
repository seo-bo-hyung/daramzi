package com.board.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.vo.BoardListVO;
import com.board.vo.BoardVO;
import com.board.vo.PageVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
 
    @Resource(name="boardDao")
    private BoardDao boardDao;
    
    @Override
    public List<BoardVO> boardList(BoardListVO boardListVO) {
        return boardDao.boardList(boardListVO);
    }
 
    public BoardVO findBySeq(int seq) {
        return boardDao.findBySeq(seq);
    }
 
    @Override
    public BoardVO viewContent(int seq) {
        return boardDao.viewContent(seq);
    }
 
    @Override
    public void insertBoard(BoardVO board) {
        boardDao.insertBoard(board);        
    }
 
    @Override
    public int updateBoard(BoardVO board, String pass) {
        return boardDao.updateBoard(board, pass);
    }
 
    @Override
    public String deleteView(int seq) {
        return boardDao.deleteView(seq);
    }
 
    @Override
    public int deleteBoard(int seq, String storPass) {
        return boardDao.deleteBoard(seq, storPass);
    }
 
    @Override
    public void replyBoard(BoardVO board) {
        boardDao.replyBoard(board);
    }
 
    @Override
    public void replyUpPos(BoardVO board) {
        boardDao.replyUpPos(board);
    }
 
    // 아래부터 페이징 
 
    public PageVO pagingProc(int nowPage, int nowBlock, int totalRecord) {
    	System.out.println("nowPage1 : " + nowPage + ",nowBlock: " +nowBlock + ",totalRecord:" +totalRecord);
    	
        int numPerPage = 5;
        int pagePerBlock = 4;
        int totalPage = (int)Math.ceil((double)totalRecord / numPerPage); 
        int beginPerPage = nowPage * numPerPage;
        int totalBlock = (int)Math.ceil((double)totalPage / pagePerBlock);
        
        PageVO page = new PageVO();
        System.out.println("nowPage2 : " + nowPage + ",nowBlock: " +nowBlock + ",totalRecord:" +totalRecord);
        page.setBeginPerPage(beginPerPage);
        page.setNowBlock(nowBlock);
        page.setNowPage(nowPage);
        page.setNumPerPage(numPerPage);
        page.setPagePerBlock(pagePerBlock);
        page.setTotalBlock(totalBlock);
        page.setTotalPage(totalPage);
        page.setTotalRecord(totalRecord);
        System.out.println("nowPage3 : " + nowPage + ",nowBlock: " +nowBlock + ",totalRecord:" +totalRecord);
        return page;
    } 


}
