package me.arganzheng.project.reading;

import java.net.InetSocketAddress;

public class QuickTest {

    public static void main(String[] args) {
        InetSocketAddress addrHostName = new InetSocketAddress("baidu.com", 80);
        System.out.println(addrHostName.getAddress().getHostAddress());

        InetSocketAddress addrIP = new InetSocketAddress("123.125.114.144", 80);
        System.out.println(addrIP.getAddress().getHostAddress());

        System.out.println(addrIP);
    }
}
