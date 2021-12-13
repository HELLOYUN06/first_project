package com.greenart.used_article.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.greenart.used_article.data.PostVO;
import com.greenart.used_article.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostAPIController {
    @Autowired 
    PostService service;
    @PostMapping("/post/add")
    public Map<String, Object> postaddPost(@RequestBody PostVO data){
        return service.addPost(data);
    }
}
