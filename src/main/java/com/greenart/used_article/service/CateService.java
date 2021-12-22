package com.greenart.used_article.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.greenart.used_article.data.CateHistoryVO;
import com.greenart.used_article.data.CateVO;
import com.greenart.used_article.mapper.CateMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CateService {
    @Autowired
    CateMapper mapper;
    public Map<String, Object> getCateList(Integer offset, String keyword){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(offset == null){ 
            offset = 0;
            resultMap.put("offset", offset);
        }
        if(keyword == null){
            keyword = "%%";
            resultMap.put("keyword","");
        }
        else{
            resultMap.put("keyword", keyword);
            keyword = "%"+keyword+"%";
        }
        List<CateVO> list = mapper.getCateInfo(offset, keyword);

        Integer cnt = mapper.getCateCount(keyword);
        Integer page_cnt = cnt / 10;
        if(cnt % 10 > 0) page_cnt++;
        resultMap.put("status", true);
        resultMap.put("total", cnt);
        resultMap.put("pageCnt", page_cnt);
        resultMap.put("list", list);
        return resultMap;
    }
    public Map<String, Object> addCate(CateVO data){
    Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        if(data.getCi_name() == null || data.getCi_name().equals("")){
            resultMap.put("status", false);
            resultMap.put("message", "카테고리명을 입력하세요");
            return resultMap;
        }
        if(data.getCi_writer() == null || data.getCi_writer().equals("")){
            resultMap.put("status", false);
            resultMap.put("message", "작성자를 입력하세요");
            return resultMap;
        }
        mapper.addCate(data);

        CateHistoryVO history = new CateHistoryVO();
        history.setCih_ci_name("new");
        history.setCih_ci_writer(data.makeHistoryStr());
        Integer recent_seq = mapper.getRecentAddedCateSeq();
        history.setCih_ci_seq(recent_seq);

        mapper.insertCateHistory(history);

        resultMap.put("status", true);
        resultMap.put("message", "카테고리가 추가되었습니다.");
    
        return resultMap;
    }
    public Map<String, Object> deleteCate(Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        mapper.deleteCate(seq);
        resultMap.put("status", true);
        resultMap.put("message", "카테고리가 삭제되었습니다.");

        CateHistoryVO history = new CateHistoryVO();
        history.setCih_ci_name("delete");
        history.setCih_ci_seq(seq);
        mapper.insertCateHistory(history);

        return resultMap;
    }
    public Map<String, Object> getCateInfoBySeq(Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        resultMap.put("status", true);
        resultMap.put("data", mapper.getCateInfoBySeq(seq));
        return resultMap;
    }
    public Map<String, Object> updateCateInfo(CateVO data){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        mapper.updateCate(data);
        resultMap.put("status", true);
        resultMap.put("message", "수정되었습니다.");

        CateHistoryVO history = new CateHistoryVO();
        history.setCih_ci_name("modify");
        history.setCih_ci_writer(data.makeHistoryStr());
        history.setCih_ci_seq(data.getCi_seq());
        mapper.insertCateHistory(history);

        return resultMap;
    }
    public Map<String, Object> getCateByKeyowrd(String keyword){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(keyword == null) keyword = "%%";
        keyword = "%"+keyword+"%";

        List<CateVO> list = mapper.getCateByKeyword(keyword);

        resultMap.put("status", true);
        resultMap.put("list", list);

        return resultMap;
    }

}
