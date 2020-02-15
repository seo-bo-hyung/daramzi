    
	//검색 버튼
	function check_search() {
        if (document.search.keyWord.value == "") {
            alert("검색어를 입력하세요.");
            document.search.keyWord.focus();
            return;
        }
        document.search.submit();
    }
    
    //드롭리스트 검색
    function listCnt_search() {
        document.search.submit();
    }
    
    //페이지 이동
    function pagemove(i) {
        document.search.page.value = Number(i);
        document.search.submit();
    }
    
    //게시판 글 보기
    function read(seq) {
        document.read.seq.value = seq; // 해당 게시글 번호
        document.read.submit();
    }
    
    //게시판 글 수정
    function modContent(seq) {
        document.modContent.seq.value = seq; // 해당 게시글 번호
        document.modContent.submit();
    }

    function go_write() {
    	location.href="/board/boardWrite";
    }    
    
    
    //목록으로 돌아가기
    function list() {
    	document.search.submit();
    }
    
 

 

 
    function blockmovef() {
        document.blockmovef.submit();
    }
 
    function blockMoveb() {
        console.log("##" + document.blockmoveb.nowBlock.value);
        document.blockmoveb.submit();
    }
    ///////////////////////////////////////////////////////////////////////////////////    
    var xmlHttp;
 
    var xmlDoc;
 
    var message;
 
    function contentprev(seq) {
 
        var url = "boardAjax.action?seq=" + seq; //미리보기 서블릿 호출
 
        xmlHttp = createXMLHttpRequest();
 
        xmlHttp.onreadystatechange = handleStateChange;
 
        xmlHttp.open("get", url, true);
 
        xmlHttp.send(null);
 
    }
 
    function handleStateChange() {
 
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                xmlDoc = xmlHttp.responseText;
                document.getElementById("layer1").innerHTML = xmlDoc;
            }
 
        }
 
    }
 
    function showlayer(id) {
        if (document.all[id]) {
            document.all[id].style.visibility = "visible";
        } else if (document.layers[id]) {
            document.layers[id].style.visibility = "visible";
        }
 
    }
 
    function hidelayer(id) {
        if (document.all[id])
            document.all[id].style.visibility = "hidden";
 
        else if (document.layers[id])
            document.layers[id].style.visibility = "hidden";
 
    }
 
    function movetip() {
        layer1.style.marginTop = event.y + document.body.scrollTop + 10 +"px";
        
        layer1.style.marginLeft = event.x + document.body.scrollLeft + 10 +"px";
    }
 
//    document.onmousemove = movetip;