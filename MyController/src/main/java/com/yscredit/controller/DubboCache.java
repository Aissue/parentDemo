package com.yscredit.controller;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DubboCache {
    private static final DubboCache dubboCache = new DubboCache();
    private DubboCache(){}

    //注册中心的缓存
    public static final ConcurrentMap<String,ApplicationConfig> APPLICATIONCONFIGS = new ConcurrentHashMap<String, ApplicationConfig>();
    //接口缓存
    public static final ConcurrentMap<String,ReferenceConfig<GenericService>>  REFERENCECONFIGS = new ConcurrentHashMap<String, ReferenceConfig<GenericService>>();

    /**
     *  新增接口
     * @param key
     * @param referenceConfig
     */
    public static void addReference(String key,
                                    ReferenceConfig<GenericService> referenceConfig){
        REFERENCECONFIGS.putIfAbsent(key,referenceConfig);
    }

    /**
     * 新增注册应用
     * @param key
     * @param applicationConfig
     */
    public static void addApplication(String key,ApplicationConfig applicationConfig){
        APPLICATIONCONFIGS.putIfAbsent(key,applicationConfig);
    }
}
