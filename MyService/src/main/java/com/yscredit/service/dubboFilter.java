package com.yscredit.service;

import com.alibaba.dubbo.rpc.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class dubboFilter implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("dubboFilter is running...");
        Result res = null;
        res = invoker.invoke(invocation);

        Object object[] = invocation.getArguments();
        Map<String, String> map = invocation.getAttachments();
        System.out.println(object.length);
        System.out.println(map.size());
        Set<String> set = map.keySet();
        for(String str : set){
            System.out.println(str+":"+map.get(str));
        }
        return res;
    }
}
