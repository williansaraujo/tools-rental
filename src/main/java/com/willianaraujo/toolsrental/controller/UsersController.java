package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    public MessageResponseDTO create(User user){

    }
}
