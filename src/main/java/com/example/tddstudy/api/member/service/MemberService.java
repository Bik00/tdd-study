package com.example.tddstudy.api.member.service;

import com.example.tddstudy.api.member.model.Member;
import com.example.tddstudy.api.member.model.dto.UserRequestDTO;
import com.example.tddstudy.api.member.model.dto.UserResponseDTO;
import com.example.tddstudy.api.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.tddstudy.api.member.model.dto.UserResponseDTO.AddMember.convertResult;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public UserResponseDTO.AddMember registerMember(UserRequestDTO.AddMember user) {
        Member member = memberRepository.save(user.toEntity());
        if (member == null) throw new RuntimeException("fail");
        return convertResult(member);
    }

}
