package com.cest.mapper;

import com.cest.model.DictInfo;

import java.util.List;

public interface DictInfoMapper {
    int deleteByPrimaryKey(Integer keyid);

    int insert(DictInfo record);

    int insertSelective(DictInfo record);

    DictInfo selectByPrimaryKey(Integer keyid);

    int updateByPrimaryKeySelective(DictInfo record);

    int updateByPrimaryKey(DictInfo record);

    List<DictInfo> selectAllByDictCode(String dictCode);
}