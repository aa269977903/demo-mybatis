package com.cest.aspect;


import com.alibaba.fastjson.JSON;
import com.cest.annotation.DictParam;
import com.cest.annotation.TranslationDict;
import com.cest.mapper.DictInfoMapper;
import com.cest.model.DictInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.alibaba.fastjson.JSON.toJSONString;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;

/**
 * 翻译字典值的
 */

@Slf4j
@Aspect
@Component
public class TranslationDictAspect {

    @Autowired
    private DictInfoMapper dictInfoMapper;

    /**
     * 非基本类型在 CLASS 中的定义
     */
    private static final String FILED_NAME_TYPE = "TYPE";

    private Map<String,String> dictInfoMap = new ConcurrentHashMap<>();

    Pattern dictValuePattern= Pattern.compile("\\d+");

    @Around("@annotation(translationDict)")
    public Object Translation(final ProceedingJoinPoint pjp, TranslationDict translationDict) throws Throwable {
        Object result = pjp.proceed();
        // 第一步、获取返回值类型
        Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();

        //首先，取出要翻译字段的字典值
        //String returnJsonResult = JSONUtils.toJSONString(result);

        String returnJsonResult = toJSONString(result);

        DictParam[] dictParams = translationDict.value();
        for (DictParam dictParam : dictParams) {
            log.info("开始翻译字典CODE:{},取值字段：{},目标字段：{}",dictParam.dictCode(),dictParam.dictValueFiled(),dictParam.dictNameFiled());

            // 从数据库查询
            List<DictInfo> dictInfos = dictInfoMapper.selectAllByDictCode(dictParam.dictCode());

            //先把字典值转成map
            for (DictInfo dictInfo : dictInfos) {
                dictInfoMap.put(dictInfo.getDictCode()+"#"+dictInfo.getDictInfoValue(),dictInfo.getDictInfoName());
            }

            Pattern dictPattern= Pattern.compile("\"" + dictParam.dictValueFiled() +".*?,");
            Matcher dictMatcher=dictPattern.matcher(returnJsonResult);
            StringBuffer sb = new StringBuffer();
            while (dictMatcher.find()){

                //取出要翻译字段对应的值
                Matcher dictValueMatcher = dictValuePattern.matcher(dictMatcher.group());
                dictValueMatcher.find();
                //翻译字典
                String dictInfoName = dictInfoMap.get(dictParam.dictCode()+"#"+dictValueMatcher.group());

                String s = dictMatcher.group() + "\"" +  dictParam.dictNameFiled() + "\":\"" + dictInfoName + "\",";
                dictMatcher.appendReplacement(sb, s);
            }
            dictMatcher.appendTail(sb);
            returnJsonResult = sb.toString();
        }

        result = getJsonToResultObject(returnJsonResult,returnType);
        return result;
    }





    private Object getJsonToResultObject(String returnJsonResult, Class returnType) {
        // 对象复原
        if (isNoneBlank(returnJsonResult)) {
            // 基本类型则直接返回封装类型则对象转换
            if (returnType.isPrimitive()) {
                return returnJsonResult;
            } else {
                try {
                    if ((returnType.getField(FILED_NAME_TYPE)
                            .getClass()).isPrimitive()) {
                        return returnJsonResult;
                    }
                } catch (Exception e) {
                    return JSON.parseObject(returnJsonResult, returnType);
                }
            }
        }
        return null;
    }
}
