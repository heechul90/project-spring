package chap06.main;

import chap06.config.AppCtxWithPrototype;
import chap06.spring.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWithPrototype {

    public static void main(String[] args) throws Exception {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithPrototype.class);
        Client client1 = ctx.getBean(Client.class);
        Client client2 = ctx.getBean(Client.class);

        System.out.println("client1 == client2 : " + (client1 == client2));
        ctx.close();
    }
}
