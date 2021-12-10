package com.greenart.used_article.service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.used_article.mapper.DashboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired DashboardMapper mapper;
    public Map<String, Object> getCounts(){
        List<Integer> postCntList = new ArrayList<Integer>();
        postCntList.add(mapper.getAllPostCnt());
        postCntList.add(mapper.getNoticePostCnt());
        postCntList.add(mapper.getImagePostCnt());

        List<Integer> memberCntList = new ArrayList<Integer>();
        memberCntList.add(mapper.getAllMemberCnt());
        memberCntList.add(mapper.getRegularMemberCnt());
        memberCntList.add(mapper.getHaltMemberCnt());

        List<Integer> adminCntList = new ArrayList<Integer>();
        adminCntList.add(mapper.getAllAdminCnt());
        
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("post", postCntList);
        map.put("member", memberCntList);
        map.put("admin", adminCntList);
        
        return map;
    }
    
    
}
