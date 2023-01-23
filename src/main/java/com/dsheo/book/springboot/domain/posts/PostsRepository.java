package com.dsheo.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
//Dao (DB Layer)
//<Entity, PK>, Entity 파일이랑 같이 붙어 있어야함 (Posts.java)
public interface PostsRepository extends JpaRepository<Posts, Long> {

//    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
//    List<Posts> findAllDesc();


//    findAll() : 해당 엔티티 테이블에 있는 모든 데이터를 조회한다.
//    save() : 대상 엔티티를 DB에 저장한다.
//    saveAll() : Iterable 가능한 객체를 저장한다.
//    delete() : 데이터베이스에서 대상 엔티티를 삭제한다.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
