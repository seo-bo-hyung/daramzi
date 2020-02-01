package com.board.dao;

import java.util.List;

import com.board.dto.BoardDto;
 
public interface BoardDao {
 
    public List<BoardDto> boardList(String keyfield, String keyword);
    public String preView(int seq);
    public BoardDto findBySeq(int seq);
    public BoardDto viewContent(int seq);
    public void insertBoard(BoardDto board);
    public int updateBoard(BoardDto board, String pass);
    public String deleteView(int seq);
    public int deleteBoard(int seq, String storPass);
    public void replyBoard(BoardDto board);
    public void replyUpPos(BoardDto board);
 
}

