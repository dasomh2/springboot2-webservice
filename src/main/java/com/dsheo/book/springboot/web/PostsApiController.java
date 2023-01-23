package com.dsheo.book.springboot.web;

import com.dsheo.book.springboot.service.posts.PostsService;
import com.dsheo.book.springboot.web.dto.PostsResponseDto;
import com.dsheo.book.springboot.web.dto.PostsSaveRequestDto;
import com.dsheo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController { //등록, 수정, 삭제 등 기능 명시

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findbyId(@PathVariable Long id) {
        return postsService.findbyId(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

//    @GetMapping("/api/v1/posts/list")
//    public List<PostsListResponseDto> findAll() {
//        return postsService.findAllDesc();
//    }
}
