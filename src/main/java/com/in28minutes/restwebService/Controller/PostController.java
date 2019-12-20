package com.in28minutes.restwebService.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.restwebService.Entity.Post;
import com.in28minutes.restwebService.Entity.PostUserModel;
import com.in28minutes.restwebService.Entity.UsersJPA;
import com.in28minutes.restwebService.exceptionhandling.PostNotFoundException;
import com.in28minutes.restwebService.repository.PostRepository;
import com.in28minutes.restwebService.repository.UsersRepository;
import com.in28minutes.restwebService.users.UserNotFoundException;

@RestController
@Transactional
public class PostController 
{
	@Autowired
	private PostRepository postrepository;
	
	@Autowired
	private UsersRepository userrepository;
	
	//@GetMapping("/posts")
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public List<Post> getAllPost()
	{
		List<Post> listOfPosts = postrepository.findAll();
		return listOfPosts;
	}
	@GetMapping("/posts/{id}")
	public Post getPostById(@RequestBody Integer id)
	{
		Optional<Post> post = postrepository.findById(id);
		if(!post.isPresent())
		{
			throw new PostNotFoundException("Post not Found for the ID------"+id);
		}
		Post postfromdb = post.get();
		return postfromdb;
	}
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
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable Integer id, @RequestBody Post post)
	{
		Optional<UsersJPA> user = userrepository.findById(id);
		if(!user.isPresent())
		{
			throw new UserNotFoundException("User Not Found");
		}
		UsersJPA userfromdb = user.get();
		post.setUser(userfromdb);
		postrepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

					return ResponseEntity.created(location).build();
		}
	
	@GetMapping("/posts/getallPostswithUsers")
	public List<PostUserModel> getAllPostsWithUsers()
	{
		List<PostUserModel> postusermodellist=new ArrayList<PostUserModel>();
		List<Post> posts = postrepository.findAll();
		
		posts.stream().forEach(post->{
			PostUserModel pum=new PostUserModel();
			pum.setPost(post);
			pum.setUser(post.getUser());
			postusermodellist.add(pum);});
		
		return postusermodellist;
			
		
	}
	}
