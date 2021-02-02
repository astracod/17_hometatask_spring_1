package org.example.contactbookspring.dao.implementation;

import lombok.RequiredArgsConstructor;
import org.example.contactbookspring.dao.ContactsDao;
import org.example.contactbookspring.entities.Contact;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ContactJdbcDao implements ContactsDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<Contact> getAll() {
        return jdbcTemplate.query(
                "SELECT id, name , number FROM contactsjdbc",
                new BeanPropertyRowMapper<>(Contact.class)
                /*(rs, i) -> new Contact(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("number")
                )*/
        );
    }

    @Override
    public void add(Contact contact) {
        jdbcTemplate.update(
                "INSERT INTO contactsjdbc(id,name,number) values (:id,:name,:number)",
                new BeanPropertySqlParameterSource(contact)
                /*Map.of(
                        "id", contact.getId(),
                        "name", contact.getName(),
                        "number", contact.getNumber()
                )*/
        );
    }
}