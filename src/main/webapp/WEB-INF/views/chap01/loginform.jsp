<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>로그인 하세요</h1>
    
    <form action="http://localhost:8080/login" method="POST">
        user id: <input type="text" name="id"><br>
        user pw : <input type="password" name="pw"><br>
        <input type="submit" value="로그인하기">
    </form>
</body>
</html>