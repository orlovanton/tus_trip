package ru.tustrip.portal;

import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

/**
 * Created by antonorlov on 22/05/16.
 */
//@Configuration
//@ConditionalOnClass({SpringSecurityDialect.class})
public class ThymeleafSecurityDialectConfiguration {

    protected ThymeleafSecurityDialectConfiguration() {
    }

//    @Bean
//    @ConditionalOnMissingBean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }
}
