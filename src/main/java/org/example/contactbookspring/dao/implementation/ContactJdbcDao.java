package org.example.contactbookspring.dao.implementation;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.contactbookspring.dao.ContactsDao;
import org.example.contactbookspring.entities.Contact;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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


    // "SELECT id, name , phone FROM contacts WHERE name LIKE ?"
    @Override
    public List<Contact> findNumberPart(String numberPart) {
        return jdbcTemplate.query(
                "SELECT * FROM contactsjdbc WHERE number LIKE :numberPart",
                Map.of("numberPart", "%" + numberPart + "%"),
                new BeanPropertyRowMapper<>(Contact.class)
        );
    }

}
