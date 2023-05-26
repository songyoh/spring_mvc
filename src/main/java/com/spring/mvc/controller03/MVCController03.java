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

    @RequestMapping(value = "/foodresult", method=RequestMethod.POST)
    public ModelAndView foodOrder(String name, int tableNum, String orderFoodName){
        // 목적지 뷰 이름 입력
        //String viewName = "/chap03/foodresult";
        //mv.setViewName(viewName);

        // ModelAndView 객체 준비
        ModelAndView mv = new ModelAndView();
        // 결과 view 파일 지정
        mv.setViewName("/chap03/foodresult");
        // 목적지로 보낼 데이터 입력
        mv.addObject("name",name);
        mv.addObject("tableNum", tableNum);
        mv.addObject("orderFoodName", orderFoodName);

        return mv;
    }

    @RequestMapping("/naver")
    public String naver(){
        // 리다이렉트는 "redirect:보낼주소"; 형식으로 문자를 작성하면 실행된다
        // 마치 html <a>태그를 클릭하는 것처럼 자동으로 페이지를 보낼주소로 이동시킨다
        // 이 과정에서 포워딩과는 달리 model.addAttribute()처럼 자료를 첨부해 이동시킬수는 없다.
        // 하지만 get방식으로 이동하는 만큼 쿼리스트링을 붙여서 보내는것은 가능하다
        return "redirect:https://www.naver.com";
    }

    @RequestMapping("/goFoodform")
    public String goFoodForm(Model model){
        // 리다이렉션은 model.addAttribute()를 통한 데이터 전송이 불가능하다
        model.addAttribute("title","음식주문 키오스크"); // test라는 이름으로 "test"문자열 적재
            // http://localhost:8080/chap03/foodform 이라는 주소로 이동(리다이렉트이므로 파일지정이 아님)
        //return "redirect:/chap03/foodform"; // 목적 파일로 포워딩하지 않고 목적 메서드 주소로 리다이렉트(리다이렉트방식)
            // /WEB-INF/views/chap03/foodform/jsp 라는 목적 파일로 포워딩
        return "/chap03/foodform"; // 목적 파일인 foodform.jsp로 적재 데이터도 보내는 포워딩 방식
    }

    // 리다이렉트는 데이터 전달이 불가능할까?
    // GET방식은 url에 쿼리스트링을 붙여서 데이터를 전송하기때문에
    // 리다이렉트 타겟 url에 쿼리스트링을 붙여 리다이렉트를 수행하면 전달 가능하다.

    //리다이렉트로 전달하는 케이스(네이버의 데이터를 전달하는)
    @RequestMapping("/searchform")
    public String searchForm(){
        // /WEB-INF/views/chap03/searchform.jsp
        return "/chap03/searchform";
    }

    // 네이버에 쿼리를 받아서 리다이렉션 해주는 메소드 세팅
    @RequestMapping("/research")
    public String reSearch(String query){ // query라는 변수에 실려서 전송된 데이터 받기(GET에서만 허용되는 방식)
        String resultpage = "redirect:https://search.naver.com/search.naver?query=" + query;// 영문만 처리가능...
        return resultpage;
        //return "redirect:https://search.naver.com/search.naver?query=" + query; - 이렇게도 가능한 구문(다만 영문만 처리가능)
    }











}
