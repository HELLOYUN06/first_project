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

    public String makeHistoryStr(){
        return ci_seq+"|"+ci_name+"|"+ ci_writer+"|"+ ci_reg_dt+"|"+ ci_mod_dt;
    }
}
