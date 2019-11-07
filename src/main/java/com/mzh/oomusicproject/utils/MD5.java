package com.mzh.oomusicproject.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5 {
    public static final void main(String[] args){
// do something
        String md5Pwd = new SimpleHash("MD5", "bbb",
                ByteSource.Util.bytes("bbb" + "salt"), 2).toHex();
        System.out.println(md5Pwd);
    }

    public static String MD5Util(String username,String password){
        String md5Pwd = new SimpleHash("MD5", password,
                ByteSource.Util.bytes(username + "salt"), 2).toHex();
        return md5Pwd;
    }
}
