package com.boranrz.Server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boranrz.Entity.log;
import com.boranrz.Vo.QuestionLogVo;
import org.springframework.stereotype.Service;

/**
 * @Author LT
 * @create 2021-01-12 10:08
 */
public interface logServer extends IService<log> {

    /**
     *
     * 1为管理员
     * @return
     */
    IPage<log> getQuestionLog1(IPage<log> page,int id, String data, String name);
    /**
     * 2为部门管理
     * @return
     */
    IPage<log> getQuestionLog2(IPage<log> page,int id, String data, String name);

}
