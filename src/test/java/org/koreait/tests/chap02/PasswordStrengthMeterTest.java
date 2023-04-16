package org.koreait.tests.chap02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.security.core.parameters.P;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr,result);
    }
    @Test
    @DisplayName("암호강도 셈")
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB",PasswordStrength.STRONG);
        assertStrength("abc1!Add",PasswordStrength.STRONG);
    }

    @Test
    @DisplayName("암호 강도 중간")
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A",PasswordStrength.NORMAL);
        assertStrength("Ab!12c",PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("암호 강도 중간 _ 숫자 포함x")
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        assertStrength("ab!@ABqwer",PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("값이 없는 경우")
    void nullInput_Then_Invalid(){
        assertStrength(null,PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("값이 없는 경우 - 빈 문자열")
    void emptyInput_Then_Invalid(){
        assertStrength(null,PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("대문자 포함하지 않은 경우")
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df",PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("보안 강도 정도 - 약함, 8자 이상만 충족")
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abcdefghi",PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("보안 강도 정도 - 약함, 숫자 포함만 충족 ")
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345",PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("보안 강도 정도 - 약함, 대문자 포함만 충족")
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABCDEF",PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("아무 조건 충족x ")
    void meetsNoCriteria_Then_Weak(){
        assertStrength("abcd", PasswordStrength.WEAK);
    }
}
