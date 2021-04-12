package com.boranrz.Vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author LT
 * @create 2021-01-19 10:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class QuestionLogVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    Integer lid;
    String name;
    String content;
    String img;
    String data;
    Integer uid;
}
