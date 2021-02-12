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
        );
    }

    @Override
    public void add(Contact contact) {
        jdbcTemplate.update(
                "INSERT INTO contactsjdbc(id,name,number) values (:id,:name,:number)",
                new BeanPropertySqlParameterSource(contact)
        );
    }

    @Override
    public void remove(String id) {
        jdbcTemplate.update(
                "DELETE FROM contactsjdbc WHERE id=:id",
                Map.of("id", id)
        );
    }


    @Override
    public List<Contact> findByName(String name) {
        return jdbcTemplate.query(
                "SELECT * FROM contactsjdbc WHERE name=:name",
                Map.of("name", name),
                new BeanPropertyRowMapper<>(Contact.class)
        );
    }


    @Override
    public List<Contact> findNumberPart(String numberPart) {
        return jdbcTemplate.query(
                "SELECT * FROM contactsjdbc WHERE number LIKE :numberPart",
                Map.of("numberPart", "%" + numberPart + "%"),
                new BeanPropertyRowMapper<>(Contact.class)
        );
    }

}
