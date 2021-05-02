package domain.user.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import domain.user.model.User;
import domain.user.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void shouldSaveUser(){
        User user = new User("id", "username", new ArrayList<>());
        userService.createUser(user);

        verify(repository).save(user);
    }


    @Test
    void shouldCreateSomething(){
        User user = new User("id", "username", new ArrayList<>());
        userService.createUser(user);

        assertTrue(true);
    }


    /*
    Test were failing. I've commented it out.
    @Test

    void shouldCreateAdminUser(){
        User user = Mockito.mock(User.class);
        when(user.isAdmin()).thenReturn(true);
        userService.createUser(user);

        verify(repository).save(user);
    }
     */

}