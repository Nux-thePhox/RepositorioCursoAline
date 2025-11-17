package com.mx.Celular.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csfr -> csfr.disable())
                .authorizeHttpRequests(auth -> auth
                        //rutas public
                        .requestMatchers("api/Cel/listar").permitAll()
                        //rutas privadas acceso a un rol especifico
                        .requestMatchers("/api/Cel/guardar").hasRole("ADMIN")
                        //configuracion para que las rutas que no esten definidas en el filter,
                        //por defecto solo acceda un usuario authenticado
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public AuthenticationManager authMan(HttpSecurity http) throws Exception {
        // Obtiene el constructor de AuthenticationManager desde HttpSecurity
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        // Configura el AuthenticationManager con el servicio de usuarios y codificador
        authenticationManagerBuilder
                .userDetailsService(userDetailsService(passwordEncoder())) // Establece el servicio de usuarios
                .passwordEncoder(passwordEncoder()); // Establece el codificador de contraseñas

        // Construye y retorna el AuthenticationManager
        return authenticationManagerBuilder.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder pEncoder){
        List<UserDetails> userList = new ArrayList<>();
        userList.add(User.withUsername("Aline")
                .password(pEncoder.encode("1234"))
                .authorities("ROLE_ADMIN", "READ", "CREATE")
                .build());
        userList.add(User.withUsername("Maria")
                .password(pEncoder.encode("2345"))
                .authorities("ROLE_USER", "READ")
                .build());
        return new InMemoryUserDetailsManager(userList);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
