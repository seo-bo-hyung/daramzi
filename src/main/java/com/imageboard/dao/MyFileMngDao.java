package com.imageboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.common.dao.AbstractDAO;
import com.imageboard.vo.MyFileMngVO;

@Repository("myFileMngDao")
public class MyFileMngDao extends AbstractDAO  {

	@SuppressWarnings("unchecked")
	public List<MyFileMngVO> myFileList(MyFileMngVO myFileMngVO) {
        List<MyFileMngVO> result = new ArrayList<MyFileMngVO>();
        result = (List<MyFileMngVO>)selectList("myFileMng.myFileList",myFileMngVO);
        return result;
    }
    
	public int myFileListCnt(MyFileMngVO myFileMngVO) {
        int resultCnt = (Integer)selectOne("myFileMng.myFileListCnt",myFileMngVO);
        return resultCnt;
    }

	public int updateFileInfo(MyFileMngVO myFileMngVO) {
		update("myFileMng.updateFileInfo",myFileMngVO);
        return 1;
    }
}

