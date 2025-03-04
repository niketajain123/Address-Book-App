package com.bridgelabz.AddressBookApp.repository;

import com.bridgelabz.AddressBookApp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
}