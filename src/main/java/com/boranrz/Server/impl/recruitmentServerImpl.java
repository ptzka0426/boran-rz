package com.boranrz.Server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boranrz.Entity.recruitment;
import com.boranrz.Mapper.recruitmentMapper;
import com.boranrz.Server.recruitmentServer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 * @Author LT
 * @create 2021-01-25 10:26
 */
@Service
@AutoConfigureAfter({recruitmentMapper.class})
public class recruitmentServerImpl extends ServiceImpl<recruitmentMapper, recruitment> implements recruitmentServer {
}
