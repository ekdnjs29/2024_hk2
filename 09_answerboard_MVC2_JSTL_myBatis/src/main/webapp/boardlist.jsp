<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>답변형 게시판</h1>
<div id="container">
	<h2>글목록 조회</h2>
	<table border="1">
		<col width="50px" />
		<col width="100px" />
		<col width="300px" />
		<col width="100px" />
		<col width="150px" />
		<col width="50px" />
		<col width="50px" />
		<col width="50px" />
		<col width="50px" />
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>삭제여부</th>
			<th>refer</th>
			<th>step</th>
			<th>depth</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="9">--작성된 글이 없습니다.--</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.seq}</td>
						<td>${dto.id}</td>
						<td>${fn:length(dto.title)>10?fn:substring(dto.title,0,10)+='...':dto.title}</td>
						<td>${dto.readCount}</td>
						<td><fmt:formatDate value="${dto.regDate}" pattern="yyyy년MM월dd일"/> </td>
						<td>${dto.delflag}</td>
						<td>${dto.refer}</td>
						<td>${dto.step}</td>
						<td>${dto.depth}</td>
					</tr>
				</c:forEach>
			</c:otherwise>		
		</c:choose>
		<tr>
			<td colspan="9" style="text-align: center;">
				<c:forEach begin="1" end="${pcount}" var="i" step="1">
					<a href="boardlist.board?pnum=${i}">${i}</a>&nbsp;&nbsp;
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="9">
				<button type="button" 
				     onclick="location.href='insertform.board'">글추가</button>
				<button>삭제</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>










