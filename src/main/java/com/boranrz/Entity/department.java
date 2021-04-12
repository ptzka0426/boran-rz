package com.boranrz.Entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * @Author LT
 * @create 2021-01-19 10:04
 */
public class department implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer did;
    private String dname;
    private Integer cid;
}
