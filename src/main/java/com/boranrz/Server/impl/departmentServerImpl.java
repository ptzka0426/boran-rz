package com.boranrz.Server.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boranrz.Entity.department;
import com.boranrz.Mapper.departmentMapper;
import com.boranrz.Server.departmentServer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 * @Author LT
 * @create 2021-01-19 10:15
 */
@Service
@AutoConfigureAfter({departmentMapper.class})
public class departmentServerImpl extends ServiceImpl<departmentMapper, department> implements departmentServer {
}
