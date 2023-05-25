package com.spring.mvc.controller03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/chap03")
public class MVCController03 {

    // 음식 주문용 키오스크
    @RequestMapping(value = "/foodform", method = RequestMethod.GET)
    public String foodForm(){
        return "/chap03/foodform";
    }

    @GetMapping(value = "/foodresult")
    public ModelAndView foodOrder(String name, int tableNum, String orderFoodName){
        String viewName = "/chap03/foodresult";
        ModelAndView mv = new ModelAndView();

        // 목적지 뷰 이름 입력
        mv.setViewName(viewName);
        // 목적지로 보낼 데이터 입력
        mv.addObject("name",name);
        mv.addObject("tableNum", tableNum);
        mv.addObject("orderFoodName", orderFoodName);

        return mv;
    }
}
