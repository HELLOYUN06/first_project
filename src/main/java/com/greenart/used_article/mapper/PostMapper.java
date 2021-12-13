package com.greenart.used_article.mapper;

import java.util.List;

import com.greenart.used_article.data.PostVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    public List<PostVO> getPostInfo(Integer offset);
    public Integer getPostCount();
    public void addPost(PostVO data);
}
