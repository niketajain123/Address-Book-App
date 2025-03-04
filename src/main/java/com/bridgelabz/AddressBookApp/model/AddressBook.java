package com.bridgelabz.AddressBookApp.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonPropertyOrder({"id", "name", "phone", "email"})
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;

    public AddressBook(Long id, String name, String phone, String email) {
        this.id=id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}