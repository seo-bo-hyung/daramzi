package com.imageboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.common.dao.AbstractDAO;
import com.imageboard.vo.ImageBoardVO;

@Repository("imageboardDao")
public class ImageBoardDao extends AbstractDAO  {

	@SuppressWarnings("unchecked")
	public List<ImageBoardVO> imageboardList(ImageBoardVO imageboardVO) {
        List<ImageBoardVO> result = new ArrayList<ImageBoardVO>();
        result = (List<ImageBoardVO>)selectList("imageboard.imageboardList",imageboardVO);
        return result;
    }
    
	public int imageboardListCnt(ImageBoardVO imageboardVO) {
        int resultCnt = (Integer)selectOne("imageboard.imageboardListCnt",imageboardVO);
        return resultCnt;
    }
 
    public String preView(int seq) {
		/* String preContent = BoardManager.preView(seq); */
        String preContent = "";
        return preContent;
    }
    
    //글 수정시 내용 조회
    public ImageBoardVO findBySeq(int seq) {
    	ImageBoardVO result = (ImageBoardVO) selectOne("imageboard.findBySeq",seq);
        return result;
    }
 
    public ImageBoardVO imageviewContent(int seq) {
    	update("imageboard.readCount",seq);	// 글보면 카운트수 증가
    	ImageBoardVO result = new ImageBoardVO();
    	result = (ImageBoardVO) selectOne("imageboard.findBySeq",seq);
        return result;
    }
 
    // 글쓰기는  upPos와 insertBoard 두개임
    public void upPos(){
		/*
		 * BoardManager.upPos(); System.out.println(" 글을 쓰면 Pos 1업");
		 */
    }
        
    public void insertimageBoard(ImageBoardVO imageboard) {
        //upPos();
        insert("imageboardWrite.insertimageBoard", imageboard);
    }
 
    
    // 게시글 수정,삭제는 바로 리턴 ...... 글쓰기는 void처리
    public int updateimageBoard(ImageBoardVO imageboard) {
    	update("imageboardWrite.updateimageBoard",imageboard);
        return 1;
    }
 
    // 글삭제
    public int deleteimageBoard(ImageBoardVO imageboard) {
		 delete("imageboardWrite.deleteimageBoard",imageboard);
		 return 1;
    }
 
    public String deleteimageView(int seq) {
		/*
		 * String storPass = BoardManager.deleteView(seq); return storPass;
		 */
        return "";
    }
 
    public void replyimageBoard(ImageBoardVO imageboard) {
		/* BoardManager.replyboard(imageboard); */
    }
 
    public void replyUpPos(ImageBoardVO imageboard) {
		/* BoardManager.replyUpPos(imageboard); */
    }
    
    
    public void fileupload(ImageBoardVO imageboard) {
    	insert("fileupload.fileupload", imageboard);
    }
    
    public void mkDir(ImageBoardVO imageboard) {
    	insert("fileupload.mkDir", imageboard);
    }
    public void delDir(ImageBoardVO imageboard) {
    	delete("fileupload.delDir", imageboard);
    }
    
    
    
    public ImageBoardVO selectFile(String fileIdx) {
    	ImageBoardVO result = new ImageBoardVO();
    	result = (ImageBoardVO) selectOne("imageboard.selectFile",fileIdx);
        return result;
    }
    
    public String deleteFile(String fileIdx) {
    	delete("imageboard.deleteFile",fileIdx);
        return "1";
    }
}
