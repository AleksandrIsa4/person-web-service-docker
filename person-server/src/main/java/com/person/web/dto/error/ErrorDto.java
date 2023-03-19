package com.person.web.dto.error;

public class ErrorDto {
    private final String error;

    public ErrorDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
