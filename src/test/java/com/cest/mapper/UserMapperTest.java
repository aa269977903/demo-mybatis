package com.cest.mapper;

import com.cest.DemoMybatisApplicationTests;
import com.cest.model.User;
import com.cest.util.TempIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by cestlavie on 2019/3/8.
 */

public class UserMapperTest extends DemoMybatisApplicationTests{

    private static Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        IntStream.iterate(0,n -> {
            User build = User.builder().age((int) (Math.random() * 100) + 1)
                    .id(TempIDUtils.createId())
                    .password("123456")
                    .userName("xiaohua" + Math.random() * 10000)
                    .build();
            int insert = userMapper.insert(build);
            return n;
        }).limit(600).forEach(System.out::println);

    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        User user = userMapper.selectByPrimaryKey(1);
        assertEquals("0", user.getId());
    }

    @Test
    public void selectAllList() throws Exception {
        //分页查询
        PageHelper.startPage(10,10);
        List<User> users = userMapper.selectAllList();
        PageInfo<User> userInfo = new PageInfo<>(users);
        int total = (int)userInfo.getTotal();
        assertEquals("0", users.get(0).getId());
    }


    @Test
    public void updateBatchForeach() throws Exception {
        List<User> users = userMapper.selectAllList();
        IntStream.iterate(0,n -> {
            users.get(n).setPassword((int)(Math.random() * 1000)+"");
            n ++;
            return n;
        }).limit(users.size()).forEach(System.out::print);
        long startTime = System.currentTimeMillis();
        logger.info("-------------------开始批量更新foreach------------------------");
        int updateUsers = userMapper.updateBatchForeach(users);
        long endTime = System.currentTimeMillis();
        logger.info("foreach共 {} 条数据,共花费时间 {}" ,updateUsers, (endTime-startTime));


    }

    @Test
    public void updateBatchCaseWhen() throws Exception {
        List<User> users = userMapper.selectAllList();
        IntStream.iterate(0,n -> {
            users.get(n).setPassword((int)(Math.random() * 100)+"");
            n ++;
            return n;
        }).limit(users.size()).forEach(System.out::print);
        long startTime = System.currentTimeMillis();
        logger.info("-------------------开始批量更新case-when------------------------");
        int updateUsers = userMapper.updateBatchCaseWhen(users);
        long endTime = System.currentTimeMillis();
        logger.info("case-when共 {} 条数据,共花费时间 {}" ,updateUsers, (endTime-startTime));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}