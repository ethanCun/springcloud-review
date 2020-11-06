package com.ethan.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

//自定义Ribbon负载均衡算法，继承于AbstractLoadBalancerRule, 参考RandomRule的写法
public class MyRandomRule extends AbstractLoadBalancerRule {

    private int total = 0; //总共被调用的此时
    private int currentIndex = 0; //当前被调用的服务下标

    //自定义的Ribbon轮询算法，每台服务器请求5次，然后换下一台服务器请求
    public Server choose(ILoadBalancer lb, Object key) {

        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            //所有活着可用的服务
            List<Server> upList = lb.getReachableServers();
            //所有服务
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            if (total < 4){

                server = upList.get(currentIndex);
                total++;

            }else {

                total = 0;
                currentIndex++;

                if (currentIndex >= upList.size()){
                    currentIndex = 0;
                }

                //获取该服务
                server = upList.get(currentIndex);
            }

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
