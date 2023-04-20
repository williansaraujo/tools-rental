package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.willianaraujo.toolsrental.dto.ToolGroupDTO;
import com.willianaraujo.toolsrental.entity.ToolGroup;

import java.util.Calendar;

public class ToolGroupUtils {

    private static final Faker faker = Faker.instance();

    public static ToolGroupDTO createFakeToolGroupDTO() {
        return ToolGroupDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.commerce().department())
                .available(Boolean.valueOf("true"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }

    public static ToolGroup createFakeToolGroup() {
        return ToolGroup.builder()
                .id(faker.number().randomNumber())
                .name(faker.commerce().department())
                .available(Boolean.valueOf("true"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }

    public static String asJsonString(ToolGroupDTO toolGroupDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.writeValueAsString(toolGroupDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
