package com.board.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BoardVO {

    private int seq;
    private String name;
    private String email;
    private String homepage;
    private String title;
    private String content;
    private String password;
    private int count;
    private String ip;
    private String regdate;
    private int pos;
    private int depth;
    
	//게시판 리스트용
	private String keyField;
	private String keyWord;
	
    private int listNum = 20;
    private int start;

    private int listNumOrg;
	private String keyFieldOrg;
	private String keyWordOrg;
    private int page = 1;
    private String pageYN;
    
    
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	//게시판 리스트용 getter, setter
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
	
    public String toStringDefault() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
    public String toStringJson() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }    
    public String toStringMultiline() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    public String toStringNoClass() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }    
    public String toStringNoFieldName() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_FIELD_NAMES_STYLE);
    }
    public String toStringShortPrefix() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }    
    public String toStringSimple() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    } 

}
