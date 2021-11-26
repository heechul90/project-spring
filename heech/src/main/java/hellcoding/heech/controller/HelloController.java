package hellcoding.heech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!! heechul");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvs(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-world")
    public String helloWorld(Model model) {
        model.addAttribute("data", "Hello World!!!");
        return "hello-world";
    }
}
