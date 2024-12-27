package org.jsp.ums;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	UserRepository repo;

	@RequestMapping("/saveuser")
	public User saveUser(@RequestBody User user) {
		return repo.save(user);
	}

	@RequestMapping("/allusers")
	public List<User> findAllUsers() {
		return repo.findAll();
	}

	@RequestMapping("/finduser/{userid}")
	public User findUserById(@PathVariable(name = "userid") int id) {
		Optional<User> optional = repo.findById(id);
		return optional.get();
	}

	@RequestMapping("/update/email/{id}/{email}")
	public User updateUserEmail(@PathVariable(name = "id") int id, @PathVariable(name = "email") String email) {

		User user = repo.findById(id).get();

		user.setEmail(email);

		return repo.save(user);
	}

}
