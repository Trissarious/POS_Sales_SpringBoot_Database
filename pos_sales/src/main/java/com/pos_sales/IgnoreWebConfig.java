// package com.pos_sales;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// //import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// ////import org.springframework.security.config.http.SessionCreationPolicy;
// //import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// //import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// @Configuration
// //@EnableWebSecurity
// public class WebConfig implements WebMvcConfigurer {
    
// //    @Bean
// //    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
// //    	http.cors().and().csrf().disable().authorizeRequests().antMatchers("/**").permitAll();
// //    	return http.build();
// //    	
// //    }
	
	
// 	// @Override
// 	// public void addCorsMappings(CorsRegistry registry) {
// 	// 	registry.addMapping("/user/logincash")
// 	// 	.allowedOrigins("https://dilven.vercel.app")
// 	// 	.allowedMethods("GET", "POST")
// 	// 	.allowedHeaders("Content-Type", "Authorization")
// 	// 	.allowCredentials(true)
// 	// 	.maxAge(3600);
// 	// }
	
    		
// //    @Bean
// //    public WebMvcConfigurer corsConfigurer() {
// //        return new WebMvcConfigurer() {
// //            @Override
// //            public void addCorsMappings(CorsRegistry registry) {
// //                registry.addMapping("/**")
// //                        .allowedOrigins("https://dilven-pos.vercel.app")
// //                        .allowedMethods("*")
// //                        .allowedHeaders("*")
// //                        .allowCredentials(true);
// //            }
// //        };
// //    }
    
//     // @Bean
//     // public CorsConfigurationSource corsConfigSource() {
//     // 	CorsConfiguration config = new CorsConfiguration();
//     //     config.setAllowCredentials(true);
//     //     config.addAllowedOrigin("https://dilven.vercel.app");
//     //     config.addAllowedHeader("*");
//     //     config.addAllowedMethod("*");
//     //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//     //     source.registerCorsConfiguration("/**", config);
//     //     return source;
//     // }
    
   
// }