package com.jzo2o.customer.controller.agency;


import com.jzo2o.common.model.Result;
import com.jzo2o.customer.model.dto.request.InstitutionResetPasswordReqDTO;
import com.jzo2o.customer.model.dto.response.ServeProviderInfoResDTO;
import com.jzo2o.customer.service.IRegisterService;
import com.jzo2o.customer.service.IServeProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 服务人员/机构表 前端控制器
 * </p>
 *
 * @author itcast
 * @since 2023-07-17
 */
@RestController("agencyServeProviderController")
@RequestMapping("/agency/serve-provider")
@Api(tags = "机构端 - 服务人员或机构相关接口")
public class ServeProviderController {
    @Resource
    private IServeProviderService serveProviderService;

    @Resource
    private IRegisterService registerService;

    @GetMapping("/currentUserInfo")
    @ApiOperation("获取当前用户信息")
    public ServeProviderInfoResDTO currentUserInfo() {
        return serveProviderService.currentUserInfo();
    }

    @ApiOperation("修改密码")
    @PostMapping("/institution/resetPassword")
    public Result resetPassword(@RequestBody InstitutionResetPasswordReqDTO passwordReqDTO) {
        Result<Object> result = new Result<>();
        registerService.resetPwd(passwordReqDTO);
        result.setCode(200);
        result.setMsg("修改成功");
        return Result.ok(result);
    }
}
