<%@page import="mul.cam.a.dto.MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%


// 웹에 메세지를 띄우는 작업은 컨트롤러가 아닌 jsp로
String message = (String)request.getAttribute("message");
if(message != null && !message.equals("")){
	if(message.equals("MEMBER_YES")) {
		%>
		<script type="text/javascript">
		alert("성공적으로 가입되었습니다");
		location.href = "login.do";
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
		alert("가입되지 않았습니다 다시 가입해주세요");
		location.href = "regi.do";
		</script>
		<%
	}
}

String logIn = (String)request.getAttribute("logIn");
if(logIn != null && !logIn.equals("")){
	if(logIn.equals("LOGIN_OK")) {
		%>
		<script type="text/javascript">
		alert("로그인 성공!");
		location.href = "bbslist.do";
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
		alert("로그인 실패!");
		location.href = "login.do";
		</script>
		<%
	}
}

String bbswrite = (String)request.getAttribute("bbswrite");
if(bbswrite != null && !bbswrite.equals("")){
	if(bbswrite.equals("BBS_ADD_OK")){
		%>
		<script type="text/javascript">
		alert("작성 완료");
		location.href = "bbslist.do";
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
		alert("작성 실패");
		location.href = "bbswrite.do";
		</script>
		<%
	}
}

String bbsAns = (String)request.getAttribute("bbsAns");

if(bbsAns != null && !bbsAns.equals("")) {
	if(bbsAns.equals("BBS_ANS_OK")){
		%>
		<script type="text/javascript">
		alert("답글 작성 완료");
		location.href = "bbslist.do";
		</script>
		<%
	}else{
		int seq = (Integer)request.getAttribute("seq");
		%>
		<script type="text/javascript">
		alert("작성 실패");
		let seq = "<%=seq %>";
		location.href = "bbsdetail.do?seq=" + seq;
		</script>
		<%
	}
}

String bbsUp = (String)request.getAttribute("bbsUp");

if(bbsUp != null && !bbsUp.equals("")) {
	if(bbsUp.equals("BBS_UP_OK")){
		%>
		<script type="text/javascript">
		alert("답글 수정 완료");
		location.href = "bbslist.do";
		</script>
		<%
	}else{
		int seq = (Integer)request.getAttribute("seq");
		%>
		<script type="text/javascript">
		alert("수정 실패");
		let seq = "<%=seq %>";
		location.href = "bbsdetail.do?seq=" + seq;
		</script>
		<%
	}
}

String bbsDel = (String)request.getAttribute("bbsDel");

if(bbsDel != null && !bbsDel.equals("")) {
	if(bbsDel.equals("BBS_DEL_OK")){
		%>
		<script type="text/javascript">
		alert("답글 삭제 완료");
		location.href = "bbslist.do";
		</script>
		<%
	}else{
		int seq = (Integer)request.getAttribute("seq");
		%>
		<script type="text/javascript">
		alert("삭제 실패");
		let seq = "<%=seq %>";
		location.href = "bbsdetail.do?seq=" + seq;
		</script>
		<%
	}
}
/*
// null과 빈 문자열 체크를 꼭 해줘야한다
// message.jsp로 넘어가면 가장 위에 MemberDto login부터 순서대로 내려오므로 다른 문자열 중에 빈칸이 있을 시 에러로 발현할 수 있다
String calwrite = (String)request.getAttribute("calwrite");
if(calwrite != null && !calwrite.equals("")) {
	if(calwrite.equals("CAL_ADD_OK")){
		%>
		<script type="text/javascript">
		alert('일정 추가 완료');
		location.href = "cal?param=calendar&id=<%=login.getId() %>";
		</script>
		<%
	}else{
		int year = (Integer)request.getAttribute("year");
		int month = (Integer)request.getAttribute("month");
		int day = (Integer)request.getAttribute("day");
		%>
		<script type="text/javascript">
		alert('일정 추가 실패');
		location.href = "cal?param=calwrite&year=" + year + "&month=" + month + "&day=" + day;
		</script>
		<%
	}
}

String calUp = (String)request.getAttribute("calUp");
if(calUp != null && !calUp.equals("")) {
	if(calUp.equals("CAL_UP_OK")){
		%>
		<script type="text/javascript">
		alert('일정 변경 완료');
		location.href = "cal?param=calendar&id=<%=login.getId() %>";
		</script>
		<%
	}else{
		int seq = (Integer)request.getAttribute("seq");
		%>
		<script type="text/javascript">
		alert('일정 추가 실패');
		location.href = "cal?param=caldetail&seq=" + seq;
		</script>
		<%
	}
}

String calDel = (String)request.getAttribute("calDel");
if(calDel != null && !calDel.equals("")) {
	if(calDel.equals("CAL_DEL_OK")){
		%>
		<script type="text/javascript">
		alert('삭제 완료');
		location.href = "cal?param=calendar&id=<%=login.getId() %>";
		</script>
		<%
	}else{
		int seq = (Integer)request.getAttribute("seq");
		%>
		<script type="text/javascript">
		alert('삭제 실패');
		location.href = "cal?param=caldetail&seq=" + seq;
		</script>
		<%
	}
}
*/
String sessionOut = (String)request.getAttribute("sessionOut");
if(sessionOut != null && !sessionOut.equals("")) {
	%>
	<script type="text/javascript">
	alert('로그인 해주세요');
	location.href = "login.do";
	</script>
	<%
}

%>


