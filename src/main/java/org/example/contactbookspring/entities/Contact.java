package org.example.contactbookspring.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    private String id;
    private String name;
    private String number;

    @Override
    public String toString() {
        return " Порядковый номер : " + id + " , Имя контакта : " + name + " , номер контакта :" + number;
    }
}
