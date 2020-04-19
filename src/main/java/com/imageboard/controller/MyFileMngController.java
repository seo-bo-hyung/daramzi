package com.imageboard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.vo.JsonObj;
import com.imageboard.service.MyFileMngService;
import com.imageboard.vo.MyFileMngVO;

@Controller
public class MyFileMngController {
    @Resource(name="myFileMngService")
    private MyFileMngService myFileMngService;
	
    //내파일 목록
    @ResponseBody
    @RequestMapping(value="/myFileMng/myFileList")
    public JsonObj test(
			@RequestParam(value = "page", required=false) String page,//page : 몇번째 페이지를 요청했는지
			@RequestParam(value = "rows", required=false) String rows,//rows : 페이지 당 몇개의 행이 보여질건지
			@RequestParam(value = "sidx", required=false) String sidx,//sidx : 소팅하는 기준이 되는 인덱스
			@RequestParam(value = "sord", required=false) String sord) {//sord : 내림차순 또는 오름차순
	    	
		// 그리드에 뿌려주려는 데이터를 DB에서나 어디에서 가져온다.
		JsonObj obj = new JsonObj();
		
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

		int int_page = Integer.parseInt(page);// 1 2 3
		int perPageNum = (int)Double.parseDouble(rows);
		
		MyFileMngVO sendParam = new MyFileMngVO();
		
		sendParam.setPage(int_page);
		sendParam.setRows(perPageNum);
		sendParam.setSidx(sidx);
		sendParam.setSord(sord);
		
    	int totalCount = myFileMngService.myFileListCnt(sendParam);
    	List<MyFileMngVO> resultlist = myFileMngService.myFileList(sendParam);

    	for(MyFileMngVO vo:resultlist){
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("fileIdx", vo.getFileIdx());
				map.put("fileSeq", vo.getFileSeq());
				map.put("fileName", vo.getFileName());
				map.put("fileRealName", vo.getFileRealName());
				map.put("fileSize", vo.getFileSize());
				map.put("board_idx", vo.getBoard_idx());
				map.put("userIdx", vo.getUserIdx());
				map.put("folderIdx", vo.getFolderIdx());
				map.put("del_yn", vo.getDel_yn());
				map.put("open_yn", vo.getOpen_yn());
				map.put("down_yn", vo.getDown_yn());
				map.put("fileDescription", vo.getFileDescription());
				map.put("ins_dt", vo.getIns_dt());
				map.put("upt_dt", vo.getUpt_dt());	
				
				list.add(map);

		}
    	
		// 그리고 이 JsonObj를 리턴해주면 @ResponseBody 애노테이션 그리고 Jackson라이브러리에 의해
		// json타입으로 페이지에 데이터가 뿌려지게 된다.
	       
	    obj.setRows(list);  // list<map>형태의 받아온 데이터를 가공해서 셋( 그리드에 뿌려줄 행 데이터들 )
	    	    
	    //page : 현재 페이지
	    obj.setPage(int_page);// 현재 페이지를 매개변수로 넘어온 page로 지정해준다. 
		
	    //records : 보여지는 데이터 개수
	    obj.setRecords(list.size());//?
		
	    //total : rows에 의한 총 페이지수
		// 총 페이지 갯수는 데이터 갯수 / 한페이지에 보여줄 갯수 이런 식
		int totalPage = (int)Math.ceil(totalCount/Double.parseDouble(rows));
		obj.setTotal( totalPage ); // 총 페이지 수 (마지막 페이지 번호)

	    return obj;
	}
	
    @RequestMapping("/myFileMng/myFileUpdate")
    public @ResponseBody String cellEdit(
        @RequestParam(value = "id") String id,
        @RequestParam(value = "cellName") String cellName,
        @RequestParam(value = "cellValue") String cellValue) {

    	System.out.println("id 확인 : " + id);
    	System.out.println("cellName 확인 : " + cellName);
    	System.out.println("cellValue 확인 : " + cellValue);
    	
		MyFileMngVO sendParam = new MyFileMngVO();
		
		sendParam.setFileIdx(id);
		sendParam.setCellName(cellName);
		sendParam.setCellValue(cellValue);
    	
    	int result = myFileMngService.updateFileInfo(sendParam);

        // Edit 구현하기


        return "SUCCESS";
    }
	
}
