package com.blog.myblogapi;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blog.myblogapi.config.AppConstants;
import com.blog.myblogapi.model.Role;
import com.blog.myblogapi.userRepo.RoleRepo;

@SpringBootApplication
public class BackendBlogApiApplication implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BackendBlogApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("encrpted password::"+ passwordEncoder.encode("1234"));
		try {
			Role roles= new Role();
			roles.setRoleId(AppConstants.ADMIN_USER);
			roles.setName("ADMIN_USER");
			
			Role roles1= new Role();
			roles1.setRoleId(AppConstants.NORMAL_USER);
			roles1.setName("NORMAL_USER");
			List<Role> roles3 = List.of(roles , roles1);
			
			List<Role> result = roleRepo.saveAll(roles3);
			
			result.forEach(r->System.out.println(r.getName()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
