package com.spring.mvc.controller01;



// LOMBOK 사용법

import lombok.Data;

@Data // 자동으로 getter, setter, 생성자 등을 만들어준다.
public class NoteBookDTO {

    // 커맨드 객체 패턴으로 컨트롤러의 파라미터로 처리하는 경우
    // 반드시 세터와 기본생성자가 만들어져 있어야 작동하는데
    // 위쪽에 롬복의 @Data 어노테이션을 이용해 생성해둔 상태임
    private String modelName; // 노트북 모델명
    private int price; // 노트북 가격
    private int ssd; // 노트북 용량
    private int ram; // 노트북 램

    /*@Override
    public String toString(){
        return "재정의된 toString() 메소드"; // 정보 은닉
    }*/

}
