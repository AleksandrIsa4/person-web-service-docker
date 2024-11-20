package com.person.web.controller;

import com.person.client.PersonClient;
import com.person.web.dto.request.PersonRequestDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(
        value = "/api/v1/person",
        consumes = MediaType.ALL_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@CrossOrigin(origins = {"http://localhost:3000", "https://cyberplace.online", "http://cyberplace.online", "http://45.12.236.120"})
public class PersonController {

    private final PersonClient personClient;

    public PersonController(PersonClient personClient) {
        this.personClient = personClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPeople(@PathVariable("id") Long personId) {
        return ResponseEntity.accepted().body("Hello World!999");
     //   return personClient.getPerson(personId);
    }

    @GetMapping("/sss")
    public ResponseEntity<Object>  getPeople2() {
        return ResponseEntity.accepted().body("Hello World!");
     //   return "Hello World!";
    }

    @GetMapping("/sss5")
    public ResponseEntity<Object>  getPeople3() {
        return ResponseEntity.ok("Hello World!7");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> savePeople(@RequestBody @Valid PersonRequestDto peopleDto) {
        return personClient.savePerson(peopleDto);
    }
}
