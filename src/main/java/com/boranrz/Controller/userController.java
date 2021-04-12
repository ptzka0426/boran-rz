package com.boranrz.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boranrz.Entity.user;
import com.boranrz.Server.userServer;
import com.boranrz.Util.RedisUtil;
import com.boranrz.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LT
 * @create 2020-12-28 17:28
 */
@RestController
public class userController {
    @Autowired
    private userServer userServer;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(int pageNo, int pageSize) {
        IPage<user> page = new Page<>(pageNo, pageSize);
        /*        QueryWrapper<user> wrapper = new QueryWrapper<>();
         *//*
        if (desc == 1) {
            wrapper.orderByAsc("uupdate");
        } else {
            wrapper.orderByDesc("uupdate");
        }*/

        return Result.SUCCESS(userServer.page(page));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result logins(String yhm, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("yhm", yhm);
        map.put("password", password);
        List<user> users = userServer.listByMap(map);
        if (users != null && users.size() != 0) {
            redisUtil.add(yhm,yhm);
            return Result.SUCCESS(userServer.listByMap(map));
        } else {
            return Result.USER_LOGIN_ERROR();
        }
    }
}
