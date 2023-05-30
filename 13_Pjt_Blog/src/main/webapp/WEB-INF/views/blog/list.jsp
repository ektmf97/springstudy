<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../layout/header.jsp">
  <jsp:param name="title" value="블로그" />
</jsp:include>

<div>

  <h1>블로그 목록</h1>
  
  <!-- 블로그 작성은 로그인을 해야 가능하다 -->
  <c:if test="${sessionScope.loginId ne null}"> 
    <div>
      <input type="button" value="블로그 작성하기" onclick="fnWrite()">
    </div>
  </c:if>
  
  <div>
    <table border="1">
      <caption style="text-alian: center;">${pagination}</caption>
      <thead>
        <tr>
          <td>번호</td>
          <td>제목</td>
          <td>조회수</td>
          <td>작성자</td>
          <td>작성일</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${blogList}" var="blog" varStatus="vs">
          <tr>
             <td>${beginNo - vs.index}</td>
            <td>
            <c:if test="${sessionScope.loginId eq blog.memberDTO.id}">
              <a href="${contextPath}/blog/detail.do?blogNo=${blog.blogNo}">${blog.title}</a></td>
            </c:if>
            <a href="${contextPath}/blog/increseHit.do?blogNo=${blog.blogNo}">${blog.title}</a></td>
            <td>${blog.hit}</td>
            <td>${blog.memberDTO.id}</td>
            <td>${blog.createdAt}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
<script>
// 스크립트를 맨 마지막에 두면 로드이벤트 고려할 필요없다 모든 구성요소가 인식이 된다
  function fnWrite() {
	 location.href = '${contextPath}/blog/write.form';
}
</script>
</div>
</body>
</html>
