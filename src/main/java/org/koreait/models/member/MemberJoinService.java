package org.koreait.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberJoinService {

    @Autowired
    private PasswordEncoder passwordEncoder;


}