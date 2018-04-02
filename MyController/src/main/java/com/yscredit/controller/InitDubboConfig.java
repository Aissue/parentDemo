package com.yscredit.controller;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.InitializingBean;

public class InitDubboConfig implements InitializingBean{

    private static final String applicationName="OpenApi";

    public void afterPropertiesSet() throws Exception {

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://10.1.1.147:2181");
        registryConfig.setCheck(false);
        applicationConfig.setRegistry(registryConfig);

        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setGeneric(true);
        //reference.setVersion("2.2");
        reference.setTimeout(3000);
        reference.setApplication(applicationConfig);
        reference.setInterface("com.yscredit.interfence.IMyInterfence");

        DubboCache.addReference(reference.getInterface(),reference);

    }
}
