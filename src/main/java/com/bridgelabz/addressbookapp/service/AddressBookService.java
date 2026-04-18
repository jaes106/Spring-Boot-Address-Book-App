package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookNotFoundException;
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
        return dataList;
    }

    public AddressBook getById(Long id) {
        return dataList.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new AddressBookNotFoundException("AddressBook with id " + id + " not found"));
    }

    public AddressBook create(AddressBookDTO dto) {
        AddressBook model = new AddressBook(dto.getName(), dto.getCity());
        model.setId(counter.getAndIncrement());
        dataList.add(model);
        return model;
    }

    public AddressBook update(Long id, AddressBookDTO dto) {
        AddressBook existing = getById(id);

        existing.setName(dto.getName());
        existing.setCity(dto.getCity());
        return existing;
    }

    public void delete(Long id) {
        AddressBook existing = getById(id);
        dataList.remove(existing);
    }
}