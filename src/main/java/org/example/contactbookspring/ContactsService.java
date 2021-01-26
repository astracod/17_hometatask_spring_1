package org.example.contactbookspring;

import org.example.contactbookspring.dto.DeleteContactRequest;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Component
public class ContactsService {

    private List<Contact> contactList = new LinkedList<>();

    public boolean addContact(String id, String name, Integer number) {
        id = UUID.randomUUID().toString();
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
