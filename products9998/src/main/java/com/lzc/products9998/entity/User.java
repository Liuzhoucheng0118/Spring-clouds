package com.lzc.products9998.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liuzhoucheng
 * @Date 2021/12/29 20:27
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private Integer age;
}
