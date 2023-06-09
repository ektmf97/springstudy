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
	// recordPerPage의 변경
	$('#recordPerPage').on('change', function(){
		location.href = '${contextPath}/employees/change/record.do?recordPerPage=' + $(this).val();  // session에 recorePerPage 올리기
	})
	// 세션에 저장된 recordPerPage값으로 <select> 태그의 값을 세팅
	let recordPerPage = '${sessionScope.recordPerPage}' == '' ? '10' : '${sessionScope.recordPerPage}';
	$('#recordPerPage').val(recordPerPage);
	// 제목을 클릭하면 정렬 방식을 바꿈
	$('.title').on('click', function(){
		location.href = '${contextPath}/employees/pagination.do?column=' + $(this).data('column')+'&order='+  $(this).data('order') + "&page=${page}";
	})
})
</script>
<style>
.titls {
	cursor: pointer;
}
.title:hover{
	color: pink;
}
.title:active{
	color: gray;
}
.pagination {
	width: 350px;
	margin: 0 auto;
	text-align: center;
}
.pagination span, .pagination a {
	display: inline-block;
	width: 50px;
}
.hidden {
	visibility: hidden;
}
.strong {
	font-weight: 900;
}
.link {
	color: orange;
}
table {
	width: 1500px;
}
table td:nth-of-type(1) {width:100px;}
table td:nth-of-type(2) {width:150px;}
table td:nth-of-type(3) {width:300px;}
</style>
</head>
<body>
	
	<div>
		<a href="${contextPath}/employees/search.do">사원 조회 화면으로 go</a>
	</div>
	
	<div>
		<h1>사원 목록</h1>
		<div>
			<select id="recordPerPage">
				<option value="10">10개</option>
				<option value="20">20개</option>
				<option value="30">30개</option>
			</select>
		</div>
		<hr>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td><span class="title" data-order="${order}" data-column="E.EMPLOYEE_ID">사원번호</span></td>
					<td><span class="title" data-order="${order}" data-column="E.FIRST_NAME">사원명</span></td>
					<td><span class="title" data-order="${order}" data-column="E.EMAIL">이메일</span></td>
					<td><span class="title" data-order="${order}" data-column="E.PHONE_NUMBER">전화번호</span></td>
					<td><span class="title" data-order="${order}" data-column="E.HIRE_DATE">입사일자</span></td>
					<td><span class="title" data-order="${order}" data-column="E.JOB_ID">직업</span></td>
					<td><span class="title" data-order="${order}" data-column="E.SALARY">연봉</span></td>
					<td><span class="title" data-order="${order}" data-column="E.COMMISSION_PCT">커미션</span></td>
					<td><span class="title" data-order="${order}" data-column="E.MANAGER_ID">매니저</span></td>
					<td><span class="title" data-order="${order}" data-column="E.DEPARTMENT_ID">부서번호</span></td>
					<td><span class="title" data-order="${order}" data-column="D.DEPARTMENT_NAME">부서명</span></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp" varStatus="vs">
					<tr>
						<td>${beginNo - vs.index}</td>
						<td>${emp.employeeId}</td>
						<td>${emp.firstName} ${emp.lastName}</td>
						<td>${emp.email}</td>
						<td>${emp.phoneNumber}</td>
						<td>${emp.hireDate}</td>
						<td>${emp.jobId}</td>
						<td>${emp.salary}</td>
						<td>${emp.commissionPct}</td>
						<td>${emp.managerId}</td>
						<td>${emp.deptDTO.departmentId}</td>
						<td>${emp.deptDTO.departmentName}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="12">
						${pagination}
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>