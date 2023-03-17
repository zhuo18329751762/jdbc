package com.zhuoyang.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name="张三";//占几个字节编码后就有几个%
        // 1 URL编码
        String encode = URLEncoder.encode(name, "utf-8");
        System.out.println(encode);
        // 2 URL解码
        //String decode = URLDecoder.decode(encode, "utf-8");
        String decode = URLDecoder.decode(encode, "ISO-8859-1");

        // 3 转换为字节数据,编码
        byte[] bytes = decode.getBytes("ISO-8859-1");
        for (byte b : bytes) {
            System.out.println(b+" ");
        }
        // 4 将字节数据转换为字符串，解码
        String s = new String(bytes, "utf-8");
        System.out.println(s);
    }
}
