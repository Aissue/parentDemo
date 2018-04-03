package com.yscredit.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yscredit.interfence.IMyInterfence;

@Service
public class MyInterfenceImpl implements IMyInterfence {
    public String helloWorld() {
        return "hello dubbo!";
    }
}
