package com.board.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
 
    @Resource(name="boardDao")
    private BoardDao boardDao;
    
    @Override
    public List<BoardVO> boardList(BoardVO boardVO) {
        return boardDao.boardList(boardVO);
    }
    
    public int boardListCnt(BoardVO boardVO) {
        return boardDao.boardListCnt(boardVO);
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
    public int updateBoard(BoardVO board) {
        return boardDao.updateBoard(board);
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
 
}
