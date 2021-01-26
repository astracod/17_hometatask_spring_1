package org.example.contactbookspring;


import lombok.RequiredArgsConstructor;
import org.example.contactbookspring.dto.AddContactRequest;
import org.example.contactbookspring.dto.DeleteContactRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ContactsController {

    private final ContactsService service;


    @GetMapping("")
    public String hello(){
        return "HELLO";
    }

    @GetMapping("/show")
    public List<Contact> showAll() {
       return service.showAllContact();
    }

    @PostMapping("/add")
    public String addContactInList(@RequestBody AddContactRequest request) {
        service.addContact(request.getId(), request.getName(), request.getNumber());
        return "ok";
    }

    @PostMapping("/remove")
    public String removeContact(@RequestBody DeleteContactRequest request) {
        service.removeContact(request.getId());
        return "ok";
    }

}
//  curl -XPOST http://localhost:8080/contactbookspring/add -H "Content-Type:application/json" -d'{"name":"Dima","number":963258}'
// curl -XPOST http://localhost:8080/contactbookspring/add -H "Content-Type:application/json" -d"{\"name\":\"Dima\",\"number\":963258}"
// curl -XPOST http://localhost:8080/contactbookspring/remove -H "Content-Type:application/json" -d"{\"id\":\"e69c7ed5-7f83-4af4-8e0c-8fbc0e2c6c15\"}"