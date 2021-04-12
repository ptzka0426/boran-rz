package com.boranrz.Controller;

import com.boranrz.Entity.recruitment;
import com.boranrz.Server.recruitmentServer;
import com.boranrz.Util.FTPUtil;
import com.boranrz.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author LT
 * @create 2021-01-25 10:53
 */
@RestController
public class recruitmentController {
    @Autowired
    private recruitmentServer recruitmentServer;

    @RequestMapping(value = "recruitment_add",method = RequestMethod.POST)
    public Result add(@RequestParam("file") MultipartFile file, recruitment recruitment){

            if (!(file.getName().equals(""))) {
                try {
                   //FTPUtil.deleteFile(recruitment.getFile());//删除之前的文件
                    Result b = FTPUtil.addFtp(file);//上传现在的文件
                    if (b.getCode() == 0) {
                        recruitment.setFile("http://81.70.180.73:8829/LOG/" + b.getData());
                    } else {
                        return Result.FAIL();
                    }
                } catch (Exception e) {
                    return Result.FAIL();
                }
                return Result.SUCCESS(recruitmentServer.save(recruitment));
            }
        return null;
    }
}
