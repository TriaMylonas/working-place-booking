package dev.triamylo.workingplacebooking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // SOS --> /images/** --> all unter one ordner so that they can authenticate with one's
        //all can use the home page and can add new user, all the others musst be authenticated
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/home", "/images/**").permitAll()
                        .requestMatchers("/booking").hasRole("ADMIN") // die Liste kann von ADMIN ausgerufen und bearbeiten werden.
                        .anyRequest()
                        .authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)  // das ist die default site from the security. (permitAll) I don't need to have permit to access in the login form.
                .logout((logout) -> logout.logoutSuccessUrl("/").permitAll()); //(permitAll) I don't need to have permit to access in the logout form & goes to the start site again.
        return http.build();

    }
}
