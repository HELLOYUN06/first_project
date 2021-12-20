package com.greenart.used_article.api;

import java.util.Map;

import com.greenart.used_article.data.PostVO;
import com.greenart.used_article.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostAPIController {
    @Autowired 
    PostService service;

    @PostMapping("/post/add")
    public Map<String, Object> postaddPost(@RequestBody PostVO data){
        return service.addPost(data);
    }
    @DeleteMapping("/post/delete")
    public Map<String, Object> deletePost(@RequestParam Integer seq){
        return service.deletePost(seq);
    }
    @GetMapping("/post/get")
    public Map<String, Object> getPostInfoBySeq(@RequestParam Integer seq){
        return service.getPostInfoBySeq(seq);
    }
    @PatchMapping("/post/update")
    public Map<String, Object> patchPostInfo(@RequestBody PostVO data){
        return service.updatePostInfo(data);
    }
}

