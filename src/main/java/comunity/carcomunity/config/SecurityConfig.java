package comunity.carcomunity.config;

import comunity.carcomunity.controller.MyLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource; //datasource를 주입 받음

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .authorizeRequests()
                    .antMatchers("/login", "/", "/index", "/css/**", "/images/**", "/js/**", "/join", "/join-ok", "/buy", "/search", "/posts-search", "/searchForm").permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/doLogin")
                    .usernameParameter("user_id")
                    .passwordParameter("user_pw")
                    .successHandler(new MyLoginSuccessHandler())
                .and()
                .logout()
                        .logoutUrl("/doLogout")
                        .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT user_id, user_pw, user_name FROM user WHERE user_id=?")//사용자 정보를 가져오는 쿼리를 사용한다는 뜻
                .authoritiesByUsernameQuery("SELECT user_name FROM user WHERE username=?")//권한 정보를 가져오는 함수인데 지금은 권한이 없어서 재정의
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}