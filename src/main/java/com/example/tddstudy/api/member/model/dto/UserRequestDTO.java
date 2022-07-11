package com.example.tddstudy.api.member.model.dto;

import com.example.tddstudy.api.member.model.Member;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

public class UserRequestDTO {

    @RequiredArgsConstructor
    public static class AddMember {
        private final String nickname;
        private final String password;

        public Member toEntity() {
            return Member.builder()
                    .nickname(nickname)
                    .password(password)
                    .createAt(LocalDateTime.now())
                    .build();
        }
    }
}
