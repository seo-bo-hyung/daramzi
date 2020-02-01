package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.board.dto.BoardDto;
/*import com.board.mybatis.BoardManager;*/
 
@Service("boardDaoImpl")
public class BoardDaoImpl implements BoardDao{
        
    
    // 상속받은걸 오버라이드함
    @Override
    public List<BoardDto> boardList(String keyfield, String keyword) {
        List<BoardDto> result = new ArrayList<BoardDto>();
        System.out.println("정상적으로 값이 들어옴");
        System.out.println(keyfield + "//" + keyword);
		/* result = BoardManager.boardList(keyfield, keyword); */
        System.out.println(result.size());
        return result;
    }
 
    @Override
    public String preView(int seq) {
		/* String preContent = BoardManager.preView(seq); */
        String preContent = "";
        return preContent;
    }
 
    @Override
    public BoardDto findBySeq(int seq) {
		/* BoardDto result = BoardManager.findBySeq(seq); */
        BoardDto result = new BoardDto();
        return result;
    }
 
    @Override
    public BoardDto viewContent(int seq) {
//        BoardManager.readCount(seq);        // 글보면 카운트수 증가
//        BoardDto result = BoardManager.findBySeq(seq); // 실질적인 글읽기
    	BoardDto result = new BoardDto();
        return result;
    }
 
    // 글쓰기는  upPos와 insertBoard 두개임
    public void upPos(){
		/*
		 * BoardManager.upPos(); System.out.println(" 글을 쓰면 Pos 1업");
		 */
    }
        
    public void insertBoard(BoardDto board) {
        upPos();
		/* BoardManager.insertBoard(board); */
    }
    // --------------------------------------------- 여기까지
 
    
    // 게시글 수정,삭제는 바로 리턴 ...... 글쓰기는 void처리
    public int updateBoard(BoardDto board, String pass) {
		/* return BoardManager.updateBoard(board, pass); */
        return 0;
    }
 
    // 게시글 수정,삭제는 바로 리턴
    public int deleteBoard(int seq, String storPass) {
		/* return BoardManager.deleteBoard(seq, storPass); */
    	return 0;
    }
 
    @Override
    public String deleteView(int seq) {
		/*
		 * String storPass = BoardManager.deleteView(seq); return storPass;
		 */
        return "";
    }
 
    @Override
    public void replyBoard(BoardDto board) {
		/* BoardManager.replyboard(board); */
    }
 
    @Override
    public void replyUpPos(BoardDto board) {
		/* BoardManager.replyUpPos(board); */
    }
 
}


