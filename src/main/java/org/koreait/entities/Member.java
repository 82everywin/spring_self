package org.koreait.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long userNo;

    private String userId;
    private String userNm;
    private String userPw;
    private String userPwRe;
    private String email;


}
