package org.example.contactbookspring.dto;

import lombok.Data;

@Data
public class AddContactRequest {

    private String id;
    private String name;
    private Integer number;
}
