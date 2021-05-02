package domain.user.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity class for user table
 */
@Entity
@Embeddable
@Table(name = "user")
public class UserEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String id;
		@NotNull
		@Column(nullable = false)
		private String username;
		@NotNull
		@Column(nullable = false)
		private ArrayList<Object> roles;

}
