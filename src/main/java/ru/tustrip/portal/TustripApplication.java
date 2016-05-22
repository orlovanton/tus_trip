package ru.tustrip.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

/**
 * Created by antonorlov on 20/05/16.
 */

@SpringBootApplication
public class TustripApplication {

    //todo: move to constatnts
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    public static void main(String[] args) {
        SpringApplication.run(TustripApplication.class, args);
    }

    /**
     *  Joda Time to Thymeleaf converter<br>
     *  Spring Boot, in the ThymeleafAutoConfiguration class,
     *  will automatically add any Beans that implement the IDialect interface.
     */
    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}
