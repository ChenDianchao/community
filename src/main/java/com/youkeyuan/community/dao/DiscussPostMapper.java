package com.youkeyuan.community.dao;

import com.youkeyuan.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //userId对应用户编号，应对个人主页时显示用户发布的帖子。为0时则不考虑该值
    //offset为每页起始行数，limit为每页显示多少条数据
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //param用于给参数取别名
    //如果只有一个参数，并且在<if>中，则必须使用别名
    int selectDiscussPostRows(@Param("userId") int userId);


}
