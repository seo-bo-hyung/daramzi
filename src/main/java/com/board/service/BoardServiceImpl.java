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
 
    public BoardVO findByIdx(int boardIdx) {
        return boardDao.findByIdx(boardIdx);
    }
 
    @Override
    public BoardVO viewContent(int boardIdx) {
        return boardDao.viewContent(boardIdx);
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
    public String deleteView(int boardIdx) {
        return boardDao.deleteView(boardIdx);
    }
 
    @Override
    public int deleteBoard(BoardVO board) {
        return boardDao.deleteBoard(board);
    }
 
    @Override
    public void replyBoard(BoardVO board) {
        boardDao.replyBoard(board);
    }
 
    @Override
    public void replyUpPos(BoardVO board) {
        boardDao.replyUpPos(board);
    }
    
    @Override
    public void fileupload(BoardVO board) {
    	boardDao.fileupload(board);
    }
 
}
