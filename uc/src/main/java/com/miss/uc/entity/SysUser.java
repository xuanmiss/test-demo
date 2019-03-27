package com.miss.uc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/10/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {

    private Integer id;
    private String avatar;
    private String account;
    private String password;
    private String salt;
    private String name;
    private String email;
    private Integer age;
    private Date birthday;
    private String phone;
    private Integer sex;
    private String roleid;
    private Integer deptid;
    private Integer status;
    private Date createtime;
    private Integer version;

}
