package chap03.config;

import chap03.spring.MemberDao;
import chap03.spring.MemberPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConf1.class, AppConf2.class})
public class AppConfImport {

}
