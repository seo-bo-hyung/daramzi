package com.board.vo;

public class BoardListVO {

	private String keyField;
	private String keyWord;
	
    private int listNum = 20;
    private int start;

    private int listNumOrg;
	private String keyFieldOrg;
	private String keyWordOrg;
    private int page = 1;
    private String pageYN;
	public String getKeyField() {
		return keyField;
	}
	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public int getListNum() {
		return listNum;
	}
	public void setListNum(int listNum) {
		this.listNum = listNum;
	}
	public int getStart() {
		int start = this.getListNum() * (this.getPage()-1);
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getListNumOrg() {
		return listNumOrg;
	}
	public void setListNumOrg(int listNumOrg) {
		this.listNumOrg = listNumOrg;
	}
	public String getKeyFieldOrg() {
		return keyFieldOrg;
	}
	public void setKeyFieldOrg(String keyFieldOrg) {
		this.keyFieldOrg = keyFieldOrg;
	}
	public String getKeyWordOrg() {
		return keyWordOrg;
	}
	public void setKeyWordOrg(String keyWordOrg) {
		this.keyWordOrg = keyWordOrg;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPageYN() {
		return pageYN;
	}
	public void setPageYN(String pageYN) {
		this.pageYN = pageYN;
	}
   
    
    
}
