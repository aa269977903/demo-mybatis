package com.cest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cestlavie on 2019/3/18.
 */
@Configuration
@Slf4j
@ConditionalOnClass
public class CacheAutoConfiguration {

    public CacheAutoConfiguration() {
        log.info("cache 初始化");
    }

    //@Bean
    //public TranslationDictAspect translationDictAspect(){
    //    log.info("初始化 TranslationDict 字典值翻译缓存拦截");
    //    return new TranslationDictAspect();
    //}
}
