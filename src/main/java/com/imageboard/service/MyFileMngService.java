package com.imageboard.service;


import java.util.List;

import com.imageboard.vo.MyFileMngVO;

public interface MyFileMngService {
 
    public List<MyFileMngVO> myFileList(MyFileMngVO myFileMngVO); 
    public int myFileListCnt(MyFileMngVO myFileMngVO);
    
    public int updateFileInfo(MyFileMngVO myFileMngVO);
    
}
