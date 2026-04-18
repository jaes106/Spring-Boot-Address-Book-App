package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAll() {
        log.info("Fetching all address book records");
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        log.info("Fetching record with id: {}", id);

        AddressBook data = service.getById(id);
        if (data == null) {
            log.warn("Record not found for id: {}", id);
            return ResponseEntity.status(404).body("Record not found");
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public ResponseEntity<AddressBook> create(@RequestBody AddressBookDTO dto) {
        log.info("Creating new record: {}", dto);
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody AddressBookDTO dto) {

        log.info("Updating record id: {}", id);

        AddressBook updated = service.update(id, dto);
        if (updated == null) {
            log.warn("Update failed. Record not found for id: {}", id);
            return ResponseEntity.status(404).body("Record not found");
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        log.info("Deleting record id: {}", id);

        if (!service.delete(id)) {
            log.warn("Delete failed. Record not found for id: {}", id);
            return ResponseEntity.status(404).body("Record not found");
        }
        return ResponseEntity.ok("Deleted successfully");
    }
}