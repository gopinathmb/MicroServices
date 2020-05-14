/**
 * Created by gopinath_mb on 10-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author gopinath_mb
 */
@RestController
public class UserJPAResources {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent() == false) {
			throw new UserNotFoundException("User " + id + " not Found!!!");
		}
		// HATEOAS
		Resource<User> resource = new Resource<User>(user.get());
		// This gives rest-api uri of retrieveAllUsers()
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		// Name to uri
		Link linkName = linkTo.withRel("all-users");
		resource.add(linkName);
		return resource;
	}

	// @RequestBody - to say that user data will be available as a part of POST
	// request.
	// @Valid is a java annotation which says validate against the inputs which
	// are defined in User class like size and data.
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		User userCreated = userRepository.save(user);

		// This is to say that what is the location of new user created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userCreated.getId()).toUri();

		ResponseEntity<Object> response = ResponseEntity.created(location).build();
		return response;

	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);

	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveUserPosts(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent() == false) {
			throw new UserNotFoundException("User " + id + " not Found!!!");
		}
		List<Post> posts = user.get().getPosts();
		return posts;
	}

	@PostMapping("/jpa/users/{id}/post")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent() == false) {
			throw new UserNotFoundException("User " + id + " not Found!!!");
		}
		User user2 = user.get();
		post.setUser(user2);
		Post postCreated = postRepository.save(post);

		// This is to say that what is the location of new user created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(postCreated.getId()).toUri();

		ResponseEntity<Object> response = ResponseEntity.created(location).build();
		return response;

	}

}
