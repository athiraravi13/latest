package domain.user.model;

import java.util.ArrayList;

/**
 * POJO class for User
 */
public class User {

	public String id;
	public String username;
	public ArrayList<Object> roles = new ArrayList<>(100);

	// Need to provide an empty constructor or @JsonProperty annotation to fields in
	// order to avoid error like "No Creators, like default construct, exist".
	public User() {

	}

	public User(String id, String username, ArrayList<Object> roles) {
		this.id = id;
		this.username = username;
		this.roles = roles;
	}

	public boolean isAdmin() {
		return username.startsWith("admin-");
	}

	public boolean isUser() {
		return roles.stream().anyMatch(role -> role.toString().equals("user"));
	}

	public void assignRole(String role) {
		roles.add(role);
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public ArrayList<Object> getRoles() {
		return roles;
	}

	public void save(User user) {
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoles(ArrayList<Object> roles) {
		this.roles = roles;
	}
}
