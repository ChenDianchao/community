package com.youkeyuancommunity;

import com.youkeyuan.community.CommunityApplication;
import com.youkeyuan.community.controller.HomeController;
import com.youkeyuan.community.dao.AlphaDao;
import com.youkeyuan.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext){
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);

		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		alphaDao = applicationContext.getBean("alpha1",AlphaDao.class);
		System.out.println(alphaDao.select());
	}

	@Test
	public void testBeanManage(){

		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Autowired //将容器中AlphaDao类型的变量自动注入到alphaDao
	@Qualifier("alpha1") //按照名字注入变量
	private AlphaDao alphaDao;

	@Test
	public void testDI(){

		System.out.println(alphaDao.select());
	}

}
