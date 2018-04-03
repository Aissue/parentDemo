package com.yscredit.controller;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.yscredit.interfence.IMyInterfence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
            Map<String,String> map = new HashMap<String,String>();
            map.put("name","aissue");
            map.put("age","27");
            result = genericService.$invoke("helloWorld",new String[]{},new Object[]{});
//            result = genericService.$invoke("helloWorld",new String[]{"com.yscredit.controller.UserVo"},new Object[]{map});
        }
        return result.toString();
    }
}
