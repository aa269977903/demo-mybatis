package com.cest.mapper;

import com.cest.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAllList();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * update批量更新
     * @param list
     * @return
     */
    int updateBatchForeach(@Param("list") List<User> list);

    /**
     * casewhen批量更新
     * @param list
     * @return
     */
    int updateBatchCaseWhen(@Param("list") List<User> list);

}