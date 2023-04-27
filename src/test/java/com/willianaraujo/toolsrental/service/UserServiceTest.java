package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.UserDTO;
import com.willianaraujo.toolsrental.entity.User;
import com.willianaraujo.toolsrental.exception.UserNotFoundException;
import com.willianaraujo.toolsrental.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.willianaraujo.toolsrental.utils.UserUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUser() throws UserNotFoundException {
        User expectedFoundUser = createFakeUser();

        when(userRepository.findById(expectedFoundUser.getId())).thenReturn(Optional.of(expectedFoundUser));

        UserDTO userDTO = userService.findById(expectedFoundUser.getId());

        assertEquals(expectedFoundUser.getName(), userDTO.getName());
        assertEquals(expectedFoundUser.getPhone(), userDTO.getPhone());
        assertEquals(expectedFoundUser.getEmail(), userDTO.getEmail());

    }

    @Test
    void testGetUserNotFound() {
        var invalidId = 10L;

        when(userRepository.findById(invalidId))
                .thenReturn(Optional.ofNullable(any(User.class)));

        assertThrows(UserNotFoundException.class, () -> userService.findById(invalidId));
    }
}
