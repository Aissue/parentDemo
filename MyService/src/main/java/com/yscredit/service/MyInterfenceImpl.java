package com.yscredit.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yscredit.interfence.IMyInterfence;
import com.yscredit.interfence.UserVo;

@Service
public class MyInterfenceImpl implements IMyInterfence {
    public String helloWorld() {
        return "hello dubbo!";
    }

    public String testParams(String param) {
        return "==params:"+param+"==";
    }

    public String testpojo(UserVo vo) {
        if(vo != null){
            return vo.getName();
        }
        return "nothing";
    }
}
