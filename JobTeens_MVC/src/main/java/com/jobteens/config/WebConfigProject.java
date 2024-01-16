package com.jobteens.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.jobteens.service.EmpresaUserDetailsService;
import com.jobteens.service.UsuarioUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebConfigProject {


	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/img/**", "/js/**", "/css/**").permitAll()
				.requestMatchers("/", "/vagas/vagasdisponiveis", "/carreira", "/sobrenos").permitAll()
				.requestMatchers("/usuarios/cadastrar", "/empresa/cadastrar").permitAll()
				.anyRequest().authenticated())

				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/usuarios")
						.permitAll())

				.logout(logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.permitAll()
						.logoutSuccessUrl("/"));

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder,
			UsuarioUserDetailsService usuarioUserDetailsService, EmpresaUserDetailsService empresaUserDetailsService)
			throws Exception {

		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(usuarioUserDetailsService)
				.passwordEncoder(passwordEncoder).and().userDetailsService(empresaUserDetailsService)
				.passwordEncoder(passwordEncoder).and().build();
	}

}
