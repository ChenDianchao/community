package com.youkeyuan.community.controller;

import com.youkeyuan.community.entity.DiscussPost;
import com.youkeyuan.community.entity.Page;
import com.youkeyuan.community.entity.User;
import com.youkeyuan.community.service.DiscussPostService;
import com.youkeyuan.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    //方法被调用之前，spring MVC会自动实例化Model和Page，并将Page注入Model中
    //因此不需注入model.addAttribute("page",page);即可直接访问page中的数据
    public String getIndexPage(Model model, Page page){

        //设置总行数,路径
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();

        if (list != null){
            for (DiscussPost post: list){
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }

        //前面一个为名字
        model.addAttribute("discussPosts",discussPosts);
        model.addAttribute("page",page);
        return "/index";
    }
}
