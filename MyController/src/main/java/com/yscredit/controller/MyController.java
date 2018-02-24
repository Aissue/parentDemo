package com.yscredit.controller;

import com.yscredit.interfence.IMyInterfence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    private IMyInterfence myInterfence;

    @RequestMapping(value = "/test.do")
    public void getTest(){
        System.out.println("消费方开始了...");
        String str = myInterfence.helloWorld();
        System.out.println(str);
    }
}
