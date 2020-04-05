package com.imageboard.service;


import java.util.List;

import com.imageboard.vo.ImageBoardVO;

public interface ImageBoardService {
 
    public List<ImageBoardVO> imageboardList(ImageBoardVO imageboardVO); 
    public int imageboardListCnt(ImageBoardVO imageboardVO);
    
    public ImageBoardVO findBySeq(int seq);
    public ImageBoardVO imageviewContent(int seq);
    public void insertimageBoard(ImageBoardVO imageboardVO);
    public int updateimageBoard(ImageBoardVO imageboardVO);
    public String deleteimageView(int seq);
    public int deleteimageBoard(ImageBoardVO imageboardVO);
    public void replyimageBoard(ImageBoardVO imageboardVO);
    public void replyUpPos(ImageBoardVO imageboardVO);
    
    public void fileupload(ImageBoardVO imageboardVO);
    
    public ImageBoardVO selectFile(String fileIdx);
    public String deleteFile(String fileIdx);
}
