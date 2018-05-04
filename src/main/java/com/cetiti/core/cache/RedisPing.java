package com.cetiti.core.cache;

import redis.clients.jedis.Jedis;

public class RedisPing
{
    /**
     * ping 不通检查服务器防火墙是否关闭：service iptables stop
     *
     * */
    public static void main(String[] args)
    {
        Jedis jedis = new Jedis("192.168.138.130", 6379);
        jedis.auth("123.com");
        System.out.println("OK");
        System.out.println("running: " + jedis.ping());
    }
}
