package com.imageboard.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imageboard.dao.ImageBoardDao;
import com.imageboard.vo.ImageBoardVO;
 
@Service("imageboardService")
public class ImageBoardServiceImpl implements ImageBoardService {
 
    @Resource(name="imageboardDao")
    private ImageBoardDao imageboardDao;
    
    @Override
    public List<ImageBoardVO> imageboardList(ImageBoardVO imageboardVO) {
        return imageboardDao.imageboardList(imageboardVO);
    }
    
    public int imageboardListCnt(ImageBoardVO imageboardVO) {
        return imageboardDao.imageboardListCnt(imageboardVO);
    }
 
    public ImageBoardVO findBySeq(int seq) {
        return imageboardDao.findBySeq(seq);
    }
 
    @Override
    public ImageBoardVO imageviewContent(int seq) {
        return imageboardDao.imageviewContent(seq);
    }
 
    @Override
    public void insertimageBoard(ImageBoardVO imageboard) {
        imageboardDao.insertimageBoard(imageboard);        
    }
 
    @Override
    public int updateimageBoard(ImageBoardVO imageboard) {
        return imageboardDao.updateimageBoard(imageboard);
    }
 
    @Override
    public String deleteimageView(int seq) {
        return imageboardDao.deleteimageView(seq);
    }
 
    @Override
    public int deleteimageBoard(ImageBoardVO imageboard) {
        return imageboardDao.deleteimageBoard(imageboard);
    }
 
    @Override
    public void replyimageBoard(ImageBoardVO imageboard) {
        imageboardDao.replyimageBoard(imageboard);
    }
 
    @Override
    public void replyUpPos(ImageBoardVO imageboard) {
        imageboardDao.replyUpPos(imageboard);
    }
    
    @Override
    public void fileupload(ImageBoardVO imageboard) {
        imageboardDao.fileupload(imageboard);
    }
    
    @Override
    public ImageBoardVO selectFile(String fileIdx) {
    	System.out.println("selectFile 탄다");
    	return imageboardDao.selectFile(fileIdx);
    }
    
    @Override
    public String deleteFile(String fileIdx) {
        return imageboardDao.deleteFile(fileIdx);
    }
 
}
