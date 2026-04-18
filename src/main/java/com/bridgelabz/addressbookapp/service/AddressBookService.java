package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    public List<AddressBook> getAll() {
        return repository.findAll();
    }

    public AddressBook getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public AddressBook create(AddressBookDTO dto) {
        AddressBook model = new AddressBook(dto.getName(), dto.getCity());
        return repository.save(model);
    }

    public AddressBook update(Long id, AddressBookDTO dto) {
        AddressBook existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(dto.getName());
        existing.setCity(dto.getCity());
        return repository.save(existing);
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}