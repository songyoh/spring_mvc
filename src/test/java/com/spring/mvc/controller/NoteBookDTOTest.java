package com.spring.mvc.controller;

import com.spring.mvc.controller01.NoteBookDTO;
import org.junit.jupiter.api.Test;

public class NoteBookDTOTest {

    @Test
    public void NoteBookDTOTest(){
        NoteBookDTO notebook = new NoteBookDTO();
        notebook.getRam(); // getter 생성 확인됨.
        notebook.setModelName("MACBOOK PRO M2"); // setter 동작 여부 확인
        System.out.println("setter 확인: "+notebook); //@Data 사용시 toString()메소드 사용해보면 데이터 정보가나옴
        // toString()-notebook의 주소값리턴, 생성여부 확인
    }
}
