package org.koreait.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Data
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime modDt;
}
