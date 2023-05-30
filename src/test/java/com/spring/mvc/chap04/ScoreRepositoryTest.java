package com.spring.mvc.chap04;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import com.spring.mvc.chap04.repository.ScoreRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*; // static요소로 Assert구문 사용시 alt+enter키로 등록해야함
import static org.assertj.core.api.Assertions.assertThat; // deleteTest()구문작성시 사용된 assertThat() 임포트문수기로 입력

public class ScoreRepositoryTest {

    // 테스트 대상인 ScoreRepositoryImpl 클래스를 상단에 선언해둔다.
    ScoreRepository repository = new ScoreRepositoryImpl();
    //coreRepository repository; 선언만하고 초기화를 안할경우 에러발생

    @Test
    public void ScoreRepositoryStaticVarTest(){
        // 접근 제한자가 public으로 풀려있는 동안만 실행 가능
        //System.out.println(ScoreRepositoryImpl.scoreMap);
        //System.out.println(ScoreRepositoryImpl.sequence);
    }

    // TDD 방법
    // 1. 원본 클래스에 원하는 기능을 구현하지는 말고 선언만 해둔다.
    // 2. 테스트 코드 내부에 원하는 기능대로 작성되었을때 어떤 결과가 나올지 단언(기술)해둔다.
    // 3. 테스트가 통과될때까지, 원본 클래스를 수정하면서 계속 테스트 해본다.
    @Test
    public void findAllTest(){ // 범위가 정해졌기 때문에 수정불가
        // GWT 패턴(AAA 패턴)
        // GIVEN : 테스트를 위해 사전에 설정해야 하는 데이터를 선언하는 구간

        // findAll은 특별한 조건없이 전체데이터를 가져오므로 GIVEN이 없다.
        // WHEN : 테스트 대상 메소드를 실행하는 구간으로, 보통 한 줄로 작성함
        List<Score> result = repository.findAll();

        // THEN : 테스트 결과가 이렇다. 라는 단언을 한다.
        // 나는 result 내부에 3개의 Score가 있다고 단언한다.
        // scoreMap에 사전설정으로 3개의 데이터를 넣었으므로, 3개가 나와야 정상인 상황
        System.out.println(result.size() == 3);
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("저장소에서 2번 유저를 불러와 이름과 국어성적 비교")
    public void findByStudentNumberTest(){
        // given - 사전조건 (test. 2번학생 정보가 실제 정보와 일치하는지 체크할 예정임)
        int studentNumber = 2;
        // when (test. 2번 학생정보를 넣어 findByStudentNumber를 호출하고, 결과는 result에 저장 - 무조건 1줄에 끝내야 한다.
        Score result = repository.findByStudentNumber(studentNumber);
        // then - 단언부에는 2개 이상의 단언문이 들어가도 상관없다.
        // 2번 유저를 얻어왔으므로, getter로 국어성적 조사시 33점일 것이다.
        assertEquals(33, result.getKorScore());
        // 2번 유저를 얻어왔으므로, getter로 이름 조사시 "이자바"일 것이다.
        assertEquals("이부트", result.getName());
    }

    @Test
    @DisplayName("없는 번호로 조회시 null이어야함.")
    public void notfindByStudentNumberTest(){
        // given
        int studentNumber = 99;
        // when
        Score result = repository.findByStudentNumber(studentNumber);
        // then
        assertNull(result); // 조사대상 변수가 null이면 통과, 아니면 실패
    }

    @Test
    @DisplayName("새로운 성적정보를 저장하면 전체 데이터의 개수는 4개가 된다.")
    public void saveTest(){
        // given
        Score score = new Score();
        score.setName("티디디");
        score.setKorScore(100);
        score.setEngScore(70);
        score.setMathScore(80);
        // when
        boolean boolResult = repository.save(score);
        List<Score> result = repository.findAll(); // 저장한 후 전체 데이터 가져오기
        // then
        assertEquals(4, result.size());
        assertTrue(boolResult); // 실행이 잘 되면 true, 오류면 false
    }

    @Test
    @DisplayName("저장소에서 2번 학생 삭제 후 리스트 전체조회시 개수는 2개, 다시 2번학생 조회시 null")
    public void deleteTest(){
        // given : 학생 번호 저장
        int studentNumber = 2;

        // when : 해당번호 학생 삭제, findAll()로 전체 데이터 가져오기 실행, 2번학생만 조회도 실행해보기 - 삭제 되었는지 검증
        boolean result = repository.deleteByStudentNumber(studentNumber);// 삭제 성공시 true 리턴
        List<Score> scoreList = repository.findAll(); // 2개의 데이터만 조회됨
        Score score = repository.findByStudentNumber(studentNumber); // null이 조회됨

        // then : 전체목록의 길이는 2, score 변수에는 null이 담긴다고 단언
        /*System.out.println(scoreList.size() == 2);*/
        assertThat(scoreList.size()).isEqualTo(2); // 아래 문법과 같은 단언문
        //assertEquals(2, scoreList.size());
        assertNull(score);
        assertTrue(result); // 삭제성공시 true

    }




}
