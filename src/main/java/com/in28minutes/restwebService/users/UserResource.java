package com.in28minutes.restwebService.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource 
{
	@Autowired
	UserDaoService service;
	
	@GetMapping(path="/users")
	public List<Users> retrieveAllUsers()
	{
		return service.findall();
		
	}
	@GetMapping(path="/users/{id}")
	public Resource<Users> findOneUder(@PathVariable int id)
	{
		Users user = service.findOne(id);
		if(user==null)
		{
			throw new UserNotFoundException("id-->"+id);
		}
		Resource<Users> resource=new Resource<Users>(user);
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("allUsers"));
		return resource;	
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Users user)
	{
		Users usersaved = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(usersaved.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteById(@PathVariable int id)
	{
		Users user = service.deleteByUser(id);
		if(user==null)
		throw new UserNotFoundException("WrongID");
		
	}
}
