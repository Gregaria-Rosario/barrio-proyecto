package com.gregaria.proyectobarrio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 *
 * @author Nahue
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Security extends WebSecurityConfigurerAdapter /*implements WebMvcConfigurer*/ {

   /* @Autowired
    @Qualifier("userService")
    public UserService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).
                passwordEncoder(new BCryptPasswordEncoder());
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .and().formLogin()
                .loginPage("/")
                .loginProcessingUrl("/logincheck")
                .usernameParameter("mail")
                .passwordParameter("pass")
                .defaultSuccessUrl("/login/success")
                .failureUrl("/login?error=error")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()
                .and().csrf()
                .disable();
    }

//    @Bean
//    public MyDialect myDialect() {
//      return new MyDialect();
//    }

//    @Bean
//    public ClassLoaderTemplateResolver templateResolver() {
//
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//
//        templateResolver.setPrefix("templates/");
//        templateResolver.setCacheable(false);
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("UTF-8");
//
//        return templateResolver;
//    }

//    @Bean
//    public SpringTemplateEngine templateEngine() {
//
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.addDialect(new FinanceExpressionDialect());
//
//        return templateEngine;
//    }
}
