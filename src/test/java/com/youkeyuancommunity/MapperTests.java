package com.youkeyuancommunity;

import com.youkeyuan.community.CommunityApplication;
import com.youkeyuan.community.dao.DiscussPostMapper;
import com.youkeyuan.community.dao.UserMapper;
import com.youkeyuan.community.entity.DiscussPost;
import com.youkeyuan.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test1");
        user.setPassword("123456");
        user.setSalt("aaa");
        user.setEmail("test1@qq.com");
        user.setHeaderUrl("http://www.yky.com/100.png");
        user.setCreateTime(new Date());

        //∑µªÿ–Ú∫≈÷µ
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser(){
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150,"http://www.yky.com/110.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150,"hello");
        System.out.println(rows);
    }

    @Autowired
    private DiscussPostMapper discussPostMapper;

   @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post : list){
             System.out.println(post);
         }

         int rows = discussPostMapper.selectDiscussPostRows(149);
         System.out.println(rows);
    }
}
