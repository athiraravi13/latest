package domain.webapi.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * DTO class for User
 */

public class UserDto {

	@Min(1)
	@Max(100)
	@NotNull
	private String id;

	@Min(5)
	@Max(200)
	@NotNull
	private String username;

	@NotNull
	private List<Object> roles;

	// Need to provide an empty constructor or @JsonProperty annotation to fields in
	// order to avoid error like "No Creators, like default construct, exist".
	public UserDto() {

	}

	public UserDto(String id, String username, List<Object> roles) {
		this.id = id;
		this.username = username;
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public List<Object> getRoles() {
		return roles;
	}

}
