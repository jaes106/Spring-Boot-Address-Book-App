package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressBookService {

    private final List<AddressBook> dataList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<AddressBook> getAll() {
        return dataList;
    }

    public AddressBook getById(Long id) {
        return dataList.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public AddressBook create(AddressBookDTO dto) {
        AddressBook model = new AddressBook(dto.getName(), dto.getCity());
        model.setId(counter.getAndIncrement());
        dataList.add(model);
        return model;
    }

    public AddressBook update(Long id, AddressBookDTO dto) {
        AddressBook existing = getById(id);
        if (existing == null) return null;

        existing.setName(dto.getName());
        existing.setCity(dto.getCity());
        return existing;
    }

    public boolean delete(Long id) {
        AddressBook existing = getById(id);
        if (existing == null) return false;

        dataList.remove(existing);
        return true;
    }
}