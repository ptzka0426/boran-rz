package com.boranrz.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Result;
import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LT
 * @create 2021-01-12 10:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("log")
public class log implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    Integer lid;
    String name;
    String content;
    String img;
    String data;
    Integer uid;
}
/*
@TableField(exist = false)：表示该属性不为数据库表字段，但又是必须使用的。

@TableField(exist = true)：表示该属性为数据库表字段。*/
