package org.example.contactbookspring.services;

import org.example.contactbookspring.entities.Contact;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContactsService {

    private List<Contact> contactList = new LinkedList<>();

    public boolean add(Contact contact) {
        contact.setId(UUID.randomUUID().toString());
        return contactList.add(contact);
    }

    public void remove(String id) {

        contactList = contactList.stream()
                .filter(c -> !Objects.equals(c.getId(), id))
                .collect(Collectors.toList());

    }

    public List<Contact> getAll() {
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
        return contactList;
    }

}
