package com.example.tddstudy.api.member.model.dto;

import com.example.tddstudy.api.member.model.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

public class UserRequestDTO {

    @Getter
    public static class AddMember {

        @NotNull(message = "닉네임을 반드시 전달해주셔야 합니다.")
        @Length(min = 3, message = "닉네임은 최소 3글자 이상이어야 합니다.")
        @Pattern(regexp = ".*[0-9].*", message = "닉네임에 반드시 0~9 사이의 숫자가 하나 이상 포함되어야 합니다.")
        private final String nickname;

        @NotNull(message = "패스워드를 반드시 입력해주셔야 합니다.")
        @Length(min = 8, message = "패스워드는 8글자 이상이어야 합니다.")
        @Pattern(regexp = ".*[A-Z]?", message = "대문자 하나 이상 포함해야 합니다.")
        private final String password;

        @ConstructorProperties({"nickname", "password"})
        public AddMember(String nickname, String password) {
            this.nickname = nickname;
            this.password = password;
        }

        public Member toEntity() {
            return Member.builder()
                    .nickname(nickname)
                    .password(password)
                    .createAt(LocalDateTime.now())
                    .build();
        }
    }
}
