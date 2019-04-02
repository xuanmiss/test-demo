package com.miss.kafkademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;

import java.io.Serializable;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/3/27
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {


    private static final long serialVersionUID;

    static {
        serialVersionUID = -2454370093517290509L;
    }

    private String country;

    private String province;

    private String street;


}
