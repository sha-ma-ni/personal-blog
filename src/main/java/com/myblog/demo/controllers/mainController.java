package com.myblog.demo.controllers;

import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class mainController {

    @GetMapping("/") //при переходе на главную страницу вызывается функция home
    public String home (Model model) {
        model.addAttribute("name", "Homepage");
        return "home";
    }

    @GetMapping ("/aboutme")
    public String about (Model model) {
        model.addAttribute("name", "About me");
        return "aboutme";
    }

}