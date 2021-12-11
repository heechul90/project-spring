package chap07.main;

import chap07.config.AppCtx;
import chap07.factorial.Calculator;
import chap07.factorial.RecCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean("calculator", Calculator.class);
        long fivFact = cal.factorial(5);
        System.out.println("fivFact = " + fivFact);
        System.out.println(cal.getClass().getName());
        ctx.close();
    }
}
