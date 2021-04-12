package com.boranrz.Server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boranrz.Entity.corporation;
import com.boranrz.Mapper.corporationMapper;
import com.boranrz.Server.corporationServer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 * @Author LT
 * @create 2021-01-19 10:10
 */
@Service
@AutoConfigureAfter({corporationMapper.class})
public class corporationServerImpl extends ServiceImpl<corporationMapper, corporation> implements corporationServer {
}
