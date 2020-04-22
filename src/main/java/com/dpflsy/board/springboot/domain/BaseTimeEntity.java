// JPA Auditing으로 생성시간 및 수정시간 자동화하기
// 기본날짜타입 Date 문제점 해결 => LocalDate/LocalDateTime
package com.dpflsy.board.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//모든 엔티티의 상위 클래스가 되어 엔티티드르이 createdDate, modifiedDate를 자동으로 관리
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
