package com.person.client;

import com.person.client.base.BaseClient;
import com.person.web.dto.request.PersonRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.List;

@Service
public class PersonClient extends BaseClient {
    private static final String API_PREFIX = "/api/v1/person";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public PersonClient(@Value("${person-server.url}") String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl + API_PREFIX))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
    }

    public ResponseEntity<Object> savePerson(PersonRequestDto requestDto) {
        logger.info("save person dto {}", requestDto);
        return post("", requestDto);
    }

    public ResponseEntity<Object> getPerson(long personId) {
        logger.info("get person by id = {}", personId);
        return get("/" + personId);
    }
}
