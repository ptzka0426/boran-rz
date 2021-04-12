package com.boranrz.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author LT
 * @create 2020-12-28 17:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user")
public class user implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private int id;
    private String yhm;
    private String password;
    private String name;
    private Integer power;//权限（1.admin 2.管理 3.普通）
    private Integer did;//部门id
}
