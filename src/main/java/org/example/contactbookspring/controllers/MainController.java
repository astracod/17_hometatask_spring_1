package org.example.contactbookspring.controllers;

import lombok.RequiredArgsConstructor;
import org.example.contactbookspring.entities.Contact;
import org.example.contactbookspring.services.ContactsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final ContactsService contactsService;

    @GetMapping("")
    public String index(Model model) {
        List<Contact> contacts = contactsService.getAll();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @PostMapping("add")
    public String addContact(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestHeader("Referer") String ref,
            Model model
    ) {
        try {
            if (name == null || name.isBlank()) throw new Exception("Field name is required");
            if (phone == null || phone.isBlank()) throw new Exception("Field phone is required");
            Contact contact = new Contact(null, name, phone);
            contactsService.add(contact);
            return "redirect:" + ref;
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_contact_view";
        }
    }

    @PostMapping("delete")
    public String delContact(
            @RequestParam String id,
            @RequestHeader("Referer") String ref
    ) {
        contactsService.remove(id);
        return "redirect:" + ref;
    }

    @PostMapping("findName")
    public String findName(
            @RequestParam String name,
            Model model
    ) {
        try {
            if (name == null || name.isBlank()) throw new Exception("Field name is required");
            List<Contact> contacts = contactsService.findByName(name);
            System.out.println(contacts);
            model.addAttribute("contacts", contacts);
            return "name_contacts_view";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_contact_view";
        }
    }

    @PostMapping("findNumber")
    public String findNumberPart(
            @RequestParam String numberPart,
            Model model
    ) {
        try {
            if (numberPart == null || numberPart.isBlank()) throw new Exception("Field number is required");
            List<Contact> contacts = contactsService.findNumberPart(numberPart);
            System.out.println(contacts);
            model.addAttribute("contacts", contacts);
            return "name_contacts_view";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error_contact_view";
        }
    }

}
