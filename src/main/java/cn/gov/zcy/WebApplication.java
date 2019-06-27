package cn.gov.zcy;

import com.neusoft.cas.AuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "cn.gov.zcy",
        "org.jasig.cas.client",
        "com.neusoft"
})
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        new SpringApplication(WebApplication.class).run(args);
    }
}
