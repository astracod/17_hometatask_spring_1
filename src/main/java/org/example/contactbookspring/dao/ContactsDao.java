package org.example.contactbookspring.dao;

import org.example.contactbookspring.entities.Contact;

import java.util.List;

public interface ContactsDao {
    List<Contact> getAll();
    void add(Contact contact);
}
