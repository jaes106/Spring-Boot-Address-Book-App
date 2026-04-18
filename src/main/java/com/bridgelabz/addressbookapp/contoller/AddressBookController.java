package com.bridgelabz.addressbookapp.contoller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService service;

    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        AddressBook data = service.getById(id);
        if (data == null) {
            return ResponseEntity.status(404).body("Record not found");
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public ResponseEntity<AddressBook> create(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody AddressBookDTO dto) {

        AddressBook updated = service.update(id, dto);
        if (updated == null) {
            return ResponseEntity.status(404).body("Record not found");
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!service.delete(id)) {
            return ResponseEntity.status(404).body("Record not found");
        }
        return ResponseEntity.ok("Deleted successfully");
    }
}