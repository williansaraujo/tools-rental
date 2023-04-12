package com.willianaraujo.toolsrental.dto;

import jakarta.validation.constraints.NotBlank;
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
public class UserDTO {

        private Long id;

        @NotBlank
        @Size(max = 200)
        private String name;

        @NotBlank
        @Size(max = 200)
        private String email;

        @Size(max = 11)
        private String phone;

        private Boolean available;

        private Date createdAt;

        private Date updatedAt;


}
