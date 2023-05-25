package com.spring.mvc.controller01;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Data 어노테이션은 순환참조 문제가 있어 쓰지 않는것을 권고함 - 실무에선 사용하지않음
@Getter @Setter               //NoArgumentConstructor
@ToString @NoArgsConstructor // @NoArgsConstructor:인수가 없는 생성자, 디폴트 생성자
public class DogDTO {
    private String name;
    private int age;
    private String kind;
}
