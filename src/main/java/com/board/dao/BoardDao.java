package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.board.vo.BoardListVO;
import com.board.vo.BoardVO;
import com.happy.common.dao.AbstractDAO;

@Repository("boardDao")
public class BoardDao extends AbstractDAO  {
 

    // 상속받은걸 오버라이드함
    @SuppressWarnings("unchecked")
	public List<BoardVO> boardList(BoardListVO boardListVO) {
        List<BoardVO> result = new ArrayList<BoardVO>();
		/* result = BoardManager.boardList(keyfield, keyword); */
        
        result = (List<BoardVO>)selectList("board.boardList",boardListVO);
        return result;
    }
 
    public String preView(int seq) {
		/* String preContent = BoardManager.preView(seq); */
        String preContent = "";
        return preContent;
    }
 
    public BoardVO findBySeq(int seq) {
		/* BoardDto result = BoardManager.findBySeq(seq); */
        BoardVO result = new BoardVO();
        return result;
    }
 
    public BoardVO viewContent(int seq) {
//        BoardManager.readCount(seq);        // 글보면 카운트수 증가
//        BoardDto result = BoardManager.findBySeq(seq); // 실질적인 글읽기
    	BoardVO result = new BoardVO();
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
    public int updateBoard(BoardVO board, String pass) {
		/* return BoardManager.updateBoard(board, pass); */
        return 0;
    }
 
    // 게시글 수정,삭제는 바로 리턴
    public int deleteBoard(int seq, String storPass) {
		/* return BoardManager.deleteBoard(seq, storPass); */
    	return 0;
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

