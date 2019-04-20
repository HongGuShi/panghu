package com.panghu.common.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 通用多语言缓存服务
 */
@Component
@Slf4j
public class CommonLanguageCacheService {

    private Cache<String, HashMap> metaLanguageCache = CacheBuilder.newBuilder().expireAfterWrite(12, TimeUnit.HOURS).build();

    private String path = "data/";

    /**
     * 根据语言从对应文件中读取错误信息
     *
     * @param language 语言
     * @return
     */
    public HashMap getErrorInfoByLanguage(String language) {
        try {
            return metaLanguageCache.get(language, new Callable<HashMap>() {
                @Override
                public HashMap call() throws Exception {
                    //文件路径
                    String filePath;
                    //根据语言选择不同语言环境的json响应信息配置
                    switch (language) {
                        case "zh-cn":
                            filePath = path.concat("ErrorMessage.json");
                            break;
                        case "zh-hk":
                            filePath = path.concat("ErrorMessageHK.json");
                            break;
                        case "en-us":
                            filePath = path.concat("ErrorMessageEN.json");
                            break;
                        case "vn":
                            filePath = path.concat("ErrorMessageYL.json");
                            break;
                        case "jp":
                            filePath = path.concat("ErrorMessageJP.json");
                            break;
                        default:
                            filePath = path.concat("ErrorMessage.json");
                            break;
                    }
                    return readData(filePath);
                }
            });
        } catch (Exception e) {
        }
        return null;
    }

    private HashMap readData(String path) {
        HashMap result = Maps.newHashMap();
        try {
            //判断路径是否为空
            if (Objects.nonNull(path)) {
                //字符缓冲流
                StringBuffer buffer = new StringBuffer();
                //读取路径下的配置
                InputStream resourceAsStream = CommonLanguageCacheService.class.getClassLoader().getResourceAsStream(path);
                //使用UTF-8编码
                InputStreamReader isr = new InputStreamReader(resourceAsStream, "UTF-8");
                //将流用字符串缓冲流包装
                BufferedReader in = new BufferedReader(isr);
                String line;
                while ((line = in.readLine()) != null) {
                    buffer.append(line);
                }
                String text = buffer.toString();
                result = JSON.parseObject(text, HashMap.class);
            }
        } catch (Exception var8) {
            log.error(var8.getMessage(), var8);
        }
        return result;
    }
}
