package com.dsheo.book.springboot.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA 클래스들이 이 클래스 상속할 때 필드들도 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //Auditing 기능 포함 -> JPA에서 시간 값 자동으로 넣어주는 기능
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modeifiedDate;
}
