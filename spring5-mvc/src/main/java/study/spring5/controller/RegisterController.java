package study.spring5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @RequestMapping("/register/step1")
    public String handleStep1() {
        System.out.println("zzzzzzzzzzzzzz");
        return "register/step1";
    }
}
