package com.greenart.used_article.mapper;

import java.util.List;

import com.greenart.used_article.data.MemberVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public List<MemberVO> getMemberInfo(Integer offset, String keyword);
    public Integer getMemberCount(String keyword);
    public void addMember(MemberVO data);
}
