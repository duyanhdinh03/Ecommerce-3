package com.example.Ecomv3.DTO;

import lombok.Data;
@Data
public class EmailConfirmationRequest {
    private String email;
    private String confirmationCode;
}
