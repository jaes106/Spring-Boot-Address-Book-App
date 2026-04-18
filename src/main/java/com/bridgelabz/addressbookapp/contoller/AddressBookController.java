package com.bridgelabz.addressbookapp.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @GetMapping("/addressbook")
    public String getMessage() {
        return "Address Book App is running";
    }
}