package com.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.job.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class JobSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		//auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http
         .authorizeRequests()
         .antMatchers("/register.html","/login*","/registerNewUser").anonymous()
         .anyRequest().authenticated()
         .and()
         
         .formLogin()
         .loginPage("/login.html")
         .loginProcessingUrl("/login")
         .defaultSuccessUrl("/index.html",true)
         .failureUrl("/login.html?error=true")
         .and()
         .logout().logoutSuccessUrl("/login.html").and().sessionManagement().maximumSessions(1).expiredUrl("/login.html");
           disableCsrf(http);
         
            
		
	}
//	private void allowPublicPages(HttpSecurity http) throws Exception {
//       
//        http.authorizeRequests()
//        .antMatchers( "**/api/login", "/register", "/j_spring_security_check", "/dashboard", "/offerings",
//                "/css/**", "/js/**", "/ui/**", "/marketplace", "/vms", "/bootstrap-3.3.6-dist/**", "/img/**",
//                "/font*/**")
//        .permitAll();
//        swaggerDocs(http);
//    }

    private void swaggerDocs(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/v2/api-docs", "/swagger-resources", "/swagger-resources/**",
                "/swagger-ui.html", "/webjars/**").permitAll();
    }
    
    public void disableCsrf(HttpSecurity http) throws Exception
    {
    	http
    	.csrf().disable();
    	
    }



}
