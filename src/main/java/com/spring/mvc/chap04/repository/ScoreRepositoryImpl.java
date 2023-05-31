package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScoreRepositoryImpl implements ScoreRepository{

    // key : 학번, value : 성적정보
    private static final Map<Integer, Score> scoreMap;

    // 학번에 사용할 일련번호
    private static int sequence; // primary key로 사용할 학번을 체크해주는 변수, 0으로 자동 초기화

    // static(정적)변수를 초기화해줄 정적 블록 - 프로그램 시작 즉시 자동으로 한번 호출된다
    static{
        scoreMap = new HashMap<>();
        Score stu1 = new Score("김자바", 100, 50, 70, ++sequence, 0,0);
        Score stu2 = new Score("이부트", 33, 56, 0, ++sequence, 0,0);
        Score stu3 = new Score("박디비", 88, 12, 54, ++sequence, 0,0);

        scoreMap.put(stu1.getStudentNumber(), stu1);
        scoreMap.put(stu2.getStudentNumber(), stu2);
        scoreMap.put(stu3.getStudentNumber(), stu3);
    }

    // 실제로 구현해야 하는 기능들

    @Override
    public List<Score> findAll() {
        //System.out.println(scoreMap); 이해 안가면 주석풀고 확인해보기
        //System.out.println(scoreMap.values());

        // 빈 ArrayList생성
        List<Score> resultList = new ArrayList<Score>();
        // 반복문 이용해서 resultList에 Score 객체 채워넣기
        for(Score score : scoreMap.values()){
            resultList.add(score);
        }
        //System.out.println(resultList); 3개의 객체가 들어있음을 확인
        return resultList;
    }

    @Override
    public boolean save(Score score) {
        if(scoreMap.containsKey(score.getStudentNumber())){
            return false; // 이미 존재하는 학번이면 false 리턴
        }
        score.setStudentNumber(++sequence); // 사용된 적 없는 학번 정보 setter로 추가
        scoreMap.put(score.getStudentNumber(), score);
        return true;
    }

    @Override
    public boolean deleteByStudentNumber(int studentNumber) { // 학생 번호 입력시 알아서 삭제되도록 처리
        if(!scoreMap.containsKey(studentNumber)) return false; // 들어있지 않을때(!-not연산자) true를 리턴
        scoreMap.remove(studentNumber);
        return true;
    }

    @Override
    public Score findByStudentNumber(int studentNumber) {
        return scoreMap.get(studentNumber);
    }
}
