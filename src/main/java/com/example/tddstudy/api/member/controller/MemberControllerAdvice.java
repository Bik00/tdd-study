package com.example.tddstudy.api.member.controller;

import com.example.tddstudy.api.member.exception.BizException;
import com.example.tddstudy.api.member.exception.ErrorResponseDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class MemberControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDTO> handleRuntimeException(RuntimeException e) {
        return ResponseEntity
                .internalServerError()
                .body(new ErrorResponseDTO(e.getMessage()));
    }

    @ExceptionHandler(BizException.class)
    public ResponseEntity<ErrorResponseDTO> handleBizException(BizException e) {

        String errors = e.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining());

        return ResponseEntity
                .badRequest()
                .body(new ErrorResponseDTO(errors));
    }
}
/*
    {
        {
           message: "닉네임은 최소 3글자 이상이어야 합니다",
           rejectedValue: ab
        },
        {
           message: "비밀번호는 반드시 필요합니다",
           rejectValue: null
        }
    }

 */
