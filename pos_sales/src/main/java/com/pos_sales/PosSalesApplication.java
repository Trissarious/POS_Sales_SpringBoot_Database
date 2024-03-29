package com.pos_sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
//		@Bean
//		public WebMvcConfigurer corsConfigurer() {
//			return new WebMvcConfigurer() {
//				@Override
//				public void addCorsMappings(CorsRegistry registry) {
//					registry.addMapping("/**")
//							.allowedOrigins("https://dilven.vercel.app")
//							.allowedMethods("*")
//							.allowedHeaders("*")
//							.allowCredentials(true)
//							.exposedHeaders("Access-Control-Allow-Origin"); // Expose the Access-Control-Allow-Origin header
//				}
//			};
//		}

}
