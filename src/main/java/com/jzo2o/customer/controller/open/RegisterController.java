package com.jzo2o.customer.controller.open;

import com.jzo2o.common.model.Result;
import com.jzo2o.customer.model.dto.request.InstitutionRegisterReqDTO;
import com.jzo2o.customer.service.IRegisterService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wangchuan
 * @Desc:
 * @create: 2024-08-18 14:05
 **/

@RestController("openrRegisterController")
@RequestMapping("/open/serve-provider")
@Api(tags = "机构注册接口 - 机构注册相关接口")
public class RegisterController {

    @Resource
    private IRegisterService registerService;

    @PostMapping("/institution/register")
    public Result register(@RequestBody InstitutionRegisterReqDTO registerDto) {
        Result<Object> result = new Result<>();
        try {
            registerService.register(registerDto);
            result.setCode(200);
            result.setMsg("注册成功");
            return Result.ok(result);
        } catch (Exception e) {
            return Result.error("注册失败");
        }
    }
}
