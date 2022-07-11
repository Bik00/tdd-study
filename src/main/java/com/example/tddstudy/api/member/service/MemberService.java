package com.example.tddstudy.api.member.service;

import com.example.tddstudy.api.member.model.Member;
import com.example.tddstudy.api.member.model.dto.UserRequestDTO;
import com.example.tddstudy.api.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public boolean registerMember(UserRequestDTO.AddMember user) {
        return false;
    }

    public String registerMember2(UserRequestDTO.AddMember user) {
        Member member = memberRepository.save(user.toEntity());
        if (member == null) throw new RuntimeException("fail");
        return "success";
    }
}
