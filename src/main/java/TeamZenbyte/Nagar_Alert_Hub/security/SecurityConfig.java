package TeamZenbyte.Nagar_Alert_Hub.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth ->
                auth.requestMatchers("/nagar-alert-hub-alert/alert-list").permitAll()
                        .requestMatchers("/nagar-alert-hub-alert/add-alert").permitAll()
                        .anyRequest()
                        .authenticated());
        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withUsername("neal")
//                .password(passwordEncoder.encode("pass_admin"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user2 = User.withUsername("user")
//                .password(passwordEncoder.encode("upass"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
}
