package com.spring.mvc.controller;

import com.spring.mvc.controller01.MobilePhoneDTO;
import org.junit.jupiter.api.Test;

public class MobilePhoneDTOTest {

    @Test
    public void MobilePhoneDTOTest(){
        MobilePhoneDTO mobilephone = new MobilePhoneDTO();
        System.out.println("setter 확인: "+mobilephone);
    }
}
