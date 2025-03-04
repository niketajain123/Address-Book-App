package com.bridgelabz.AddressBookApp.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address_book")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "name", "phone", "email"})
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;


}