package com.greenart.used_article.data;

import java.util.Date;

import lombok.Data;
@Data
public class CateHistoryVO {
    private Integer cih_seq;
    private Integer cih_ci_seq;
    private String cih_ci_writer;
    private String cih_ci_name;
    private Date cih_reg_dt;
}
