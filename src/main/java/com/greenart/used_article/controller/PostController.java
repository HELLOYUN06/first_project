package com.greenart.used_article.controller;


import com.greenart.used_article.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PostController {
    @Autowired
    PostService service;
    @GetMapping("/post")
    public String getPost(Model model, 
        @RequestParam @Nullable String type,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer offset
        
        ){
        model.addAttribute("data", service.getPostList(type, offset, keyword));
        return "/postInfo/list";
    }
}
    

