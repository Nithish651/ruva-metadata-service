package com.financetracker.metadata.config;

import java.util.Collections;
import java.util.Objects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.financetracker.authflow.JwtService;
import com.financetracker.authflow.model.User;

@Configuration
public class ApplicationConfig {


	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
				User user = new User();
				user.setId(1L);
				user.setUserName("Nithish");
				user.setPassword("admin");

				if (Objects.isNull(user)) {
					throw new UsernameNotFoundException("No user found with this user name " + userName);
				}

				return new org.springframework.security.core.userdetails.User(user.getUserName(), new BCryptPasswordEncoder().encode(user.getPassword()),
						Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
			}
		};
	}

	@Bean
	public AuthenticationProvider authenticataionProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(getUserDetailsService());
		authProvider.setPasswordEncoder(getPassWordEncoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder getPassWordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public JwtService jwtSerivce() {
		return new JwtService();
	}

}
