package com.miss.kafkademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created By peishengzhang
 * <p>
 * At 2019/3/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {


    private static final long serialVersionUID;

    static {
        serialVersionUID = -5386705770163287164L;
    }

    private String name;
    private int age;

}
