package com.dsheo.book.springboot.domain.posts;

import com.dsheo.book.springboot.domain.BaseTimeEntity;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //Getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동 추가
@Entity
public class Posts extends BaseTimeEntity {//실제 DB 테이블과 매핑되는 Entity 클래스

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙 - auto_increment 가능
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
