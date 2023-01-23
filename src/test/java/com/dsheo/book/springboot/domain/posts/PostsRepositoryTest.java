package com.dsheo.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("dsheo@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2023,1,8,0,0,0);
        postsRepository.save(Posts.builder()
                .title("타이틀")
                .content("용민이 바보")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>> " + posts.getTitle() + "////" + posts.getContent());
        System.out.println(">>>>>>>>>>> create date = " + posts.getCreatedDate());
        System.out.println(">>>>>>>>>>> modified date = " + posts.getModeifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModeifiedDate()).isAfter(now);
    }
}
