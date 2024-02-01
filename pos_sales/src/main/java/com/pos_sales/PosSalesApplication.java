package com.pos_sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PosSalesApplication {

	@Autowired
	private EmailService senderService;
	
	public static void main(String[] args) {
		SpringApplication.run(PosSalesApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail() {
//		senderService.sendResetEmail("trishajoyoballo@gmail.com", "");
//	}
		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
							.allowedOrigins("https://dilven.vercel.app")
							.allowedMethods("*")
							.allowedHeaders("*")
							.allowCredentials(true)
							.exposedHeaders("Access-Control-Allow-Origin"); // Expose the Access-Control-Allow-Origin header
				}
			};
		}

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.authorizeRequests()
					.antMatchers("/**").permitAll() // Allow login URL without authentication
					.anyRequest().authenticated()
					.and().cors(); // Enable CORS
		}
	}

}
