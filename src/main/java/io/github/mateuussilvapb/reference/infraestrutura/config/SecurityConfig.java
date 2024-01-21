package io.github.mateuussilvapb.reference.infraestrutura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
/*
 * Nas versões anteriores, era necessário extender a classe WebSecurityConfigurerAdapter
 * do pacote org.springframework.security.config.annotation.web.configuration. Porém, nas
 * versões mais recentes do Spring, substituiram essa necessidade com a anotação @EnableWebSecurity.
 * */
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        authorizeConfig -> {
                            // Autoriaza o acesso a todas as rotas que possuem em seu prefixo a uri public
                            authorizeConfig.requestMatchers("/public").permitAll();
                            // Autoriaza o acesso a todas as rotas que possuem em seu prefixo a uri logout
                            authorizeConfig.requestMatchers("/logout").permitAll();
                            // Solicita que para todas as demais rotas, o acesso esteja autenticado
                            authorizeConfig.anyRequest().authenticated();
                        }
                )
                // Permite o acesso ao formulário de Login (próprio do Spring Security) com as constumizações padrões.
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
