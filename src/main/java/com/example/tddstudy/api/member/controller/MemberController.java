package com.example.tddstudy.api.member.controller;

import com.example.tddstudy.api.member.model.dto.UserRequestDTO;
import com.example.tddstudy.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> addMember(@RequestBody UserRequestDTO.AddMember user) {
        return ResponseEntity.ok().body(memberService.registerMember2(user));
    }
}
