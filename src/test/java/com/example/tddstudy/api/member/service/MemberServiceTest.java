package com.example.tddstudy.api.member.service;

import com.example.tddstudy.api.member.model.Member;
import com.example.tddstudy.api.member.model.dto.UserRequestDTO;
import com.example.tddstudy.api.member.model.dto.UserResponseDTO;
import com.example.tddstudy.api.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;

class MemberServiceTest {

    private MemberRepository memberRepository = Mockito.mock(MemberRepository.class);
    private MemberService memberService = new MemberService(memberRepository);

    @Test
    @DisplayName("유저 등록이 성공적으로 완료되어야 합니다.")
    void success_register_member() {

        // 준비
        Member member = Member.builder()
                .id(1L)
                .nickname("bikoo")
                .password("12346")
                .createAt(LocalDateTime.now())
                .build();

        given(memberRepository.save(any(Member.class))).willReturn(member); // save 함수의 결과값을 개발자가 직접 지정해준다.

        // 실행
        UserResponseDTO.AddMember response = memberService.registerMember(new UserRequestDTO.AddMember("bikoo", "12346"));

        // 검증
        assertThat(response.getNickname()).isEqualTo("bikoo");
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getPassword()).isEqualTo("12346");

        // mock 객체에 대한 검증
        verify(memberRepository, atMostOnce()).save(any(Member.class));
    }

    @Test
    @DisplayName("유저가 정상 등록되지 못했다면 fail 메세지를 반환해야 합니다.")
    void fail_register_member_when_member_is_null() {

        // 준비
        Member member = Member.builder()
                .id(1L)
                .nickname("bikoo")
                .password("12346")
                .createAt(LocalDateTime.now())
                .build();

        given(memberRepository.save(any(Member.class))).willReturn(null); // save 함수의 결과값을 개발자가 직접 지정해준다.

        // 검증
        assertThatThrownBy(() ->  memberService.registerMember(new UserRequestDTO.AddMember("bikoo", "12346")))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("fail");

        // mock 객체에 대한 검증
        verify(memberRepository, atMostOnce()).save(any(Member.class));
    }
}