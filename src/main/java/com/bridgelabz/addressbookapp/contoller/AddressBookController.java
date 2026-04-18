package com.bridgelabz.addressbookapp.contoller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final Map<Long, AddressBookDTO> data = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<AddressBookDTO>> getAll() {
        return ResponseEntity.ok(new ArrayList<>(data.values()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        AddressBookDTO dto = data.get(id);
        if (dto == null) {
            return ResponseEntity.status(404).body("Record not found");
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AddressBookDTO> create(@RequestBody AddressBookDTO dto) {
        data.put(dto.getId(), dto);
        return ResponseEntity.status(201).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody AddressBookDTO dto) {

        if (!data.containsKey(id)) {
            return ResponseEntity.status(404).body("Record not found");
        }

        dto.setId(id);
        data.put(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!data.containsKey(id)) {
            return ResponseEntity.status(404).body("Record not found");
        }

        data.remove(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}