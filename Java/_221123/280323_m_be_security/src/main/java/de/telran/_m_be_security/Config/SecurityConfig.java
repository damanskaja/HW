package de.telran.g_280323_m_be_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        x -> x
                                .requestMatchers(HttpMethod.GET, "/user/all").permitAll()
                                .requestMatchers(HttpMethod.GET, "/user/name").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, "/user/save").hasRole("ADMIN")
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        x -> x
                                .requestMatchers(HttpMethod.GET, "/user/all").permitAll()
                                .requestMatchers(HttpMethod.GET, "/user/name").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, "/user/save").hasRole("ADMIN")
                                // Добавить разрешения для новых функций
                                .requestMatchers(HttpMethod.GET, "/user/product/{productId}").authenticated()
                                .requestMatchers(HttpMethod.POST, "/user/cart/add/{productId}").hasRole("USER")
                                .requestMatchers(HttpMethod.DELETE, "/user/cart/remove/{productId}").hasRole("USER")
                                .requestMatchers(HttpMethod.DELETE, "/user/cart/clear").hasRole("USER")
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
