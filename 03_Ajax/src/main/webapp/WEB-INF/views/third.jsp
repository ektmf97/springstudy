<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var ="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	function fn1() {
		$.ajax({
			// 요청
			type: 'post',  // 서버로 보낼 데이터를 요청 본문(request body)에 저장해서 보낸다.
			url: '${contextPath}/third/ajax1',
			data: JSON.stringify({ // 문자열 형식의 JSON 데이터를 서버로 보낸다. 파라미터 이름이 없음에 주의한다!
				'name': $('#name').val(), // 프로퍼티랑 값을 한번에 작성 
				'tel': $('#tel').val() // 사용자가 입력한 프로퍼티에 객체로 만듬 
			}), // 별도 라이브러리가 필요하지 않음
			// 예시 - data: '{"name": "kim", "tel": "010-1234-5678"}'
			contentType: 'application/json', // 서버로 보내는 data의 타입을 서버에 알려준다.
			// 응답
			dataType: 'json',
			success: function(resData){ // resData = {"name": "민경태", "tel": "010-1234-5678"}
				let str = '<ul>';
				str += '<li>' + resData.name;
				str += '<li>' + resData.tel;
				$('#result').html(str); // 업핸드는 기존에 있던거에 추가하기 
			}, 
			error: function(jqXHR){
				if(jqXHR.status == 400){
					alert('이름과 전화번호는 필수입니다.');
				}
			}
		})
		
	}
	
	function fn2(){
		tyep: 'post',
		url: '#{contextPath}/third/ajax2',
		data:,
		dataType:,
		success: function(){
			
		},
		error: function(jqXHR){
			if(jqXHR.status == 400){
				alert('');
			}
		}
	}
</script>
</head>
<body>

	<div>
		<form id="frm">
			<div>
				<label for="name">이름</label>
				<input id="name" name="name" >
			</div>
			<div>
				<label for="tel">전호번호</label>
				<input id="tel" name="tel" >
			</div>
			<div>
				<input type="button" value="전송1" onclick="fn1()">
				<input type="button" value="전송2" onclick="fn2()">
			</div>
		</form>
	</div>
	
	<hr>
	
	<div id="result"></div>
</body>
</html>