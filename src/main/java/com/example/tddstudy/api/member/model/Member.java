package com.example.tddstudy.api.member.model;

import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String password;

    @CreationTimestamp
    private LocalDateTime createAt;

    public Member() {}

    @Builder
    public Member(Long id, String nickname, String password, LocalDateTime createAt) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.createAt = createAt;
    }

}
