package com.cest.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 翻译字典值注解
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface TranslationDict {

    DictParam[] value();
}
