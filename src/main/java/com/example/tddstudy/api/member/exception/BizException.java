package com.example.tddstudy.api.member.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
public class BizException extends RuntimeException {

    private final List<FieldError> fieldErrors;

    public BizException(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}