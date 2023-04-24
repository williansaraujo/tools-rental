package com.willianaraujo.toolsrental.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.willianaraujo.toolsrental.dto.ToolDTO;
import com.willianaraujo.toolsrental.entity.Tool;

import java.math.BigDecimal;
import java.util.Calendar;

import static com.willianaraujo.toolsrental.utils.AddressUtils.createFakeAddress;
import static com.willianaraujo.toolsrental.utils.AddressUtils.createFakeAddressDTO;
import static com.willianaraujo.toolsrental.utils.ToolGroupUtils.createFakeToolGroup;
import static com.willianaraujo.toolsrental.utils.ToolGroupUtils.createFakeToolGroupDTO;

public class ToolUtils {

    private static final Faker faker = Faker.instance();


    public static ToolDTO createFakeToolDTO() {
        return ToolDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.commerce().productName())
                .description(faker.commerce().material())
                .rentalRatePerDay(BigDecimal.valueOf(faker.number().numberBetween(1, 100)))
                .photoFilePath(faker.file().fileName())
                .toolGroupId(createFakeToolGroupDTO())
                .ownerAddressId(createFakeAddressDTO())
                .available(Boolean.valueOf("true"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }

    public static Tool createFakeTool() {
        return Tool.builder()
                .id(faker.number().randomNumber())
                .name(faker.commerce().productName())
                .description(faker.commerce().material())
                .rentalRatePerDay(BigDecimal.valueOf(faker.number().numberBetween(1, 100)))
                .photoFilePath(faker.file().fileName())
                .toolGroupId(createFakeToolGroup())
                .ownerAddressId(createFakeAddress())
                .available(Boolean.valueOf("true"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }

    public static String asJsonString(ToolDTO toolDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.writeValueAsString(toolDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
