package com.person.web.converter;

import com.person.db.model.Person;
import com.person.web.dto.request.PersonRequestDto;

public class PersonRequestDtoToPerson {

    private PersonRequestDtoToPerson() {
    }

    public static Person convert(PersonRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Person person = new Person();

        person.setName(dto.getName());
        person.setAge(dto.getAge());
        person.setRussian(dto.getRussian());

        return person;
    }
}
