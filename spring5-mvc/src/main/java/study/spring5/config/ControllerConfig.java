package study.spring5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.spring5.controller.HelloController;
import study.spring5.controller.RegisterController;
import study.spring5.service.MemberRegisterService;
import study.spring5.survey.SurveyController;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public RegisterController registerController() {
        RegisterController registerController = new RegisterController();
        registerController.setMemberRegisterService(memberRegisterService);
        return registerController;
    }

    @Bean
    public SurveyController surveyController() {
        return new SurveyController();
    }
}
