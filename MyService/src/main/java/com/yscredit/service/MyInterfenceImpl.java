package com.yscredit.service;

import com.yscredit.interfence.IMyInterfence;

public class MyInterfenceImpl implements IMyInterfence {
    public String helloWorld() {
        return "hello dubbo!";
    }
}
