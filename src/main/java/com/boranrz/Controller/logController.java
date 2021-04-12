package com.boranrz.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boranrz.Entity.log;
import com.boranrz.Entity.user;
import com.boranrz.Server.logServer;
import com.boranrz.Server.userServer;
import com.boranrz.Util.FTPUtil;
import com.boranrz.Util.RedisUtil;
import com.boranrz.Vo.QuestionLogVo;
import com.boranrz.common.response.Result;
import org.apache.commons.net.ftp.FTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LT
 * @create 2021-01-12 10:13
 */
@RestController
public class logController {

    @Autowired
    private logServer logServer;


    @RequestMapping(value = "files", method = RequestMethod.POST)
    public Result dome1(@RequestParam("file") MultipartFile file) throws Exception {
        //file对象名记得和前端name属性值一致
        //System.out.println(file.getOriginalFilename());
        try {
            Result b = FTPUtil.addFtp(file);
            if (b.getCode() == 0) {
                return Result.SUCCESS("http://81.70.180.73:8829/LOG/" + b.getData());
            } else {
                return Result.FAIL();
            }
        } catch (Exception e) {
            return Result.FAIL();
        }
    }

    @RequestMapping(value = "lists", method = RequestMethod.POST)
    public Result selectAndlist(int id, int pageNo, int pageSize, int desc) {
        IPage<log> page = new Page<>(pageNo, pageSize);

        QueryWrapper<log> wrapper = new QueryWrapper<>();
        //做条件筛选
        if (id != 1) {
            log l = new log();
            l.setUid(id);
            wrapper.setEntity(l);
        }
        if (desc == 1) {
            wrapper.orderByAsc("data");
        } else {
            wrapper.orderByDesc("data");
        }
        return Result.SUCCESS(logServer.page(page, wrapper));
    }

    @RequestMapping(value = "update_log", method = RequestMethod.POST)
    public Result update_log(@RequestParam("file") MultipartFile file,log log) {
        Calendar calendar = Calendar.getInstance();
        String yue= (calendar.get(Calendar.MONTH) + 1)<10?("0"+(calendar.get(Calendar.MONTH) + 1)):(calendar.get(Calendar.MONTH) + 1)+"";
        String date = calendar.get(Calendar.YEAR) + "-" + yue + "-" + calendar.get(Calendar.DATE);
        /*当天时间*/
        System.out.println(date);
        if (log.getData().equals(date)) {
            if (!(file.getName().equals(""))) {
                try {
                    FTPUtil.deleteFile(log.getImg());//删除之前的文件
                    Result b = FTPUtil.addFtp(file);//上传现在的文件
                    if (b.getCode() == 0) {
                        log.setImg("http://81.70.180.73:8829/LOG/" + b.getData());
                    } else {
                        return Result.FAIL();
                    }
                } catch (Exception e) {
                    return Result.FAIL();
                }
            }
            return Result.SUCCESS(logServer.updateById(log));
        }
        return Result.FAIL();
    }


    @RequestMapping(value = "log_list", method = RequestMethod.POST)
    public Result selectAndlog(int id, int power, String name, String data, int pageNo, int pageSize) {
        IPage<log> page = new Page<>(pageNo, pageSize);
        if (power == 3) {
            QueryWrapper<log> wrapper = new QueryWrapper<>();
            log l = new log();
            l.setUid(id);
            wrapper.setEntity(l);
            wrapper.orderByDesc("data");
            return Result.SUCCESS(logServer.page(page, wrapper));
        } else if (power == 2) {
            return Result.SUCCESS(logServer.getQuestionLog2(page, id, data, name));
        } else {
            return Result.SUCCESS(logServer.getQuestionLog1(page, id, data, name));
        }
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result save(log l) {
        if (logServer.save(l)) {
            return Result.SUCCESS();
        }
        return Result.FAIL();
    }

    @RequestMapping(value = "del", method = RequestMethod.POST)
    public Result del(int id) {
        if (id != 0) {
            QueryWrapper<log> Wrapper = new QueryWrapper();
            log log = new log();
            log.setLid(id);
            Wrapper.setEntity(log);
            if (logServer.remove(Wrapper)) {
                return Result.SUCCESS();
            }
        }
        return Result.FAIL();
    }
}
