package study.spring5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping("/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @RequestMapping("/step2")
    public String handleStep2() {
        return "register/step2";
    }

    @RequestMapping("/step3")
    public String hendleStep3() {
        return "register/step3";
    }
}
