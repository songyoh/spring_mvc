package com.spring.mvc.chap04.repository;

    /*
        역할 명세(추상화-메소드만 정의)
        1. 전체 성적 조회
        2. 개별 성적 조회
        3. 성적 삭제
        4. 성적 등록
     */

import com.spring.mvc.chap04.entity.Score;

import java.util.List;

public interface ScoreRepository {

    // 전체 성적은 어떻게 받아올 것인지에 대한 문제가 있음
    // entity계층에 score라는 정보가 어떻게 구성되는지 먼저 정의
    // score라는 객체에 담아와서 처리
    public List<Score> findAll(); // 스코어 객체를 넘기겠다는 뜻

    // 성적 정보 등록
    // return자료는 boolean구문 등록 성공시 true, 실패시 false를 리턴
    boolean save(Score score); // 입력할 테이블 정보를 넘겨줘야 함

    // 성적 정보 한 개 삭제
    boolean deleteByStudentNumber(int studentNumber);

    // 성적 개별 조회
    Score findByStudentNumber(int studentNumber);

}
