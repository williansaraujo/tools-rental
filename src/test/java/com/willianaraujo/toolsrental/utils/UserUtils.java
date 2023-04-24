package com.willianaraujo.toolsrental.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.willianaraujo.toolsrental.dto.UserDTO;
import com.willianaraujo.toolsrental.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Calendar;


public class UserUtils {

    private static final Faker faker = Faker.instance();

    public static UserDTO createFakeUserDTO() {
        return UserDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .phone("5534991086978")
                .available(Boolean.valueOf("true"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }

    public static @Valid @NotNull User createFakeUser() {
        return User.builder()
                .id(faker.number().randomNumber())
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .phone("5534991086978")
                .available(Boolean.valueOf("true"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }


    public static String asJsonString(UserDTO userDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.writeValueAsString(userDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
