package com.person.web.controller;

import com.person.db.model.Person;
import com.person.service.PersonService;
import com.person.web.converter.PersonRequestDtoToPerson;
import com.person.web.converter.PersonToPersonResponseDto;
import com.person.web.dto.request.PersonRequestDto;
import com.person.web.dto.response.PersonResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/api/v1/person",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@CrossOrigin(origins = {"http://localhost:3000", "https://cyberplace.online", "http://cyberplace.online", "http://45.12.236.120"})
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public PersonResponseDto getPeople(@PathVariable("id") Long personId) {
        System.out.println("1234");
        Person people = personService.getPerson(personId);
        return PersonToPersonResponseDto.convert(people);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long savePeople(@RequestBody PersonRequestDto peopleDto) {
        Person person = PersonRequestDtoToPerson.convert(peopleDto);
        return personService.savePerson(person);
    }
}
