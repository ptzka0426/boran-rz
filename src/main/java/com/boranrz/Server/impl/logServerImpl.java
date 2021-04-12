package com.boranrz.Server.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boranrz.Entity.log;
import com.boranrz.Mapper.logMapper;
import com.boranrz.Server.logServer;
import com.boranrz.Vo.QuestionLogVo;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 * @Author LT
 * @create 2021-01-12 10:09
 */
@Service
@AutoConfigureAfter({logMapper.class})
public class logServerImpl extends ServiceImpl<logMapper, log>implements logServer {

    @Override
    public IPage<log> getQuestionLog1(IPage<log> page,int id,  String data, String name) {
        return page.setRecords(this.baseMapper.getQuestionLog1(page,id,data,name));
    }
    @Override
    public IPage<log> getQuestionLog2(IPage<log> page,int id,  String data, String name) {
        return page.setRecords(this.baseMapper.getQuestionLog2(page,id,data,name));
    }
}
