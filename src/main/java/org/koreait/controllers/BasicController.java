package org.koreait.controllers;

import org.koreait.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ex03")
public class BasicController {

    @GetMapping
    public String ex01(Model model){

        List<Member> memberList = new ArrayList<>();

        for(int i=1;i<10; i++) {
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userId("user"+i)
                    .userPw("123456")
                    .userNm("사용자"+i)
                    .build();

            memberList.add(member);
        }

        model.addAttribute("memberLists",memberList);

        return "ex02";
    }

    @GetMapping("/main/index")
    public String ex09(){
        return "main/index";
    }
}

