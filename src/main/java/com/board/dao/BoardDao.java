package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.board.vo.BoardVO;
import com.common.dao.AbstractDAO;

@Repository("boardDao")
public class BoardDao extends AbstractDAO  {

	@SuppressWarnings("unchecked")
	public List<BoardVO> boardList(BoardVO boardVO) {
        List<BoardVO> result = new ArrayList<BoardVO>();
        result = (List<BoardVO>)selectList("board.boardList",boardVO);
        return result;
    }
    
	public int boardListCnt(BoardVO boardVO) {
        int resultCnt = (Integer)selectOne("board.boardListCnt",boardVO);
        return resultCnt;
    }
 
    public String preView(int seq) {
		/* String preContent = BoardManager.preView(seq); */
        String preContent = "";
        return preContent;
    }
    
    //글 수정시 내용 조회
    public BoardVO findBySeq(int seq) {
    	BoardVO result = (BoardVO) selectOne("board.findBySeq",seq);
        return result;
    }
 
    public BoardVO viewContent(int seq) {
    	update("board.readCount",seq);	// 글보면 카운트수 증가
    	BoardVO result = new BoardVO();
    	result = (BoardVO) selectOne("board.findBySeq",seq);
        return result;
    }
 
    // 글쓰기는  upPos와 insertBoard 두개임
    public void upPos(){
		/*
		 * BoardManager.upPos(); System.out.println(" 글을 쓰면 Pos 1업");
		 */
    }
        
    public void insertBoard(BoardVO board) {
        //upPos();
        insert("boardWrite.insertBoard", board);
    }
 
    
    // 게시글 수정,삭제는 바로 리턴 ...... 글쓰기는 void처리
    public int updateBoard(BoardVO board) {
    	update("boardWrite.updateBoard",board);
        return 1;
    }
 
    // 글삭제
    public int deleteBoard(BoardVO board) {
		 delete("boardWrite.deleteBoard",board);
		 return 1;
    }
 
    public String deleteView(int seq) {
		/*
		 * String storPass = BoardManager.deleteView(seq); return storPass;
		 */
        return "";
    }
 
    public void replyBoard(BoardVO board) {
		/* BoardManager.replyboard(board); */
    }
 
    public void replyUpPos(BoardVO board) {
		/* BoardManager.replyUpPos(board); */
    }
}

