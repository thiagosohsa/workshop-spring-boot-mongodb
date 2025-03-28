package com.thiagosousa.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.thiagosousa.workshopmongo.domain.User;
import com.thiagosousa.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Marta", "maria@gmail.com");
		User joao = new User(null, "Joao Jones", "joao@gmail.com");
		User alex = new User(null, "Alex Augusto", "alex@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,joao,alex));
	}

}
