package com.bridgelabz.AddressBookApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressBookDTO {
    private String name;
    private String phone;
    private String email;
}