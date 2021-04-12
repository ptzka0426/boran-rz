package com.boranrz.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LT
 * @create 2021-01-19 9:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("log")
public class corporation implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer  cid;
    private String cname;
    private String time;
}
