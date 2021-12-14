package com.greenart.used_article.data;

import java.sql.Date;

import lombok.Data;

@Data
public class PostHistoryVO {
    private Integer ph_seq;
    private Integer ph_pi_seq;
    private String ph_type;
    private String ph_content;
    private Date ph_reg_dt;
}