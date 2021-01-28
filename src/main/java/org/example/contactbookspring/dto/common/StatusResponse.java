package org.example.contactbookspring.dto.common;

import lombok.Data;

@Data
public class StatusResponse {
    private Status status;
    private String message;
    public enum Status {
        OK, FAIL
    }
}