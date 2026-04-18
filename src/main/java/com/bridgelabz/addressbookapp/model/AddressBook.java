package com.bridgelabz.addressbookapp.model;
public class AddressBook {

    private Long id;
    private String name;
    private String city;

    public AddressBook() {}

    public AddressBook(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}