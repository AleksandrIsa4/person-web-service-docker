package com.person.client;

import com.person.client.base.BaseClient;
import com.person.web.dto.request.PersonRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Service
public class PersonClient extends BaseClient {
    private static final String API_PREFIX = "/api/v1/person";

    public PersonClient(@Value("${person-server.url}") String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl + API_PREFIX))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
    }

    public ResponseEntity<Object> savePerson(PersonRequestDto requestDto) {
        return post("", requestDto);
    }

    public ResponseEntity<Object> getPerson(long personId) {
        return get("/" + personId);
    }
}
