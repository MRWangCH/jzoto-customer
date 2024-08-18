package com.jzo2o.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jzo2o.customer.model.domain.ServeProvider;
import com.jzo2o.customer.model.dto.request.InstitutionRegisterReqDTO;
import com.jzo2o.customer.model.dto.request.InstitutionResetPasswordReqDTO;

/**
 * @author wangchuan
 */
public interface IRegisterService extends IService<ServeProvider> {
    /**
     * 机构注册方法
     *
     * @param registerDto
     */
    ServeProvider register(InstitutionRegisterReqDTO registerDto) throws Exception;

    /**
     * 忘记密码
     *
     * @param passwordReqDTO
     */
    ServeProvider resetPwd(InstitutionResetPasswordReqDTO passwordReqDTO);
}
