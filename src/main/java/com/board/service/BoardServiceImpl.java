package com.board.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.vo.BoardListVO;
import com.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
 
    @Resource(name="boardDao")
    private BoardDao boardDao;
    
    @Override
    public List<BoardVO> boardList(BoardListVO boardListVO) {
        return boardDao.boardList(boardListVO);
    }
    
    public int boardListCnt(BoardListVO boardListVO) {
        return boardDao.boardListCnt(boardListVO);
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
 
}
