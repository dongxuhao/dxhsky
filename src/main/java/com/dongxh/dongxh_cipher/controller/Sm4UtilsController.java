package com.dongxh.dongxh_cipher.controller;

import com.alibaba.fastjson.JSON;
import com.dongxh.dongxh_cipher.service.Sm4UtilsService;
import com.dongxh.dongxh_cipher.service.impl.Sm4UtilsImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(value = "工具服务控制器", description = "工具服务控制器")
@Controller
@RequestMapping("/api")
public class Sm4UtilsController {

    @Resource
    private Sm4UtilsService mSm4UtilsService;

    @ApiOperation(value = "加密", notes = "加密")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "需加密内容", dataType = "String", paramType = "query")})
    @GetMapping("/encryptEcb/{name}")
    @ResponseBody
    //@PathVaribale 获取url路径的数据  localhost:8080/hello/id
    //对比：@RequestParam 是从request里面拿取值，而 @PathVariable 是从一个URI模板里面来填充
    //通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的 {xxx} 占位符可以通过 @PathVariable("xxx") 绑定到操作方法的入参中。
    public String encryptEcb(@PathVariable("name") String param) {
        System.out.println("调用--->Sm4UtilsController.encryptEcb");
        return mSm4UtilsService.encryptEcb(param);
    }


    @ApiOperation(value = "解密", notes = "解密")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "需解密内容", dataType = "String", paramType = "path")})
    @GetMapping("/decryptEcb")
    @ResponseBody
    //@RequestParam 获取请求参数的值  localhost:8080/hello?userId=1000
    //对比：@RequestParam 是从request里面拿取值，而 @PathVariable 是从一个URI模板里面来填充
    //defaultValue 如果本次请求没有携带这个参数，或者参数为空，那么就会启用默认值
    //name 绑定本次参数的名称，要跟URL上面的一样
    //required 这个参数是不是必须的
    //value 跟name一样的作用，是name属性的一个别名
    public String decryptEcb(@RequestParam(name = "id", required = true) String param) {
        //name代表提交参数名。required意思是这个参数是否必需，默认true，没有该参数，无法调用此方法；这里设为false，有无该参数都可以调用。defaultValue如果该参数值为空，那么就使用默认值。
        System.out.println("调用--->Sm4UtilsController.decryptEcb");
        return mSm4UtilsService.decryptEcb(param);
    }

    @ApiOperation(value = "登录", notes = "解密")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", value = "账号密码", dataType = "String", paramType = "path")})
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody(required = true) HashMap<String, Object> param) {
        System.out.println("调用--->Sm4UtilsController.login");
        return JSON.toJSONString(mSm4UtilsService.login(param));
    }

}
