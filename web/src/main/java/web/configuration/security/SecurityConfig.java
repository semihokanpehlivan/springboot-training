package web.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Semih Okan Pehlivan.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("pass")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("pass")
                .roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        *
        protected void configure(HttpSecurity http) throws Exception {
            logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

            http
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin().and()
                .httpBasic();

         The code of super class is like above.
            - This code says that, pls ensure, all request to our app requires user to be authenticated
         }*/
//        super.configure(http);
        http
                .csrf().disable()
//                authorized configuration
                .authorizeRequests()
                .antMatchers("/free").permitAll()
                .anyRequest().authenticated()
                .and()
//                form configuration
                .formLogin()
                .loginPage("/login")
                .passwordParameter("password")
                .usernameParameter("username")
                .permitAll()
                        //due to permitAll method, we let all user to access to login form
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")

                .permitAll();

//                .and()
//                .httpBasic();

//                type of authentication

    }

    /**
     * Configuration for api that only admin can access. Configuration on only "/free/api"
     *
     * @author Semih Okan Pehlivan
     * @since 0.1
     */
    @Configuration
    @Order(1)
    public static class FreeSecurityConfig extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/free/api")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN")
                    .and()

                    .formLogin()
                    .loginPage("/login")
                    .passwordParameter("password")
                    .usernameParameter("username")
                    .permitAll()

                    .and().httpBasic();
        }
    }
}
