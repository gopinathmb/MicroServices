/**
 * Created by gopinath_mb on 10-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserResources
{

  @Autowired
  private UserDaoService userDaoService;
  
 

  @GetMapping("/users")
  public List<User> retrieveAllUsers()
  {
    return userDaoService.findAll();
  }

  @GetMapping("/users/{id}")
  public Resource<User> retrieveUSer(@PathVariable int id)
  {
    User user = userDaoService.findOne(id);
    if (user == null)
    {
      throw new UserNotFoundException("User " + id + " not Found!!!");
    }
    //HATEOAS
    Resource<User> resource = new Resource<User>(user);
    //This gives rest-api uri of retrieveAllUsers()
    ControllerLinkBuilder linkTo = linkTo(
        methodOn(this.getClass()).retrieveAllUsers());
    //Name to uri
    Link linkName = linkTo.withRel("all-users");
    resource.add(linkName);
    return resource;
  }

  // @RequestBody - to say that user data will be available as a part of POST
  // request.
  // @Valid is a java annotation which says validate against the inputs which
  // are defined in User class like size and data.
  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
  {

    User userCreated = userDaoService.save(user);

    // This is to say that what is the location of new user created
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(userCreated.getId()).toUri();

    ResponseEntity<Object> response = ResponseEntity.created(location).build();
    return response;

  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id)
  {
    User userDeleted = userDaoService.deleteById(id);
    if (userDeleted == null)
    {
      throw new UserNotFoundException("User :" + id + " not Found!!!");
    }
  }

}
