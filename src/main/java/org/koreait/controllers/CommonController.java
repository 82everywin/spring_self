package org.koreait.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("org.koreait.controllers")
public class CommonController {

    @ExceptionHandler(Exception.class)
    // controllers 패키지 내에 모든 클래스에서 exception.class 예외가 발생하면
    // 아래의 메서드를 실행
    public String errorHandler(Exception e, Model model){
        e.printStackTrace();
        model.addAttribute("message",e.getMessage());
        return "error/common";
    }

}
