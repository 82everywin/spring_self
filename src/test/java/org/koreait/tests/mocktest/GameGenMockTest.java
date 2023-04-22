package org.koreait.tests.mocktest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {

    @Test
    void mockTest(){
        // mockito.mock()
        // 클래스, 인터페이스, 추상클래스에 대해 모의 객체 생성 가능

        // 모의 객체 설정
        GameNumGen genMock = mock(GameNumGen.class);

        // 스텁 설정
        given(genMock.generate(GameLevel.EASY)).willReturn("123");


        // 스텁 설정에 매칭되는 메서드 실행
        String num = genMock.generate(GameLevel.EASY);
        assertEquals("123",num);

    }
}
