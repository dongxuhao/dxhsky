package com.dongxh.dongxh_cipher.service.impl;

import com.dongxh.dongxh_cipher.mapper.Sm4UtilsMapper;
import com.dongxh.dongxh_cipher.service.Sm4UtilsService;
import com.dongxh.dongxh_cipher.utils.Sm4Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Service
public class Sm4UtilsImpl implements Sm4UtilsService {

    @Resource
    private Sm4UtilsMapper mSm4UtilsMapper;

    @Override
    public String decryptEcb(String ciphertext) {
        //解密
        return Sm4Utils.decryptEcb(ciphertext);
    }

    @Override
    public String encryptEcb(String text) {
        //加密
        return Sm4Utils.encryptEcb(text);
    }

    @Override
    public Map<String, Object> login(HashMap<String, Object> user) {
        //用户登录密码验证
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        String realPassWorld = mSm4UtilsMapper.findPassWord(user);
        if (realPassWorld == null) {
            resultMap.put("state", "000");
            resultMap.put("des", "未查询到该账户");
        } else if (user.get("password").equals(realPassWorld)) {
            resultMap.put("state", "100");
            resultMap.put("des", "成功");
        } else {
            resultMap.put("state", "001");
            resultMap.put("des", "密码错误");
        }
        return resultMap;
    }
}
