package com.cest.service.impl;

import com.cest.DemoMybatisApplicationTests;
import com.cest.model.User;
import com.cest.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cestlavie on 2019/3/18.
 */
public class UserServiceImplTest extends DemoMybatisApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void selectAllList() throws Exception {
        List<User> users = userService.selectAllList();
        System.out.println("111");
    }

}