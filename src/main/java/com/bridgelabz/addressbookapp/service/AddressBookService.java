package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class AddressBookService {

    private final List<AddressBook> dataList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<AddressBook> getAll() {
        log.debug("Returning all records");
        return dataList;
    }

    public AddressBook getById(Long id) {
        log.debug("Searching for id: {}", id);
        return dataList.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public AddressBook create(AddressBookDTO dto) {
        AddressBook model = new AddressBook(dto.getName(), dto.getCity());
        model.setId(counter.getAndIncrement());
        dataList.add(model);

        log.info("Record created with id: {}", model.getId());
        return model;
    }

    public AddressBook update(Long id, AddressBookDTO dto) {
        AddressBook existing = getById(id);
        if (existing == null) {
            log.warn("Update failed for id: {}", id);
            return null;
        }

        existing.setName(dto.getName());
        existing.setCity(dto.getCity());

        log.info("Record updated for id: {}", id);
        return existing;
    }

    public boolean delete(Long id) {
        AddressBook existing = getById(id);
        if (existing == null) {
            log.warn("Delete failed for id: {}", id);
            return false;
        }

        dataList.remove(existing);
        log.info("Record deleted for id: {}", id);
        return true;
    }
}