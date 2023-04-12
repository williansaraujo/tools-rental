package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.UserDTO;
import com.willianaraujo.toolsrental.entity.User;
import com.willianaraujo.toolsrental.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public MessageResponseDTO create(@Valid UserDTO userDTO){
        User userToSave = User.builder()
                .name(userDTO.getName())
                .available(userDTO.getAvailable())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .createdAt(userDTO.getCreatedAt())
                .updatedAt(userDTO.getUpdatedAt())
                .build();

        User saveUser = userRepository.save(userToSave);
        return MessageResponseDTO.builder()
                .message("Usuário "+ saveUser.getId() + " criado com sucesso." )
                .build();
    }
}
