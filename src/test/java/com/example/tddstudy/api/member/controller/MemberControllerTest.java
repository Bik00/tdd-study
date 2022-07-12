package com.example.tddstudy.api.member.controller;

import com.example.tddstudy.api.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@WebMvcTest({MemberController.class, MemberControllerAdvice.class}) // @Controller 어노테이션이 붙은 빈들만 애플리케이션 컨텍스트안에 넣어줌.
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc; // mockmvc -> http 요청을 해주는 객체.

    @MockBean
    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("회원 등록이 성공적으로 완료되어야 합니다.")
    void success_addMember() throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("nickname", "mrKim90");
        map.put("password", "123456789");

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/member/register")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON + ";charset=UTF-8")
                .content(objectMapper.writeValueAsString(map))
                );

        actions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
             //   .andExpect(MockMvcResultMatchers.content().string("success"));
    }

    @Test
    @DisplayName("회원 비밀번호가 전달되지 않을 경우 회원 등록이 실패해야 합니다.")
    void fail_addMember_notContain_password() {

    }

    @Test
    @DisplayName("회원 닉네임이 3글자를 넘지 않을 경우 회원 등록이 실패해야 합니다.")
    void fail_addMember_not_over_3_words() {

    }

    @Test
    @DisplayName("회원 닉네임에 0~9 사이의 숫자가 없을 경우 회원 등록이 실패해야 합니다.")
    void fail_addMember_notContain_digit() {

    }

    @Test
    @DisplayName("회원 비밀번호가 8글자를 넘지 않는 경우 회원 등록이 실패해야 합니다.")
    void fail_addMember_not_over_8_words() {

    }

    @Test
    @DisplayName("회원 비밀번호에 대문자가 없는 경우 회원 등록이 실패해야 합니다.")
    void fail_addMember_notContain_upperCase() {

    }
}