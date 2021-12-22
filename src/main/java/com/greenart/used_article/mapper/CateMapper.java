package com.greenart.used_article.mapper;

import java.util.List;

import com.greenart.used_article.data.CateHistoryVO;
import com.greenart.used_article.data.CateVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CateMapper {
    public List<CateVO> getCateInfo(Integer offset, String keyword);
    public Integer getCateCount(String keyword);
    public void addCate(CateVO data);
    public void deleteCate(Integer seq);
    public CateVO getCateInfoBySeq(Integer seq);
    public void updateCate(CateVO data);
    public List<CateVO> getCateByKeyword(String keyword);

    public void insertCateHistory(CateHistoryVO history);
    public Integer getRecentAddedCateSeq();

}
