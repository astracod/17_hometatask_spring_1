package org.example.contactbookspring.dao;

import org.example.contactbookspring.entities.Contact;

import java.util.List;

public interface ContactsDao {
    List<Contact> getAll();

    void add(Contact contact);

    void remove(String id);

    List<Contact> findByName(String name);

    List<Contact> findNumberPart(String numberPart);
}
