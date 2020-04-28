<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" type="text/css" href="/resources/css/imageboard/style.css" />
<script language="javascript" type="text/javascript" src="/resources/js/imageBoard/imageBoard.js"></script>
</head>
 
<body>
    <form:form action="/imageboard/imageboardList" name="search" ModelAttribute="search" method="post">
        <table width=610 >
        		<tr>
	            <!-- 검색 part -->
	            <td align=Right>
		            <select name="keyField" size="1">
		                <option value="name" 	<c:if test="${search.keyField eq 'name'}"> 		selected</c:if>> 이름 </option>
		                <option value="title" 	<c:if test="${search.keyField eq 'title'}"> 	selected</c:if>> 제목 </option>
		                <option value="content" <c:if test="${search.keyField eq 'tag'}"> 		selected</c:if>> 태그 </option>
		            </select>
		            <input type="text" size="16" name="keyWord" value="${search.keyWord}">
		            <input type="button" value="검색" onClick="check_search()">
	            </td>
	            <tr>
 	            <!-- 리스트 선택 - 리스트 표시형태 -->
	            <td align=Right>
	            <select name="viewStyle" onchange="viewStyle_search()" >
	            	<option value="imageView"   <c:if test="${search.viewStyle eq 'imageView'}"> selected</c:if>> 이미지뷰보기  </option>
	            	<option value="listView"  	<c:if test="${search.viewStyle eq 'listView' }"> selected</c:if>> 리스트보기  </option>
				</select>
				</td>
	            
	            <!-- 리스트 선택 - 표시수 -->
	            <td align=Right>
	            <select name="listNum" onchange="listCnt_search()" >
	            	<option value="2"   <c:if test="${search.listNum eq '2'  }"> selected</c:if>> 2개씩보기  </option>
	            	<option value="20"  <c:if test="${search.listNum eq '20' }"> selected</c:if>> 20개씩보기  </option>
					<option value="50"  <c:if test="${search.listNum eq '50' }"> selected</c:if>> 50개씩보기  </option>
					<option value="100" <c:if test="${search.listNum eq '100'}"> selected</c:if>> 100개씩보기</option>
				</select>
				</td>
				<tr>
	            <!-- 정보 part -->
	            <td align=left>▶게시물수 : ${page.totalCount }개 </td><tr>
	            <td align=right valign=top>
	            
	            <!-- 페이지 이동시 값 유지를 위한 hidden 값 -->
				<input type="hidden" name="listNumOrg" 		value="${search.listNum}" /> 
		        <input type="hidden" name="keyFieldOrg" 	value="${search.keyField }" /> 
		        <input type="hidden" name="keyWordOrg" 		value="${search.keyWord }" />
		        <input type="hidden" name="page" 			value="${search.page}" /> 
		        <input type="hidden" name="pageYN" 			value="N" />
		        <input type="hidden" name="viewStyleOrg" 	value="${search.viewStyle}" />
        	</tr>                
        </table>
    </form:form>   
    
	<div id="paging">
		<!-- 1~10까지 있는 페이지의 페이징 -->
		<c:if test="${page.prev}">
		    <a href="javascript:pagemove(${page.beginPage+1})">prev</a>
		</c:if>
		<c:forEach begin="${page.beginPage}" end="${page.endPage}" step="1" var="index">
		    <c:choose>
		        <c:when test="${page.page==index}">
		            ${index}
		        </c:when>
		        <c:otherwise>
		            <a href="javascript:pagemove(${index})"> ${index}</a>
		        </c:otherwise>
		    </c:choose>
		</c:forEach>
		<c:if test="${page.next}">
		    <a href="javascript:pagemove(${page.endPage+1})">next</a>
		</c:if>
	</div>    
   	전체선택 <input id="ck_all" type="checkbox"/>
	
   
    <!-- 게시글 상세 -->
    <form action="/board/boardView" name="read" method="post"  >
        <input type="hidden" name="seq"/>
		<input type="hidden" name="listNum" 	value="${search.listNum}" /> 
        <input type="hidden" name="keyField" 	value="${search.keyField }" /> 
        <input type="hidden" name="keyWord" 	value="${search.keyWord }" />
        <input type="hidden" name="page" 		value="${search.page}" /> 
        <input type="hidden" name="pageYN" 		value="N" />
        <input type="hidden" name="viewStyle" 	value="${search.viewStyle}" />
    </form>
    
<form:form action="/imageboard/fileChk" id="chkFile" name="chkFile" ModelAttribute="chkFile" method="post">


<!-- <input type="button" value="선택삭제" onClick="go_chkDel()"> -->
<input type="button" value="선택파일다운" onClick="go_chkDown()">
<input type="hidden" name="sendStyle"/> 

<input type="button" value="사진올리기" onClick="go_upload(${authInfo.name })">
<input type="button" value="내사진관리" onClick="go_myFile(${authInfo.name })">    
    
<c:choose>
<c:when test="${search.viewStyle eq 'listView'}"> <!-- 리스트로 표시 -->

		    
		    <table class="bbs" width="610" border="2" bgcolor="D8D8D8">
		        <colgroup>
		            <col width="50" />
		            <col width="100"/>
		            <col width="100" />
		            <col width="50" />
		        </colgroup>
		        <thead>
		            <tr>
		                <th>선 택</th>
		                <th>제 목</th>
		                <th>이미지 미리보기</th>
		                <th>삭 제</th>
		            </tr>
		        </thead>
		        <tbody>
		            <tr>
		                <c:choose>
		                    <c:when test="${empty resultlist }">
		                    	<td colspan="5" align="center">
		                    		등록된 글이 없습니다.
		                    	</td>
		                    </c:when>
		                    <c:otherwise>
		                        <c:set var="doneLoop" value="false" />
		                        <c:forEach var="fileDtl" items="${resultlist}">
		                                <c:if test="${not doneLoop }">
		                                    <tr id="${fileDtl.fileIdx}">
		                                        <td align=center>
													<c:if test="${fileDtl.down_yn eq 'Y'}"> <!-- 다운 가능일 경우 체크 가능 -->
														<input type="checkbox" name="idxArr" value="${fileDtl.fileIdx}"/>
													</c:if>
												</td>
		                                        <td>
		                                            <!-- depth --> 
		                                            <c:if test="${fileDtl.depth != 0 }">
		                                                <c:forEach begin="0" end="${fileDtl.depth}">
		                                                </c:forEach>
		                                            </c:if>
		                                        	${fileDtl.fileName }
		                                        </td>
		                                        <td>
                          							<a style="cursor:pointer;" onclick="javascript:viewPic('/resources/uploadImage/${fileDtl.folderPath}/${fileDtl.fileRealName}')">
			                                        	<img alt="" src="/resources/uploadImage/${fileDtl.folderPath}/${fileDtl.fileRealName}" style="width: 100px; height:auto;">
		                                        	</a>
                                        		</td>
                                        		<td>
													<c:if test="${fileDtl.id eq authInfo.id}"> <!-- 파일 등록 아이디와 세션 아이디 동일할 경우 삭제 가능 -->
														<a href="javascript:void(0);" onclick="go_fileDel(${fileDtl.fileIdx});">삭제</a>
													</c:if>
                                        		</td>
		                                    </tr>
		                                </c:if>
		                        </c:forEach>
		                    </c:otherwise>
		                </c:choose>
		        </tbody>
		        <tfoot></tfoot>
		    </table>

</c:when>


<c:otherwise> <!-- 이미지로 표시 -->

	<table width="600" id="viewTable" align="center" style="font-family: &; font-size: 10pt;" cellspacing="2" cellpadding="1">
				<tr>
					<td style="border-bottom: 2px solid #DBDBDB;" colspan="3"></td>
				</tr>
				<%
					int newLine = 0;
					int articleCount=0; 
					int cnt = 0;
				%>
				<c:forEach var="fileDtl" items="${resultlist}">
				
					<c:if test="${fileDtl.open_yn eq 'Y'}"> <!-- 공개 여부에 따른 이미지 표시 -->
						<%
						 if(newLine ==0){
							 out.print("<tr>");
						 }
						newLine++;
						articleCount++;
						%>
						<td id="${fileDtl.fileIdx}" align="center" valign="bottom" width= "190">
							
							<a style="cursor:pointer;" onclick="javascript:viewPic('/resources/uploadImage/${fileDtl.folderPath}/${fileDtl.fileRealName}')">
								<img alt="" src="/resources/uploadImage/${fileDtl.folderPath}/${fileDtl.fileRealName}" style="width: 190px; height:auto;" title="${fileDtl.fileDescription}"><br>
								${fileDtl.fileName }
							</a>
							<br>
							
							<!-- 본인이 추천한것인지 확인하기 위함 -->
						      <c:choose>
						         <c:when test = "${fileDtl.recommendYN eq 'Y'}">
						            	<input type="button" value="좋아요  ${fileDtl.recommendYcnt}" id="${fileDtl.fileIdx}_recommendY" style="background-color:red" onClick="fn_recommend(${fileDtl.fileIdx},'Y')">
						            	<input type="button" value="싫어요  ${fileDtl.recommendNcnt}" id="${fileDtl.fileIdx}_recommendN" onClick="fn_recommend(${fileDtl.fileIdx},'N')">
						         </c:when>
						         <c:when test = "${fileDtl.recommendYN eq 'N'}">
						            	<input type="button" value="좋아요  ${fileDtl.recommendYcnt}" id="${fileDtl.fileIdx}_recommendY" onClick="fn_recommend(${fileDtl.fileIdx},'Y')">
						            	<input type="button" value="싫어요  ${fileDtl.recommendNcnt}" id="${fileDtl.fileIdx}_recommendN" style="background-color:red" onClick="fn_recommend(${fileDtl.fileIdx},'N')">
						         </c:when>
						         <c:otherwise>
						            	<input type="button" value="좋아요  ${fileDtl.recommendYcnt}" id="${fileDtl.fileIdx}_recommendY" onClick="fn_recommend(${fileDtl.fileIdx},'Y')">
										<input type="button" value="싫어요  ${fileDtl.recommendNcnt}" id="${fileDtl.fileIdx}_recommendN" onClick="fn_recommend(${fileDtl.fileIdx},'N')">
						         </c:otherwise>
						      </c:choose>
							
							<c:if test="${fileDtl.down_yn eq 'Y'}"> <!-- 다운 가능일 경우 체크 가능 -->
								<input type="checkbox" name="idxArr" value="${fileDtl.fileIdx}"/>
							</c:if>
							
							<c:if test="${fileDtl.id eq authInfo.id}"> <!-- 파일 등록 아이디와 세션 아이디 동일할 경우 삭제 가능 -->
								<a href="javascript:void(0);" onclick="go_fileDel(${fileDtl.fileIdx});">삭제</a>
							</c:if>
						</td>
						<%
						if(newLine==3){ // 한줄에 3개의 이미지를 보여주기위한 count
						
						out.print("</tr>"); 
						newLine = 0; // 3개의 이미지가 표시될경우 줄바꾸고 다시 0으로 되돌림
						}
						%>
					</c:if>
				</c:forEach>
				<%
						while(newLine>0&&newLine<3){ 
							out.print("<td width='180'></td>"); 
							newLine++; 
						}
				
						out.print("</tr>"); 
				%>
				<tr>
					<td style="border-bottom: 2px solid #DBDBDB;" colspan="3"></td>
				</tr>
				<tr>
		
					<td align="center" colspan="3">
						<c:if test="${dataCount!=0}">
						${pagelndexList } 
						</c:if>
						
						<c:if test="${dataCount==0}"> | 등록된 파일이 없습니다. 
						</c:if>
					</td>
				</tr>
			</table>

</c:otherwise>
</c:choose>

</form:form>

</body>
</html>

