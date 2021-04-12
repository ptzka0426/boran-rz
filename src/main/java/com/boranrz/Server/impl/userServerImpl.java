package com.boranrz.Server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boranrz.Entity.user;
import com.boranrz.Mapper.userMapper;
import com.boranrz.Server.userServer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 * @Author LT
 * @create 2020-12-28 17:17
 */
@Service
@AutoConfigureAfter({userMapper.class})
public class userServerImpl extends ServiceImpl<userMapper, user> implements userServer {
}
