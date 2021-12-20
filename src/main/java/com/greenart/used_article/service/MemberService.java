package com.greenart.used_article.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.used_article.data.MemberVO;
import com.greenart.used_article.mapper.MemberMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired 
    MemberMapper mapper;
    public Map<String, Object> getMemberList(Integer offset, String keyword){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(offset == null){
            offset = 0;
            resultMap.put("offset", offset);
        }
        if(keyword == null){
            keyword = "%%";
            resultMap.put("keyword", "");
        }
        else{
            resultMap.put("keyword", keyword);
            keyword = "%"+keyword+"%";
        }
        List<MemberVO> list = mapper.getMemberInfo(offset, keyword);

        Integer cnt = mapper.getMemberCount(keyword);
        Integer page_cnt = cnt / 10;
        if(cnt% 10 > 0) page_cnt++;
        resultMap.put("status", true);
        resultMap.put("total", cnt);
        resultMap.put("pageCnt", page_cnt);
        resultMap.put("list", list);
        return resultMap;
    }

}
