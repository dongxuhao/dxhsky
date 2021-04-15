package com.dongxh.dongxh_cipher.service;

import java.util.HashMap;
import java.util.Map;

public interface Sm4UtilsService {
    //解密
    String decryptEcb(String ciphertext);

    //加密
    String encryptEcb(String text);

    //登录
    Map<String,Object> login(HashMap<String,Object> user);
}
