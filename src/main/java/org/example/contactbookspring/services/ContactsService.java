package org.example.contactbookspring.services;

import lombok.RequiredArgsConstructor;
import org.example.contactbookspring.dao.ContactsDao;
import org.example.contactbookspring.entities.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ContactsService {
    private final ContactsDao contactsDao;

    public void add(Contact contact) {
        contact.setId(UUID.randomUUID().toString());
        contactsDao.add(contact);
    }

    public void remove(String id) {
        contactsDao.remove(id);
    }

    public List<Contact> findByName(String name) {
        return contactsDao.findByName(name);
    }

    public List<Contact> findNumberPart(String numberPart) {
        return contactsDao.findNumberPart(numberPart);
    }

    public List<Contact> getAll() {
        return contactsDao.getAll();
    }

}
