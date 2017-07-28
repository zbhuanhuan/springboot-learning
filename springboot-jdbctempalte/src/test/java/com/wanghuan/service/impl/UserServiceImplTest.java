package com.wanghuan.service.impl;

import com.wanghuan.SpringbootJdbctempalteApplication;
import com.wanghuan.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by 54416 on 2017/7/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringbootJdbctempalteApplication.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Before
    public void serUp(){
        userService.deleteAllUsers();
    }
    @Test
    public void create() throws Exception {
    // 插入5个用户
        userService.create("a",1);
        userService.create("a",2);
        userService.create("a",3);
        userService.create("a",4);
        userService.create("a",5);

    // 查数据库，应该有5个用户
		Assert.assertEquals(5, userService.getAllUsers().intValue());
    // 删除两个用户
		userService.deleteByName("a");
		userService.deleteByName("e");
    // 查数据库，应该有5个用户
		Assert.assertEquals(3, userService.getAllUsers().intValue());
}

    @Test
    public void deleteByName() throws Exception {
    }

    @Test
    public void getAllUsers() throws Exception {
    }

    @Test
    public void deleteAllUsers() throws Exception {
    }

}