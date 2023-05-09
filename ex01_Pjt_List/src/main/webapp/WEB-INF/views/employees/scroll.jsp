<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	//전역 변수
	var   // 현재 페이지 번호
	var  // 전체 페이지 개수 
	var   // 타이머 함수의 반환값
	
	// DB에서 목록을 가져오는 함수
	
		// 목록 숨기기
		
		// 로딩 보여주기
		
		// 목록을 가져오는 ajax 처리
		
			// 요청
			// page=1, page=2, page=3, ... 으로 동작
			// 응답
			 // resData = {"employees":[{},{},{}, ...], "totalPage": 12}
				// 전체 페이지 개수를 전역 변수 totalPage에 저장
				
				// 스크롤을 통해서 목록을 9개씩 가져올때마다 page가 증가해야 한다.
				
				// 화면에 뿌리기
				// $.each(배열, function(인덱스, 요소){})
				
				// 목록 보여주기
				
				// 로딩 숨기기

	 // fnGetEmployees
	// 함수 호출
	
	
	// 스크롤 이벤트 
	
		// timerId = setTimeout(function(){}, 200); // 200밀리초(0.2초) 후에 function()을 수행한다.
		
		// 스크롤 된 길이
		// 화면 높이(브라우저의 크기)
		// 문서 높이
		// 스크롤이 바닥에 닿기 전 50px 정도 위치(스크롤이 충분히 바닥까지 내려왔음)
		 // 마지막 페이지를 보여 준 상태에서는 스크롤이 이동해도 더 이상 
				
		 // 시간 결정을 각각 알아서 임의로 조정해도 된다.

	
</script>
<style>
	


	            /* justify-content, align-items 속성 사용을 위해 설정 */
		 /* class="loading"의 가로 가운데 정렬 */
		      /* class="loading"의 세로 가운데 정렬 */
	      /* 최소 높이를 화면 높이의 80%로 설정 */
	
	
</style>
</head>
<body>

	
	
</body>
</html>