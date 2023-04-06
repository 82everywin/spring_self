package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity @Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardData {
    @Id
    private Long id;

    @Column(nullable = false,length = 100)
    private String subject; // 게시글 제목
    @Column(nullable = false)
    private String content; // 게시글 내용
    @Column(columnDefinition = "int default '0' not null")
    private int viewCounts; // 조회수

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDt ; // 등록 일시

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime modDt ; // 수정 일시
}
