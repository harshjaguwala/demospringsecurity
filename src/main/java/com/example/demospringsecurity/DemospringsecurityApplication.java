package com.example.demospringsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demospringsecurity.models.User;



@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(
		basePackages = {
				"com.example.demospringsecurity.controller","com.example.demospringsecurity.services","com.example.demospringsecurity.config"
})
@EnableAutoConfiguration
@EntityScan("com.example.demospringsecurity.models")
//@EnableJpaRepositories("com.example.demospringsecurity.repository")
public class DemospringsecurityApplication{
	
//	@Autowired
//	private UserRepositoryImpl userRepositoryImpl;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemospringsecurityApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		User u = new User();
//		u.setEmail("john@gmail.com");
//		u.setUsername("john");
//		u.setPassword(this.encoder().encode("harsh"));
//		u.setRole("NORMAL");
//		
//		User u1 = new User();
//		u1.setEmail("harsh@gmail.com");
//		u1.setUsername("harsh");
//		u1.setPassword(this.encoder().encode("harsh"));
//		u1.setRole("ADMIN");
//		this.userRepositoryImpl.save(u1);
//		
//	}
//	
//	@Bean
//	public PasswordEncoder encoder() {
//	    return new BCryptPasswordEncoder();
//	}

}
