package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.willianaraujo.toolsrental.dto.RentalDTO;
import com.willianaraujo.toolsrental.entity.Rental;

import java.util.Calendar;

import static utils.ToolUtils.createFakeTool;
import static utils.ToolUtils.createFakeToolDTO;
import static utils.UserUtils.createFakeUser;
import static utils.UserUtils.createFakeUserDTO;


public class RentalUtils {

    private static final Faker faker = Faker.instance();

    public static RentalDTO createFakeRentalDTO() {
        return RentalDTO.builder()
                .id(faker.number().randomNumber())
                .userId(createFakeUserDTO())
                .toolId(createFakeToolDTO())
                .rentalStartDate(Calendar.getInstance().getTime())
                .rentalEndDate(Calendar.getInstance().getTime())
                .returned(Boolean.valueOf("false"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }

    public static Rental createFakeRental() {
        return Rental.builder()
                .id(faker.number().randomNumber())
                .userId(createFakeUser())
                .toolId(createFakeTool())
                .rentalStartDate(Calendar.getInstance().getTime())
                .rentalEndDate(Calendar.getInstance().getTime())
                .returned(Boolean.valueOf("false"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }

    public static String asJsonString(RentalDTO rentalDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.writeValueAsString(rentalDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
