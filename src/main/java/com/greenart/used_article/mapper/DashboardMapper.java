package com.greenart.used_article.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DashboardMapper {
    public Integer getAllPostCnt();
    public Integer getNoticePostCnt();
    public Integer getImagePostCnt();

    public Integer getAllMemberCnt();
    public Integer getRegularMemberCnt();
    public Integer getHaltMemberCnt();

    public Integer getAllAdminCnt();

}
