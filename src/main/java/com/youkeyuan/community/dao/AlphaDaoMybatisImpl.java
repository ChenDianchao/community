package com.youkeyuan.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("alpha2")//配置接口名
@Primary //优先装配
public class AlphaDaoMybatisImpl implements AlphaDao{
    @Override
    public String select(){
        return "mybatis";
    }
}
