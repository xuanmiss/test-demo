package com.miss.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created By peishengzhang
 * <p>
 * At 2018/11/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route implements Serializable {

    private Integer id;
    private String path;
    private Integer order;
    private String companyCode;
    private String url;
}
