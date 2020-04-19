package com.imageboard.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imageboard.dao.MyFileMngDao;
import com.imageboard.vo.MyFileMngVO;
 
@Service("myFileMngService")
public class MyFileMngServiceImpl implements MyFileMngService {
 
    @Resource(name="myFileMngDao")
    private MyFileMngDao myFileMngDao;
    
    @Override
    public List<MyFileMngVO> myFileList(MyFileMngVO myFileMngVO) {
        return myFileMngDao.myFileList(myFileMngVO);
    }
    
    public int myFileListCnt(MyFileMngVO myFileMngVO) {
        return myFileMngDao.myFileListCnt(myFileMngVO);
    }
    
    public int updateFileInfo(MyFileMngVO myFileMngVO) {
        return myFileMngDao.updateFileInfo(myFileMngVO);
    }
  
}
