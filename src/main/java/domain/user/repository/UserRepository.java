package domain.user.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.user.model.User;
import domain.user.model.UserEntity;

/**
 * Interface class for User Repository
 */
@Repository // Added this annotation to indicate that this class is a repository and it will get scanned also.
// Need to extend the UserRepository class with CrudRepository and an Entity class also.
// Added query to get user details and first admin details.
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	@Query(nativeQuery=true,value="select * from UserEntity")
	Collection<User> getUsers();

    void save(User user);

    @Query(nativeQuery=true,value="select * from UserEntity where username like 'admin-%'")
    User findFirstAdmin();
}
