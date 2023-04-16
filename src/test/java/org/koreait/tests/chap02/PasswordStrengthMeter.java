package org.koreait.tests.chap02;

import org.apache.tomcat.util.buf.CharChunk;

public class PasswordStrengthMeter {
    /**
     * 보안 강도 기준
     * 1) 길이가 8자 이상 2) 0-9 사이의 숫자를 포함 3) 대문자 포함
     * => 3가지 충족 : '강함', 2가지 충족 : '보통', 1가지 충족 : '약함'
     * @param s
     * @return
     */

    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
        int metCounts = 0;
        if(s.length()>=8) metCounts++;
        if(meetsContaningNumberCriteria(s)) metCounts++;
        if(meestzConianingUppercaseCriteria(s)) metCounts++;

        if(metCounts ==0) return PasswordStrength.WEAK;
        if (metCounts == 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
       }

    private boolean meestzConianingUppercaseCriteria(String s){
        for(char ch:s.toCharArray()){
            if(Character.isUpperCase(ch)){
                return true;
            }
        }
       return false;
    }

    private boolean meetsContaningNumberCriteria(String s){
        for(char ch:s.toCharArray()){
            if(ch>='0' && ch<='9'){
                return true;
            }
        }
        return false;
    }
}
