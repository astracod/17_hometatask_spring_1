package org.example.contactbookspring;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class ContactsService {

    private List<Contact> contactList = new LinkedList<>();

    public boolean addContact( String name, Integer number) {
        String id = UUID.randomUUID().toString();
        return contactList.add(new Contact(id,name, number));
    }

    public void removeContact(String id) {
        for (Contact contact : contactList) {
            if (contact.getId().equals(id)) contactList.remove(contact);
        }

    }

    public List<Contact> showAllContact() {
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
        return contactList;
    }

}
