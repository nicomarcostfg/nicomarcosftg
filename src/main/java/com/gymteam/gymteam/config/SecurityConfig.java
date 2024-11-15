package com.gymteam.gymteam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gymteam.gymteam.servicios.TrabajadorDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final TrabajadorDetailsService trabajadorDetailsService;

    public SecurityConfig(TrabajadorDetailsService trabajadorDetailsService) {
        this.trabajadorDetailsService = trabajadorDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpsecurity) throws Exception {
        return httpsecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> http.anyRequest().authenticated())
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationconfiguration) throws Exception {
        return authenticationconfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider autenticationprovider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // No configuramos un PasswordEncoder, por lo tanto las contraseñas serán en texto claro.
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(trabajadorDetailsService);
        return provider;
    }
}






