package com.greenart.used_article.mapper;

import java.util.List;

import com.greenart.used_article.data.PostHistoryVO;
import com.greenart.used_article.data.PostVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    public List<PostVO> getPostInfo(Integer offset, String keyword);
    public Integer getPostCount(String keyword);
    public void addPost(PostVO data);

    public void deletePost(Integer seq);
    public PostVO getPostInfoBySeq(Integer seq);
    public void updatePost(PostVO data);

    public Integer selectLatestDataSeq();
    public void insertPostHistory(PostHistoryVO data);

    public List<PostVO> getPostList(String type, String keyword, Integer offset);
    public Integer getPostCnt(String type, String keyword);
}
