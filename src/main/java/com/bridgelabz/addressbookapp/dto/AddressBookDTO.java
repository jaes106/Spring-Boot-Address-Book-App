package com.bridgelabz.addressbookapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookDTO {

    @NotBlank(message = "Name is required")
    @Pattern(
            regexp = "^[A-Za-z ]{2,50}$",
            message = "Name must contain only letters and spaces (2-50 characters)"
    )
    private String name;

    private String city;
}