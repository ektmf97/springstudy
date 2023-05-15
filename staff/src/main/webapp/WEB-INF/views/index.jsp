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
	
	$(function(){
		fnList();
	})
	
	function fnList(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType:'json',
			success: function(resData){ 
				$('#staffList').empty();
				$.each(resData, function(i, staff){
					let str ='<tr>';  
					str += '<td>' + staff.sno;
					str += '<td>' + staff.name;
					str += '<td>' + staff.dept;
					str += '<td>' + staff.salary;
					$('#staffList').append(str);
				})
			}
		})
	}
	
	function fnAdd(){
		$.ajax({
			type: 'post',
			url: '${contextPath}/add.do',
			data: $('#frm_add').serialize(),
			dataType: 'text',
			success: function(resData){ // resData: 사원 등록이 성공했습니다.
				alert(resData);
				fnList(); // 사원 정보를 갱신 - 사원목록을 호출해라 
				$('#sno').val(''); // 입력란 초기화 
				$('#name').val('');
				$('#dept').val('');
			}, 
			error: function(jqXHR){ // jqXHR.responseText: 사원 등록이 실패했습니다.
				alert(jqXHR.responseText);
			}
		})
	}
	
	// 목록에서 반복만 빼면 조회 
	function fnSearch(){
		$.ajax({
			type: 'get', // 사원 조회 명세서 http method가 겟방식
			// url: '${contextPath}/query.json',
			url: '${contextPath}/search.json',
			// data: 'query=' + $('#query').val(),
			data: $('#frm_search').serialize(), // 파라미터 
			dataType: 'json',
			success: function(resData){	
				 $('#staffList').empty(); // 사원목록 초기화 
				let str = '<tr>';
				str += '<td>' + resData.sno;
				str += '<td>' + resData.name;
				str += '<td>' + resData.dept;
				str += '<td>' + resData.salary;
				$('#staffList').append(str);
			},
			error: function(jqXHR){
				alert('조회된 사원 정보가 없습니다.') // 에러 메시지 
				fnList(); // 전체조회 
				$('#query').val(''); // 조회가 안되면 입력란 빈문자열
			}
		})
	}
	
	function fnAddStaff(){
		$('#btn_add').click(function(){
			var regSNO = /^[0-9]{5}$/;
			if (regSNO.test($('#sno').val()) == false) {
				alert("사원번호는 5자리 숫자입니다.");
				return;
			}
			var regDEPT = /^[가-힣]{3,5}$/;
			if (regDEPT.test($('#dept').val()) == false) {
				alert("부서는 3~5자리 한글입니다.");
				return;
			}
	}
</script>
</head>
<body>
	<div>
		<h3>사원등록</h3>
		<form id="frm_add">
			<input type="text" name="sno" id="sno" placeholder="사원번호">
			<input type="text" name="name" id="name" placeholder="사원명">
			<input type="text" name="dept" id="dept" placeholder="부서명">
			<input type="button" value="등록" onclick="fnAdd()">
		</form>
	</div>
	
	<hr>
	
	<div>
		<h3>사원조회</h3>
		<form id="frm_search">
			<input type="text" name="query" id="query" placeholder="사원번호입력">
			<input type="button" value="조회" onclick="fnSearch()">
			<input type="button" value="전체" onclick="fnList()">
		</form>
	</div>
	
	<hr>
	
	<div>
		<h3>사원목록</h3>
		<table border="1">
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>부서명</td>
					<td>연봉</td>
				</tr>
			</thead>
			<tbody id="staffList"></tbody>
		</table>
	</div>
	
</body>
</html>