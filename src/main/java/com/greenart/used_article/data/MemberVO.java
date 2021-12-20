package com.greenart.used_article.data;

import java.sql.Date;

import lombok.Data;

@Data   
public class MemberVO {
    private Integer mi_seq;
    private String mi_id;
    private Integer mi_state;
    private String mi_name;
    private String mi_pwd;
    private String mi_birth;
    private String mi_email;
    private String mi_address;
    private Integer mi_phone_num;
    private Date mi_reg_dt;
}
