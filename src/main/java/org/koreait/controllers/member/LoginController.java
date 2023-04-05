package org.koreait.controllers.member;

import jakarta.validation.Valid;
import org.modelmapper.internal.Errors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class LoginController {

    @GetMapping("/login")
    public String login(Model model){
        Login login = new Login();
        model.addAttribute("login",login);

        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(@Valid Login login, Errors errors){
        if(errors.hasErrors()){
            return "member/login";
        }
        return "redirect:/";
    }
}
