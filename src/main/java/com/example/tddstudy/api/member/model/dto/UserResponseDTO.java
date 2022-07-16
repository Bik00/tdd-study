package com.example.tddstudy.api.member.model.dto;

import com.example.tddstudy.api.member.model.Member;
import lombok.Builder;
import lombok.Getter;

public class UserResponseDTO {

    @Getter
    public static class AddMember {

        private final Long id;
        private final String nickname;
        private final String password;

        @Builder
        public AddMember(Long id, String nickname, String password) {
            this.id = id;
            this.nickname = nickname;
            this.password = password;
        }

        public static AddMember convertResult(Member member) {
            return
                    AddMember.builder()
                            .id(member.getId())
                            .nickname(member.getNickname())
                            .password(member.getPassword()).build();
        }

    }


}
