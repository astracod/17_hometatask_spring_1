package org.example.contactbookspring.controllers;


import lombok.RequiredArgsConstructor;
import org.example.contactbookspring.dto.contacts.*;
import org.example.contactbookspring.entities.Contact;
import org.example.contactbookspring.services.ContactsService;
import org.example.contactbookspring.dto.common.StatusResponse;
import org.example.contactbookspring.mappers.ContactsMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ContactsController {

    private final ContactsService service;
    private final ContactsMapper mapper;

    @GetMapping("")
    public GetContactsResponse getAll() {
        try {
            List<Contact> contacts = service.getAll();
            return mapper.toGetContactsResponse(contacts);
        } catch (Exception e) {
            return GetContactsResponse.error(e.getMessage());
        }

    }

    @PostMapping("/add")
    public StatusResponse addContactInList(@RequestBody AddContactRequest request) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            service.add(mapper.toContact(request));
            statusResponse.setStatus(StatusResponse.Status.OK);
            statusResponse.setMessage(" -> добавление произведено");
        } catch (Exception e) {
            statusResponse.setStatus(StatusResponse.Status.FAIL);
            statusResponse.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return statusResponse;
    }

    @PostMapping("/remove")
    public StatusResponse removeContact(@RequestBody DeleteContactRequest request) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            service.remove(request.getId());
            statusResponse.setStatus(StatusResponse.Status.OK);
            statusResponse.setMessage(" -> удаление произведено");
        } catch (Exception e) {
            statusResponse.setStatus(StatusResponse.Status.FAIL);
            statusResponse.setMessage(e.getMessage());
        }
        return statusResponse;
    }


    @PostMapping("/name")
    public GetContactsResponse findByName(@RequestBody FindByNameRequest request) {
        try {
           List<Contact> contacts = service.findByName(request.getName());
            return mapper.toGetContactsResponse(contacts);
        } catch (Exception e) {
            return GetContactsResponse.error(e.getMessage());
        }
    }

    @PostMapping("/number")
    public GetContactsResponse findNumberPart(@RequestBody FindNumberPartRequest request){
        try {
            List<Contact> contacts = service.findNumberPart(request.getNumber());
            return mapper.toGetContactsResponse(contacts);
        } catch (Exception e) {
            return GetContactsResponse.error(e.getMessage());
        }
    }

}
// запросы в терминале идеи
// curl -XPOST http://localhost:8080/contactbookspring/number -H "Content-Type:application/json" -d"{\"number\":\"63\"}"
// curl -XPOST http://localhost:8080/contactbookspring/add -H "Content-Type:application/json" -d"{\"name\":\"Dima\",\"number\":\"963258\"}"
// curl -XPOST http://localhost:8080/contactbookspring/remove -H "Content-Type:application/json" -d"{\"id\":\"e69c7ed5-7f83-4af4-8e0c-8fbc0e2c6c15\"}"
// curl -XPOST http://localhost:8080/contactbookspring/name -H "Content-Type:application/json" -d"{\"name\":\"Dima\"}"
// curl -XGET http://localhost:8080/contactbookspring/