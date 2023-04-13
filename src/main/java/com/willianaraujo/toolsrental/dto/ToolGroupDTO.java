package com.willianaraujo.toolsrental.dto;

import jakarta.persistence.*;
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
public class ToolGroupDTO {

    private Long id;

    @Size(max = 200)
    @NotNull
    private String name;

    private Boolean available;

    private Date createdAt;

    private Date updatedAt;
}
