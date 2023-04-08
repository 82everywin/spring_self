package org.koreait.models.member;

import lombok.RequiredArgsConstructor;
import org.koreait.controllers.members.Join;
import org.koreait.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberJoinService {


    private final PasswordEncoder passwordEncoder;

    private final MemberRepository repository;

    public void join(Join join){
        String hash = passwordEncoder.encode(join.getUserPw());
    }
}
