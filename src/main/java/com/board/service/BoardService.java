package com.board.service;


import java.util.List;

import com.board.dto.BoardDto;
import com.board.dto.PageDto;

public interface BoardService {
 
    public List<BoardDto> boardList(String keyfield, String keyword);
    public BoardDto findBySeq(int seq);
    public BoardDto viewContent(int seq);
    public void insertBoard(BoardDto board);
    public int updateBoard(BoardDto board, String pass);
    public String deleteView(int seq);
    public int deleteBoard(int seq, String storpass);
    public void replyBoard(BoardDto board);
    public void replyUpPos(BoardDto board);
    public PageDto pagingProc(int nowPage, int nowBlock, int totalRecord);
}
