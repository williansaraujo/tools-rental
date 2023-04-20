package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.willianaraujo.toolsrental.dto.AddressDTO;
import com.willianaraujo.toolsrental.entity.Address;

import java.util.Calendar;

import static utils.UserUtils.createFakeUser;
import static utils.UserUtils.createFakeUserDTO;

public class AddressUtils {

    private static final Faker faker = Faker.instance();


    public static AddressDTO createFakeAddressDTO() {
        return AddressDTO.builder()
                .id(faker.number().randomNumber())
                .street(faker.address().streetName())
                .number(Integer.valueOf(faker.address().streetAddressNumber()))
                .neighborhood("São Vicente")
                .city(faker.address().city())
                .state(faker.address().state())
                .zipCode(384121-334)
                .country(faker.address().country())
                .userId(createFakeUserDTO())
                .available(Boolean.valueOf("true"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }

    public static Address createFakeAddress() {
        return Address.builder()
                .id(faker.number().randomNumber())
                .street(faker.address().streetName())
                .number(Integer.valueOf(faker.address().streetAddressNumber()))
                .neighborhood("São Vicente")
                .city(faker.address().city())
                .state(faker.address().state())
                .zipCode(Integer.valueOf(faker.address().zipCode()))
                .country(faker.address().country())
                .userId(createFakeUser())
                .available(Boolean.valueOf("true"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }

    public static String asJsonString(AddressDTO addressDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.writeValueAsString(addressDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
