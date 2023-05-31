<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>${score.studentNumber}번 학생 성적정보</h1>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>이름</th>
                    <th>국어</th>
                    <th>수학</th>
                    <th>영어</th>
                    <th>총점</th>
                    <th>평균</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${score.name}</td>
                    <td>${score.korScore}</td>
                    <td>${score.mathScore}</td>
                    <td>${score.engScore}</td>
                    <td>${score.korScore + score.mathScore + score.engScore}</td>
                    <td>${(score.korScore + score.mathScore + score.engScore)/3}</td>
                </tr>
            </tbody>
        </table><!-- 조회테이블 종료 지점 -->
        <a href="/score/list" class="btn btn-primary">목록</a> <!-- 전체 scoreList를 보여주는 버튼 -->
        <form action="/score/remove" method="POST"> <!-- 학생번호 입력시 학생정보를 삭제해주는 기능 추가 -->
            <input type="hidden" name="studentNumber" value="${score.studentNumber}">
            <input type="submit" class="btn btn-secondary" value="삭제하기">
        </form>
    </div>
</body>
</html>