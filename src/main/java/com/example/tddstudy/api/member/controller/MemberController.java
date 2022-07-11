package com.example.tddstudy.api.member.controller;

import com.example.tddstudy.api.member.exception.BizException;
import com.example.tddstudy.api.member.model.dto.UserRequestDTO;
import com.example.tddstudy.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> addMember(@Valid @RequestBody UserRequestDTO.AddMember user, BindingResult result) {
        if (result.hasErrors()) throw new BizException(result.getFieldErrors());
        return ResponseEntity.ok().body(memberService.registerMember(user));
    }
}
