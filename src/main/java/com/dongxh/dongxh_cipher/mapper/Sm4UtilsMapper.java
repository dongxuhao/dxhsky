package com.dongxh.dongxh_cipher.mapper;

import org.mapstruct.Mapper;

import java.util.Map;

@Mapper
public interface Sm4UtilsMapper {


    /**
     * 根据账号查询密码
     *
     * @param paramMap 参数
     * @return Map<String, Object>
     */
    String findPassWord(Map<String, Object> paramMap);

}
