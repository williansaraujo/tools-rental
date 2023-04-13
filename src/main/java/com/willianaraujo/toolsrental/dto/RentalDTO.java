package com.willianaraujo.toolsrental.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalDTO {

    private Long id;

    @NotNull
    @Valid
    private UserDTO userId;

    @NotNull
    @Valid
    private ToolDTO toolId;

    @NotNull
    private LocalDateTime rentalStartDate;

    @NotNull
    private LocalDateTime rentalEndDate;

    private Boolean returned;

    private Date createdAt;

    private Date updatedAt;

}
