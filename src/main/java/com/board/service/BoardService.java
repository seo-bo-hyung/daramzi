package com.board.service;


import java.util.List;

import com.board.vo.BoardListVO;
import com.board.vo.BoardVO;
import com.board.vo.PageVO;

public interface BoardService {
 
    public List<BoardVO> boardList(BoardListVO boardListVO); 
    public BoardVO findBySeq(int seq);
    public BoardVO viewContent(int seq);
    public void insertBoard(BoardVO board);
    public int updateBoard(BoardVO board, String pass);
    public String deleteView(int seq);
    public int deleteBoard(int seq, String storpass);
    public void replyBoard(BoardVO board);
    public void replyUpPos(BoardVO board);
    public PageVO pagingProc(int nowPage, int nowBlock, int totalRecord);
}
