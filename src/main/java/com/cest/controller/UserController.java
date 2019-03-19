package com.cest.controller;

import com.alibaba.fastjson.JSON;
import com.cest.model.User;
import com.cest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cestlavie on 2019/3/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserPage", method = RequestMethod.POST)
    public String getUserPage(){
        List<User> users = userService.selectAllList();
        return JSON.toJSONString(users);
    }
}
