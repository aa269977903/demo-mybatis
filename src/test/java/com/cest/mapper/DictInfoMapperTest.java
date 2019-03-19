package com.cest.mapper;

import com.cest.DemoMybatisApplicationTests;
import com.cest.model.DictInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by cestlavie on 2019/3/18.
 */
public class DictInfoMapperTest extends DemoMybatisApplicationTests {

    @Autowired
    private DictInfoMapper dictInfoMapper;

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
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        DictInfo dictInfos = dictInfoMapper.selectByPrimaryKey(1);
        assertEquals("2", dictInfos.getDictCode());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void selectAllByDictCode() throws Exception {
        List<DictInfo> dictInfos = dictInfoMapper.selectAllByDictCode("123");
        assertEquals("2", dictInfos.size());
    }

}