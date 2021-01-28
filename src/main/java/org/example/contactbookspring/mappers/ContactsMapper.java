package org.example.contactbookspring.mappers;

import org.example.contactbookspring.entities.Contact;
import org.example.contactbookspring.dto.contacts.AddContactRequest;
import org.example.contactbookspring.dto.contacts.ContactsDto;
import org.example.contactbookspring.dto.contacts.GetContactsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactsMapper {

    public Contact toContact(AddContactRequest request){
       return new  Contact(null,request.getName(),request.getNumber());
    }

    public GetContactsResponse toGetContactsResponse(List<Contact> contacts) {
        GetContactsResponse response = new GetContactsResponse();
        response.setStatus("ok");
        response.setMessage("success");
        response.setContactsDto(
                contacts.stream()
                .map(c->this.toContactDto(c))
                .collect(Collectors.toList())
        );
        return response;
    }

    public ContactsDto toContactDto(Contact contact) {
        ContactsDto contactsDto = new ContactsDto();
        contactsDto.setId(contact.getId());
        contactsDto.setName(contact.getName());
        contactsDto.setNumber(contact.getNumber());
        return contactsDto;
    }
}
