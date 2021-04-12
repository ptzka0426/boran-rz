package com.boranrz.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boranrz.Entity.log;
import com.boranrz.Entity.user;
import com.boranrz.Vo.QuestionLogVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author LT
 * @create 2021-01-12 10:06
 */
@Mapper
public interface logMapper extends BaseMapper<log> {
    public List<log> list_log(int id);
    @Select("select l.lid,l.name,l.content,l.data from `log` l INNER JOIN `user` u on l.uid=u.id where did in(\n" +
            "select u.did from `user` u  INNER JOIN `department` d ON d.did = u.did INNER JOIN `corporation` c ON c.cid = d.cid  WHERE l.data like CONCAT('%',#{data},'%') AND l.name like CONCAT('%',#{name},'%') AND u.id=#{id}\n" +
            ")\n")
    List<log> getQuestionLog2(IPage page, int id,String data,String name);

    @Select("select l.lid,l.name,l.content,l.data from `log` l INNER JOIN `user` u on l.uid=u.id INNER JOIN `department` d ON d.did = u.did INNER JOIN `corporation` c ON c.cid = d.cid where c.cid in(\n" +
            "select c.cid from `user` u  INNER JOIN `department` d ON d.did = u.did INNER JOIN `corporation` c ON c.cid = d.cid  WHERE l.data like CONCAT('%',#{data},'%') AND l.name like CONCAT('%',#{name},'%') AND u.id=#{id})\n")
    List<log> getQuestionLog1(IPage page, int id,String data,String name);

}
