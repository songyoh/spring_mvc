## 커뮤니티버전 프로젝트 JDK 연결
1. File -> Project Structure 들어가기
2. Project Settings의 SDK를 버전 맞게(17버전)
3. File -> Settings 들어가기
4. gradle 검색 후 build tool의 gradle항목에서
    맨 하단 gradle JVM을 2에서 설정한 버전으로 맞추기
5. 우측 상단 코끼리 모양 아이콘 누르기(없으면 1시방향 녹색 재생버튼)

---
## 서버 실행
1. src->main->java->com.spring.mvc->MvcApplication 실행
2. 크롬 주소창에 localhost:8080 쳐보기
3. 다시 MvcApplication 실행 후 Run버튼 누르고 크롬창 다시 새로고침
4. 'Whitelabel Error Page'라고 뜨면 네트워크 연결됨..
---
## JSP 자바 서버 페이지 -> 자카르타 서버 페이지
-자바로 웹서비스를 만드는 것<br>
-무거운 구조로써 성능유지가 어려운..
---
# MVC
---
## vscode에서 .jsp파일 템플릿 설정하기
1. vscode 좌측 하단 톱니바퀴 모양 클릭
2. 사용자 코드 조각(user snipets) 클릭 후 html 입력
3. html.json 파일에 아래 코드 붙여넣고 저장
4. .jsp파일 생성후 !jsp를 입력하면 템플릿이 자동완성 된다
```
    "JSP template": {
		"prefix": "!jsp",
		"body": [
			"<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>",
			"<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>",
			"<!DOCTYPE html>",
			"<html>",
			"<head>",
			"<meta charset=\"UTF-8\">",
			"<title>Insert title here</title>",
			"</head>",
			"<body>",
			"</body>",
			"</html>",
		],
		"description": "make jsp template"
	}
```
### 만약 인텔리제이에서 바로 .jsp를 만들어 쓰고싶다면
https://xzio.tistory.com/1298
위 블로그 참조.

---

# TDD방식 레포지토리 구현
1. 학생 성적정보 등록화면을 보여주고, 성적정보 목록조회 처리 - 조회구문
/score/list : GET방식(DB변경 없음)
2. 성적정보 등록 처리 요청
/score/register : POST방식(DB변경 생김)
3. 성적정보 삭제 요청
/score/remove : POST방식(DB변경 생김)
4. 성적정보 상세 요청 - 조회구문
/score/detail : GET방식(DB변경 없음)
