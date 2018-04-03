package com.yscredit.controller;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.yscredit.interfence.IMyInterfence;
import com.yscredit.interfence.UserVo;
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

    @RequestMapping(value = "test3.do")
    @ResponseBody
    public String getTest3(){
        GenericService genericService
                = DubboCache.REFERENCECONFIGS.get("com.yscredit.interfence.IMyInterfence").get();
        Object result = null;
        if(genericService != null){
            UserVo vo = new UserVo();
            vo.setAge("28");
            vo.setName("aissue");

            /* 第一个参数是调用的方法名称，第二个参数是参数类型数组，第三个参数是真正的参数 */
//            result = genericService.$invoke("testParams",new String[]{ "java.lang.String" },new Object[]{ "aissue" });
            result = genericService.$invoke("testpojo",new String[]{ "com.yscredit.interfence.UserVo" },new Object[]{ vo });
        }
        return result.toString();
    }
}
