package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.BoardData;
import org.koreait.repositories.BoardDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
public class BoardDataRepositoryTest {

    @Autowired
    BoardDataRepository repository;

    @Test
    @DisplayName("보드 형성 테스트")
    public void boardDataTest(){
        BoardData boardData = new BoardData();
        boardData.setSubject("제목넣을게유");
        boardData.setContent("내용은 so simple..졸리다..");

       BoardData savedata= repository.save(boardData);
        System.out.println(savedata);
    }
}
