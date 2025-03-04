package com.bridgelabz.AddressBookApp.controller;
import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    private AddressBookService addressBookService;
    @GetMapping("/contacts")
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable int id) {
        return ResponseEntity.ok("Fetching contact with ID: " + id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddressBook> addContact(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.addContact(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id) {
        return ResponseEntity.ok("Updating contact with ID: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        return ResponseEntity.ok("Deleting contact with ID: " + id);
    }
}