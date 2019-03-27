package com.miss.redisdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/11/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token implements Serializable {

    private Integer id;
    private String key;
    private String value;
    private Integer expireTime;
    private String createdBy;
    private Date creationDate;


}
