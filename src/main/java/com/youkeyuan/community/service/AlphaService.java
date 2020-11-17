package com.youkeyuan.community.service;

import com.youkeyuan.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service//容器管理业务组件
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public String testAlphaDao(){
        return alphaDao.select();
    }

    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct//构造器之后调用
    public void init(){
        System.out.println("初始化AlphaService");
    }


    @PreDestroy //销毁之前调用该方法
    public void destory(){
        System.out.println("销毁AlphaService");
    }
}
