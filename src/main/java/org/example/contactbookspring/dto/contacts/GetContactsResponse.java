package org.example.contactbookspring.dto.contacts;

import lombok.Data;

import java.util.List;

@Data
public class GetContactsResponse {
    private String status;
    private String message;
    private List<ContactsDto> contactsDto;

    public static GetContactsResponse error(String message){
        GetContactsResponse response = new GetContactsResponse();
        response.status = "error";
        response.message = message;
        return response;
    }
}
