package com.thiagosousa.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.thiagosousa.workshopmongo.domain.Post;
import com.thiagosousa.workshopmongo.domain.User;
import com.thiagosousa.workshopmongo.repository.PostRepository;
import com.thiagosousa.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Marta", "maria@gmail.com");
		User joao = new User(null, "Joao Jones", "joao@gmail.com");
		User alex = new User(null, "Alex Augusto", "alex@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Vou viajar", "Viajando para São Paulo", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bela manhã", "Acordei vivo, infelizmente", maria);
		
		userRepository.saveAll(Arrays.asList(maria,joao,alex));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
