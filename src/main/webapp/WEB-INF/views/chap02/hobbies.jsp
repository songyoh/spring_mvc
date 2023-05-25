<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- h1+p+ol>c:forEach>li*1 -->

    <h1>${n}의 취미 목록</h1>
    <p>${hList}</p>
    <ol>
        <!-- java의 향상된 for문 for(var:list){}처럼 사용함 -->
        <!--  jsp에서 사용하는 for문 'c:forEach' -->
        <!-- ${hList}배열을 h번씩 나열 -->
        <c:forEach var="h" items="${hList}">
            <li>${h} 입니다.</li>
        </c:forEach>
    </ol>


</body>
</html>