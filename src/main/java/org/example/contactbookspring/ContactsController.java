package org.example.contactbookspring;


import lombok.RequiredArgsConstructor;
import org.example.contactbookspring.dto.AddContactRequest;
import org.example.contactbookspring.dto.DeleteContactRequest;
import org.example.contactbookspring.dto.StatusResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ContactsController {

    private final ContactsService service;


    @GetMapping("")
    public List<Contact> showAll() {
        return service.showAllContact();
    }

    @PostMapping("/add")
    public StatusResponse addContactInList(@RequestBody AddContactRequest request) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            service.addContact(request.getName(), request.getNumber());
            statusResponse.setStatus(StatusResponse.Status.OK);
            statusResponse.setMessage(" -> добавление произведено");
        } catch (Exception e) {
            statusResponse.setStatus(StatusResponse.Status.FAIL);
            statusResponse.setMessage(e.getMessage());
        }
        return statusResponse;
    }

    @PostMapping("/remove")
    public StatusResponse removeContact(@RequestBody DeleteContactRequest request) {
        StatusResponse statusResponse = new StatusResponse();
        try{
            service.removeContact(request.getId());
            statusResponse.setStatus(StatusResponse.Status.OK);
            statusResponse.setMessage(" -> удаление произведено");
        }catch (Exception e) {
            statusResponse.setStatus(StatusResponse.Status.FAIL);
            statusResponse.setMessage(e.getMessage());
        }
        return statusResponse;

    }

}
// запросы в терминале идеи
// curl -XPOST http://localhost:8080/contactbookspring/add -H "Content-Type:application/json" -d"{\"name\":\"Dima\",\"number\":963258}"
// curl -XPOST http://localhost:8080/contactbookspring/remove -H "Content-Type:application/json" -d"{\"id\":\"e69c7ed5-7f83-4af4-8e0c-8fbc0e2c6c15\"}"