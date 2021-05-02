package domain.webapi;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.user.model.User;
import domain.user.service.UserServiceImpl;
import domain.webapi.model.UserDto;

/**
 * Controller class for user operations.
 */
@RestController
//Provide @RequestMapping annotation to map the controller methods. It specifies the kind of requests
//this controller handles. Eg: This controller handles User related operations.
//Also we can provide a root path for User controller for convenience.
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	// we can provide a path for HTTP GET method.
	@GetMapping("/")
	public ResponseEntity<Collection<User>> getUsers() {
		return ResponseEntity.ok(userService.getUsers());
	}

	// we can provide a path for HTTP POST method.
	@PostMapping("/save")
	public ResponseEntity getUser(@RequestBody User user) {
		userService.createUser(user);
		return ResponseEntity.noContent().build();
	}

	// we can provide a path for HTTP PUT method.
	@PutMapping("/update")
	public ResponseEntity updateUser(@Valid @RequestBody UserDto user) {

		userService.updateUser(new User(user.getId(), user.getUsername(), new ArrayList<>(user.getRoles())));
		return ResponseEntity.noContent().build();
	}


}
