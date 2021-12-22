package com.greenart.used_article.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.used_article.data.PostHistoryVO;
import com.greenart.used_article.data.PostVO;
import com.greenart.used_article.mapper.PostMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PostService {
    @Autowired
    PostMapper mapper;
    public Map<String, Object> getPostList(String type, Integer offset, String keyword){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(keyword == null){
            resultMap.put("keyword", keyword);
            keyword = "%%";
        }
        else{
            resultMap.put("keyword", keyword);
            keyword = "%"+keyword+"%";
        }
        resultMap.put("type", type);

        if(offset == null) offset = 0;
        List<PostVO> list = mapper.getPostList(type, keyword, offset);
        Integer cnt = mapper.getPostCnt(type, keyword);
        Integer page = cnt / 10;
        if(cnt % 10 > 0) page++;

        resultMap.put("status", true);
        resultMap.put("pageCnt", page);
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
            return resultMap;
        }

        mapper.addPost(data);
        resultMap.put("status", true);
        resultMap.put("message", "게시글이 추가되었습니다.");
        Integer seq = mapper.selectLatestDataSeq();

        PostHistoryVO history = new PostHistoryVO();
        history.setPh_pi_seq(seq);
        history.setPh_type("new");
        String content = data.getPi_title()+"|"+data.getPi_sub()+"|"+data.getPi_rq_seq()+"|"+data.getPi_i_seq();
        history.setPh_content(content);   
        mapper.insertPostHistory(history);

        return resultMap;
    }
    public Map<String, Object> deletePost(Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        mapper.deletePost(seq);
        resultMap.put("status", true);
        resultMap.put("message", "게시글이 삭제되었습니다.");

        PostHistoryVO history = new PostHistoryVO();
        history.setPh_pi_seq(seq);
        history.setPh_type("delete");
        // String content = data.getPi_title()+"|"+data.getPi_sub()+"|"+data.getPi_rq_seq()+"|"+data.getPi_i_seq();
        // history.setPh_content(content);   
        mapper.insertPostHistory(history);

        return resultMap;
    }
    public Map<String, Object> getPostInfoBySeq(Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        resultMap.put("status", true);
        resultMap.put("data", mapper.getPostInfoBySeq(seq));
        return resultMap;
    }
    public Map<String, Object> updatePostInfo(PostVO data){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        mapper.updatePost(data);
        resultMap.put("status", true);
        resultMap.put("message", "수정되었습니다.");

        PostHistoryVO history = new PostHistoryVO();
        history.setPh_pi_seq(data.getPi_seq());
        history.setPh_type("update");
        String content = data.getPi_title()+"|"+data.getPi_sub()+"|"+data.getPi_rq_seq()+"|"+data.getPi_i_seq()+"|"+data.getPi_state();
        history.setPh_content(content);   
        mapper.insertPostHistory(history);

        return resultMap;
    }
    

}
