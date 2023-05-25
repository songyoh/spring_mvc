package com.spring.mvc.controller01;

import lombok.Data;

@Data
public class MobilePhoneDTO {
    private String modelName; // 핸드폰 모델명
    private int price; // 핸드폰 가격
    private String color; // 핸드폰 색상
    private String brandName; // 핸드폰 제조사명

}
