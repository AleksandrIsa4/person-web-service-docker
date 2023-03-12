package com.person.web.converter;

import com.person.db.model.Person;
import com.person.web.dto.response.PersonResponseDto;

public class PersonToPersonResponseDto {

    private PersonToPersonResponseDto() {
    }

    public static PersonResponseDto convert(Person person) {
        PersonResponseDto personDto = new PersonResponseDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setAge(person.getAge());
        personDto.setRussian(person.getRussian());
        return personDto;
    }
}
