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
 * @create 2021-01-25 10:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("recruitment")
public class recruitment implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer rid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 邮箱
     */
    private String emali;
    /**
     * 电话
     */
    private String phone;
    /**
     * 留言
     */
    private String leavetext;
    /**
     * 地址
     */
    private String file;
}
