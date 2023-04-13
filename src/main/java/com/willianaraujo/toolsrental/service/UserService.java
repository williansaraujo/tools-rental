package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.UserDTO;
import com.willianaraujo.toolsrental.entity.User;
import com.willianaraujo.toolsrental.mapper.UserMapper;
import com.willianaraujo.toolsrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    private UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public MessageResponseDTO create(UserDTO userDTO){
    User userToSave = userMapper.toModel(userDTO);

    User saveUser = userRepository.save(userToSave);
    return MessageResponseDTO.builder()
            .message("Usuário "+ saveUser.getId() + " criado com sucesso." )
            .build();
}
}
