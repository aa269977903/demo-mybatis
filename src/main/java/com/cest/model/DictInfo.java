package com.cest.model;


import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class DictInfo {
    /**
     * 主键
     */
    private Integer keyId;


    /**
     * 字典类别编号
     */
    private String dictCode;

    /**
     * 字典值编码
     */
    private String dictInfoName;

    /**
     * 字典值名称
     */
    private String dictInfoValue;

    /**
     * 描述
     */
    private String dictInfoDesc;
}