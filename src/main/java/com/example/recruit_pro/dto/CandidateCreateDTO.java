package com.example.recruit_pro.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateCreateDTO {

    @NotBlank(message = "Full name is required")
    @Size(min = 5, max = 50, message = "Full name must be between 5 and 50 characters")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^0[35789]\\d{8}$", message = "Invalid phone number format. Must be 10 digits and start with 03, 05, 07, 08, or 09")
    private String phone;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotNull(message = "Years of experience is required")
    @Min(value = 0, message = "Years of experience cannot be negative")
    private Integer yearsOfExperience;
}
