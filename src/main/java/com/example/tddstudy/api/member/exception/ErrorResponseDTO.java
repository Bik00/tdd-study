package com.example.tddstudy.api.member.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponseDTO {
    private final String message;
}
// { meesage: "닉네임은..." }