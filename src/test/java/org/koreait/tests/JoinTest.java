package org.koreait.tests;
/**
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.koreait.config.ControllerConfig;
import org.koreait.config.MvcConfig;
import org.koreait.models.member.Member;
import org.koreait.models.member.MemberDao;
import org.koreait.models.member.UserJoinFailException;
import org.koreait.models.member.UserJoinService;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import org.mindrot.jbcrypt.BCrypt;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@ContextConfiguration(classes= {MvcConfig.class, ControllerConfig.class})
@WebAppConfiguration
class UserJoinTest {

    @Autowired
    private UserJoinService userJoinService;

    @Autowired
    private MemberDao memberDao;

    private Member getMember() {
        long num = System.currentTimeMillis();
        Member member = new Member();
        member.setUserId("user" + num);
        member.setUserPw("123456");
        member.setUserNm("사용자" + num);
        member.setEmail("user"+num + "@test.org");
        member.setMobile("01000000000");
        return member;
    }

    @Test
    @DisplayName("회원가입 성공시 true 반환")
    public void joinSuccessTest() {
        Member member = getMember();

        boolean result = userJoinService.join(member);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Member가 null값일때 JoinFailException 발생 여부 체크")
    public void joinMemberNullFailTest() {

        UserJoinFailException thrown = assertThrows(UserJoinFailException.class,() -> {
            userJoinService.join(null);
        });

        String message = thrown.getMessage();
        assertEquals(message.contains("잘못된 접근"), true);
    }

    @Test
    @DisplayName("Member 객체에 항목들의 값이 없으면 예외 발생")
    public void joinMemberEmptyFieldFailTest() {
        assertThrows(Exception.class, () -> {
            Member member = new Member();
            userJoinService.join(member);
        });
    }

    @Test
    @DisplayName("회원가입 완료 후 비밀번호가 해시화 되었는지 테스트")
    public void afterJoinPasswordHashTest() {
        /
         *   1. 회원 가입
         *   2. 회원 조회
         *   3. 조회한 회원 비번과 가입할때 비번 다른지
         *   4. bcrypt로 비번 검증도 일치하는지 체크



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;Member member = getMember();
        String userPw = member.getUserPw();
        String userId = member.getUserId();
        userJoinService.join(member);

        Member newMember = memberDao.get(userId);

        String newUserPw = newMember.getUserPw();
        // 조회한 회원 비번과 가입할때 비번 다른지
        assertEquals(userPw.equals(newUserPw), false);

        // bcrypt로 비번 검증도 일치하는지 체크
        boolean matched = BCrypt.checkpw(userPw, newUserPw);
        assertEquals(matched, true);

    }

    @Test
    @DisplayName("생성된 해시와 123456 비번이 일치하는지 체크")
    public void hashEqualTest() {
        String hash= "$2a$12$pRPw8mroGeZdqQPuoxG22OAshmdngF11.oA93wwW/lZGXq/FRzW3a";
        String passwd = "123456";
        boolean matched = BCrypt.checkpw(passwd, hash);
        assertEquals(matched, true);
    }

    @Test
    @DisplayName("회원ID - user1678878713312 DB 조회시, 실 해시와 일치 테스트")
    public void hashEqualTest2() {
        String userId = "user1678878713312";
        String hash= "$2a$12$pRPw8mroGeZdqQPuoxG22OAshmdngF11.oA93wwW/lZGXq/FRzW3a";
        Member member = memberDao.get(userId);

        assertEquals(member.getUserPw(), hash);
    }
}

**/