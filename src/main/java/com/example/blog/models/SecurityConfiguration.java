package com.example.blog.models;
import com.example.blog.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
    @EnableWebSecurity
    public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserDetailsLoader userLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader){
        this.userLoader = usersLoader;
    }
        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Override
        protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(userLoader)
                .passwordEncoder(passwordEncoder())
                ;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    /* ..Login Config. */
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/titles")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutSuccessUrl("/login?logout")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/", "/titles", "/posts", "/posts/{id}")
                    .permitAll()
                    .and()
                    .authorizeRequests()
                    .antMatchers(
                            "/posts/edit",
                            "/posts/create"

                    )
                    .authenticated()
//                    .hasAuthority("ADMIN") // only admins can disable ads
            // .hasAnyAuthority("ADMIN", "SELLER") // You can specify several roles too
            ;
        }
        /* ... */
}
