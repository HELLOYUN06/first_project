package com.greenart.used_article.data;

import java.util.Date;

import lombok.Data;

@Data
public class PostVO {
    private Integer pi_seq;
    private String pi_title;
    private String pi_sub;
    private Integer pi_status;
    private Date pi_reg_dt;
    private Date pi_mod_dt;
    private Integer pi_state;
    
    private Integer pi_mi_seq;
    private Integer pi_i_seq;
    private Integer pi_rq_seq;
}
