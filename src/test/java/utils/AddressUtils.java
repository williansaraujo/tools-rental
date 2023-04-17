package utils;

import com.github.javafaker.Faker;
import com.willianaraujo.toolsrental.dto.AddressDTO;
import com.willianaraujo.toolsrental.dto.UserDTO;

import java.util.Calendar;

public class AddressUtils {

    private static final Faker faker = Faker.instance();


    public static AddressDTO createFakeAddressDTO(){
        return AddressDTO.builder()
                .id(faker.number().randomNumber())
                .street(faker.address().streetName())
                .number(Integer.valueOf(faker.address().streetAddressNumber()))
                .neighborhood("São Vicente")
                .city(faker.address().city())
                .zipCode(Integer.valueOf(faker.address().zipCode()))
                .country(faker.address().country())
             //   .userId(faker.number().randomNumber())
                .available(Boolean.valueOf("true"))
                .createdAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .build();
    }



}
