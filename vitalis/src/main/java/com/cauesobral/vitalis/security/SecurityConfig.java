package com.cauesobral.vitalis.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

//mínimo de segurança: libera todos os endpoints para testes
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desabilita CSRF — necessário para testar com Postman/cURL (sem sessão de browser)
            .csrf(AbstractHttpConfigurer::disable)
            // Permite todas as requisições sem autenticação
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        //implementar autenticação (JWT ou OAuth2) antes de ir para produção

        return http.build();
    }
}
