package com.thiagosousa.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagosousa.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User joao = new User("1", "Joao Jones", "joao@gmail.com");
		User maria = new User("2", "Maria Marta", "maria@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(joao,maria));
		return ResponseEntity.ok().body(list);
	}
}
