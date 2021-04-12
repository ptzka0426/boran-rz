package com.boranrz.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boranrz.Entity.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author LT
 * @create 2020-12-28 17:15
 */
@Mapper
public interface userMapper extends BaseMapper<user> {

}
