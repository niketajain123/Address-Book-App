package com.bridgelabz.AddressBookApp.controller;
import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService addressBookService;
    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        log.info("GET /addressbook - Fetching all contacts");
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable Long id) {
        log.info("GET /addressbook/{} - Fetching contact from DB", id);
        Optional<AddressBook> contactOptional = addressBookService.getContactById(id);
        if (contactOptional.isPresent()) {
            return ResponseEntity.ok(contactOptional.get());
        } else {
            log.warn("Contact with ID {} not found in DB", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
        public ResponseEntity<AddressBook> addContact(@RequestBody AddressBookDTO dto) {
        log.info("POST /addressbook - Adding new contact: {}", dto);
        AddressBook newContact = addressBookService.addContact(dto);
        log.info("New contact added successfully: {}", newContact);
        return ResponseEntity.ok(newContact);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateContact(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        log.info("PUT /addressbook/{} - Updating contact in DB: {}", id, dto);
        Optional<AddressBook> updatedContactOptional = addressBookService.updateContact(id, dto);
        if (updatedContactOptional.isPresent()) {
            return ResponseEntity.ok(updatedContactOptional.get());
        } else {
            log.warn("Update failed - Contact with ID {} not found in DB", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        boolean deleted = addressBookService.deleteContact(id);
        if (deleted) {
            log.info("Contact with ID {} deleted successfully", id);
            return ResponseEntity.ok("Deleted Successfully");
        } else {
            log.warn("Delete failed - Contact with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}