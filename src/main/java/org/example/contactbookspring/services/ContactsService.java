package org.example.contactbookspring.services;

import lombok.RequiredArgsConstructor;
import org.example.contactbookspring.dao.ContactsDao;
import org.example.contactbookspring.entities.Contact;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactsService {
    private final ContactsDao contactsDao;

    public void add(Contact contact) {
        contact.setId(UUID.randomUUID().toString());
        contactsDao.add(contact);
    }

    public void remove(String id) {
        /*contactList = contactList.stream()
                .filter(c -> !Objects.equals(c.getId(), id))
                .collect(Collectors.toList());*/
    }

    public List<Contact> findByName(String name) {
        return null;
    }

    public List<Contact> findNumberPart(String numberPart) {
        return null;
    }

    public List<Contact> getAll() {
        return contactsDao.getAll();
    }

}
