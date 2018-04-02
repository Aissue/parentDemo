package com.yscredit.controller;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.yscredit.interfence.IMyInterfence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    /*@Autowired
    private IMyInterfence myInterfence;

    @RequestMapping(value = "/test.do")
    @ResponseBody
    public String getTest(){
        System.out.println("消费方开始了...");
        String str = myInterfence.helloWorld();
        return str;
    }*/

    @RequestMapping(value = "test2.do")
    @ResponseBody
    public String getTest2(){
        GenericService genericService
                = DubboCache.REFERENCECONFIGS.get("com.yscredit.interfence.IMyInterfence").get();
        Object result = null;
        if(genericService != null){
            result = genericService.$invoke("helloWorld",new String[]{},new String[]{});
        }
        return result.toString();
    }
}
