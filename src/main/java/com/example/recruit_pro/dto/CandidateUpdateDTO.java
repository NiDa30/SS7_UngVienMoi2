package com.example.recruit_pro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateUpdateDTO {

    @NotBlank(message = "Address is required")
    private String address;

    @Size(max = 200, message = "Bio must not exceed 200 characters")
    private String bio;
}
