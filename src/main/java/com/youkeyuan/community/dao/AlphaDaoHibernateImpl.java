package com.youkeyuan.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alpha1")  //装配到容器
public class AlphaDaoHibernateImpl implements AlphaDao{

    @Override
    public String select() {
        return "Hibernate";
    }
}
