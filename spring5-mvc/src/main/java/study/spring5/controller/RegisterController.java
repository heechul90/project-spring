package study.spring5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.spring5.error.DuplicateMemberException;
import study.spring5.service.MemberRegisterService;
import study.spring5.service.RegisterRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private MemberRegisterService memberRegisterService;

    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @RequestMapping("/step1")
    public String handleStep1() {
        return "register/step1";
    }

    /*@PostMapping("/step2")
    public String handleStep2(HttpServletRequest request) {
        String agreeParam = request.getParameter("agree");
        if (agreeParam == null || !agreeParam.equals("true")) {
            return "register/step1";
        }
        return "register/step2";
    }*/

    @PostMapping("/step2")
    public String handleStep2(@RequestParam(value="agree", defaultValue = "false") boolean agree) {
        System.out.println("zzzzz" + agree);
        if (!agree) {
            return "register/step1";
        }
        return "register/step2";
    }

    @GetMapping("/step2")
    public String handleStep2Get() {
        return "redirect:/register/step1";
    }

    @PostMapping("/step3")
    public String handleStep3(RegisterRequest registerRequest) {
        System.out.println("qqqqq=  " + registerRequest.getName());
        System.out.println("qqqqq=  " + registerRequest.getEmail());
        System.out.println("qqqqq=  " + registerRequest.getPassword());
        System.out.println("qqqqq=  " + registerRequest.getConfirmPassword());
        try {
            memberRegisterService.regist(registerRequest);
            return "register/step3";
        } catch (DuplicateMemberException e) {
            return "register/step2";
        }
    }
}
