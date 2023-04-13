package com.willianaraujo.toolsrental.dto;

import com.willianaraujo.toolsrental.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String street;

    @NotNull
    private Integer number;

    private String complement;

    @NotBlank
    @Size(max = 100)
    private String neighborhood;

    @NotBlank
    @Size(max = 100)
    private String city;

    @NotBlank
    @Size(max = 100)
    private String state;

    @NotNull
    private Integer zipCode;

    @NotBlank
    @Size(max = 100)
    private String country;

    @Valid
    @NotNull
    private UserDTO userId;

    private Boolean available;

    private Date createdAt;

    private Date updatedAt;
}
