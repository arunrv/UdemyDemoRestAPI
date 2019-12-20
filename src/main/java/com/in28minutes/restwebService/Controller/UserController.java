package com.in28minutes.restwebService.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.restwebService.Entity.Post;
import com.in28minutes.restwebService.Entity.UsersJPA;
import com.in28minutes.restwebService.repository.UsersRepository;
import com.in28minutes.restwebService.users.UserNotFoundException;

@RestController
public class UserController
{
	@Autowired
	private UsersRepository userrepository;
	
	@GetMapping(path="/jpa/users")
	public List<UsersJPA> getAllUsers()
	{
		List<UsersJPA> allusers = userrepository.findAll();
		return allusers;
	}
	
	@GetMapping(path="/jpa/users/{id}")
	public UsersJPA getById(@PathVariable Integer id)
	{
		Optional<UsersJPA> user = userrepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User with id-->"+id+"--- Doesnot exist");
		else
		{
		UsersJPA userfromdb = user.get();
		return userfromdb;
		}
	}
	
	@PostMapping(path="jpa/users")
	public ResponseEntity<Object> postNewUser(@RequestBody UsersJPA users)
	{
		List<Post> post1 = users.getPosts();
		post1.stream().forEach(po->po.setUser(users));
		
		UsersJPA usersavedtodb = userrepository.save(users);
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usersavedtodb.getId())
	.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="jpa/users/{id}")
	public ResponseEntity<Object> deleteuser(@PathVariable Integer id)
	{
		Optional<UsersJPA> userTobeDeletedOption = userrepository.findById(id);
		UsersJPA userTobeDeleted;
		if(!userTobeDeletedOption.isPresent())
			throw new UserNotFoundException("User Not Found");
		
			userTobeDeleted=userTobeDeletedOption.get();
			userrepository.delete(userTobeDeletedOption.get());
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userTobeDeleted.getId())
	.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="jpa/users/{id}/posts")
	public List<Post> getAllPosts(@PathVariable Integer id)
	{
		Optional<UsersJPA> user = userrepository.findById(id);
		if(!user.isPresent())
		{
			throw new UserNotFoundException("User Not Found");
		}
		UsersJPA userfromDb = user.get();
		List<Post> postsfromDbforAUser = userfromDb.getPosts();
		return postsfromDbforAUser;
	}

}
