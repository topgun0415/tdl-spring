package springboot.tdl.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/", "login", "logout").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/board/**").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()

        );






        return http.build();
    }
}
