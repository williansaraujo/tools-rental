package com.willianaraujo.toolsrental.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 500)
    private String description;

    @NotNull
    private BigDecimal rentalRatePerDay;

    private String photoFilePath;

    @NotNull
    @Valid
    private ToolGroupDTO toolGroupId;

    @NotNull
    @Valid
    private AddressDTO ownerAddressId;

    private Boolean available;

    private Date createdAt;

    private Date updatedAt;
}
