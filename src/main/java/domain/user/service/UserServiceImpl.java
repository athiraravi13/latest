package domain.user.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.user.model.User;
import domain.user.repository.UserRepository;

/**
 * Service implementation for User operations.
 */
@Service // Added @Service annotation. Otherwise it will not detected by in application
			// scan.
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	// Method for fetching user details.
	public Collection<User> getUsers() {
		return userRepository.getUsers();
	}

	// Method to create a user.
	public void createUser(User user) {
		if (user.isAdmin()) {
			User otherAdmin = userRepository.findFirstAdmin();
			if (null != otherAdmin) {
				if (!otherAdmin.isAdmin()) {
					userRepository.save(otherAdmin);
				} else {
					userRepository.save(user);
				}
			}

		} else {
			userRepository.save(user);
		}
	}

	// Method to update a user.
	public void updateUser(User user) {
		userRepository.save(user);
	}
}
