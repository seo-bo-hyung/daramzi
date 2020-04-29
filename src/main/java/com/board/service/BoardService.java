package com.board.service;


import java.util.List;

import com.board.vo.BoardVO;

public interface BoardService {
 
    public List<BoardVO> boardList(BoardVO boardVO); 
    public int boardListCnt(BoardVO boardVO);
    
    public BoardVO findByIdx(int boardIdx);
    public BoardVO viewContent(int boardIdx);
    public void insertBoard(BoardVO board);
    public int updateBoard(BoardVO board);
    public String deleteView(int boardIdx);
    public int deleteBoard(BoardVO board);
    public void replyBoard(BoardVO board);
    public void replyUpPos(BoardVO board);
    
    public void fileupload(BoardVO board);
}
