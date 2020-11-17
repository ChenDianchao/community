package com.youkeyuan.community.dao;

import com.youkeyuan.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //动态sql，别人帖子时userId=0，查看我的贴子时userId=1；起始行号；每页限制帖子数量

    int selectDiscussPostRows(@Param("userId") int userId);

    //查询帖子的行数；@Param给参数其别名
    //如果只有一个参数，并且在<IF>里使用，必须加别名


}
