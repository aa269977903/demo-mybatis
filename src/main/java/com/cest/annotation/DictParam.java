package com.cest.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 需要翻译的字典值
 *
 * */

@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface DictParam {

    /**
     * 字典CODE
     * @return
     */
    String dictCode() default "";

    /**
     * 需要翻译的字段名
     * @return
     */
    String dictValueFiled() default "";


    /**
     * 被翻译的字段名
     * @return
     */
    String dictNameFiled() default "";

}
