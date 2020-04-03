package com.board.service;


import java.util.List;

import com.board.vo.BoardVO;

public interface BoardService {
 
    public List<BoardVO> boardList(BoardVO boardVO); 
    public int boardListCnt(BoardVO boardVO);
    
    public BoardVO findBySeq(int seq);
    public BoardVO viewContent(int seq);
    public void insertBoard(BoardVO board);
    public int updateBoard(BoardVO board);
    public String deleteView(int seq);
    public int deleteBoard(BoardVO board);
    public void replyBoard(BoardVO board);
    public void replyUpPos(BoardVO board);
    
    public void fileupload(BoardVO board);
}
