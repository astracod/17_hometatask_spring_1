package org.example.contactbookspring.dto.contacts;

import lombok.Data;

@Data
public class AddContactRequest {

    private String id;
    private String name;
    private String number;
}
