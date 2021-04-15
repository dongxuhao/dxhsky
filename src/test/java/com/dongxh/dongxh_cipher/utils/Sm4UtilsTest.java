package com.dongxh.dongxh_cipher.utils;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Sm4UtilsTest {
    @Autowired
    private Sm4Utils mSm4Utils;

    @Test
    public void testEcb(){
        System.out.println(mSm4Utils.decryptEcb("fd75655e434660c02a72fa552b49e85b"));
        System.out.println(mSm4Utils.encryptEcb("234567"));
    }

}
