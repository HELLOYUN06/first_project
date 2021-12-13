package com.greenart.used_article.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.used_article.data.PostVO;
import com.greenart.used_article.mapper.PostMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PostService {
    @Autowired
    PostMapper mapper;

    public Map<String, Object> getPostList(Integer offset){
        if(offset == null) offset = 0;

        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<PostVO> list = mapper.getPostInfo(offset);

        Integer cnt = mapper.getPostCount();
        Integer page_cnt = cnt / 10;
        if(cnt % 10 > 0) page_cnt++;
        resultMap.put("status", true);
        resultMap.put("total", cnt);
        resultMap.put("pageCnt", page_cnt);
        resultMap.put("list", list);

        return resultMap;
    }

    public Map<String, Object> addPost(PostVO data){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        if(data.getPi_title() == null || data.getPi_title().equals("")){
            resultMap.put("status", false);
            resultMap.put("message", "제목을 입력하세요");
            return resultMap;
        }
        if(data.getPi_sub() == null || data.getPi_sub().equals("")){
            resultMap.put("status", false);
            resultMap.put("message", "내용을 입력하세요");
        }
        if(data.getPi_mi_seq() == null || data.getPi_mi_seq()==0){
            resultMap.put("status", false);
            resultMap.put("message", "작성자를 입력하세요");
        }

        mapper.addPost(data);
        resultMap.put("status", true);
        resultMap.put("message", "게시글이 추가되었습니다.");
        return resultMap;
    }
    public Map<String, Object> deletePost(Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        mapper.deletePost(seq);
        resultMap.put("status", true);
        resultMap.put("message", "게시글이 삭제되었습니다.");
        return resultMap;
    }
}
