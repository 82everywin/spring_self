package org.koreait.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.koreait.commons.constants.Role;

@Entity
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long userNo;

    @Column(length = 45, nullable = false, unique = true)
    private String userId;

    @Column(length = 45, nullable = false)
    private String userNm;

    @Column(length = 65, nullable = false)
    private String userPw;

    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length=30)
    private Role role = Role.MEMBER;


}
