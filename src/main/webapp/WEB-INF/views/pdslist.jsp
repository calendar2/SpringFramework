<%@page import="mul.cam.a.dto.PdsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
List<PdsDto> list = (List<PdsDto>)request.getAttribute("pdslist");
String choice = (String)request.getAttribute("choice");
String search = (String)request.getAttribute("search");
/* int pageBbs = (Integer)request.getAttribute("pageBbs");
int pageNumber = (Integer)request.getAttribute("pageNumber"); */
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>자료실</h1>
<hr>

<div align="center">
<table border="1">
<col width="50"><col width="100"><col width="300"><col width="50">
<col width="50"><col width="50"><col width="100">

<thead>
<tr>
	<th>번호</th><th>작성자</th><th>제목</th><th>다운로드</th>
	<th>조회수</th><th>다운수</th><th>작성일</th>
</tr>
</thead>

<tbody>
<%
for(int i = 0;i < list.size(); i++) {
	PdsDto pds = list.get(i);
	%>
	<tr>
		<th><%=i+1 %></th>
		<td><%=pds.getId() %></td>
		<td>
			<a href="pdsdetail.do?seq=<%=pds.getSeq() %>">
				<%=pds.getTitle() %>
			</a>
		</td>
		<td>
			<input type="button" value="다운로드"
				onclick="filedown(<%=pds.getSeq() %>, '<%=pds.getNewfilename() %>', '<%=pds.getFilename() %>')">
		</td>
		<td><%=pds.getReadcount() %></td>
		<td><%=pds.getDowncount() %></td>
		<td><%=pds.getRegdate() %></td>
	</tr>
	<%
}
%>

</tbody>
</table>
<br>

<%-- <%
for(int i = 0;i < pageBbs; i++){
	if(pageNumber == i){	// 현재 페이지
		%>
		<span style="font-size: 15pt;color: #0000ff">
			<%=i+1 %>
		</span>
		<%
	}else{					// 그밖에 다른 페이지
		%>
		<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
			style="font-size: 15pt; color: #000; text-decoration: none;">
			[<%=i+1 %>]
		</a>			
		<%
	}		
}
%> --%>
<br>
<button type="button" onclick="pdsWrite()">자료추가</button>
<br><br>

<select id="choice">
	<option value="">검색</option>
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="writer">작성자</option>
</select>
<input type="text" id="search" value="<%=search %>">
<button type="button" onclick="searchBtn()">검색</button>
</div>

<form name="file_down" action="filedownLoad.do" method="post">
	<input type="hidden" name="newfilename">
	<input type="hidden" name="filename">
	<input type="hidden" name="seq">
</form>

<script type="text/javascript">
let search = "<%=search %>";

if(search != ""){
	let obj = document.getElementById("choice");
	obj.value = "<%=choice %>";
	obj.setAttribute("selected", "selected");
}

function searchBtn() {
	let choice = document.getElementById('choice').value;
	let search = document.getElementById('search').value;
	
	location.href = "pdslist.do?choice=" + choice + "&search=" + search;
}
/*
function goPage( pageNumber ) {
	let choice = document.getElementById('choice').value;
	let search = document.getElementById('search').value;
	
	location.href = "pdslist.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNumber;	
}
*/
function pdsWrite() {
	location.href = "pdswrite.do";
}
function filedown(seq, newfilename, filename) {
	document.file_down.newfilename.value = newfilename;
	document.file_down.filename.value = filename;
	document.file_down.seq.value = seq;
	document.file_down.submit();
}
</script>

</body>
</html>