package com.greenart.used_article.data;

import java.util.Date;

import lombok.Data;

@Data
public class CateVO {
    private Integer ci_seq;
    private String ci_name;
    private String ci_writer;
    private Date ci_reg_dt;
    private Date ci_mod_dt;
}
