package com.yscredit.service;

import com.alibaba.dubbo.rpc.*;

public class dubboFilter implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("dubboFilter is running...");
        Result res = null;
        res = invoker.invoke(invocation);
        return res;
    }
}
