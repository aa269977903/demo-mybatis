package com.cest.service.impl;

import com.cest.annotation.DictParam;
import com.cest.annotation.TranslationDict;
import com.cest.mapper.UserMapper;
import com.cest.model.User;
import com.cest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cestlavie on 2019/3/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @TranslationDict({@DictParam(dictCode = "123",dictValueFiled = "gender",dictNameFiled = "genderName")})
    public List<User> selectAllList() {
        List<User> users = userMapper.selectAllList();
        return users;
    }
}
