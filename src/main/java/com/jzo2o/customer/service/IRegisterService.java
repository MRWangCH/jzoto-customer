package com.jzo2o.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jzo2o.customer.model.domain.ServeProvider;
import com.jzo2o.customer.model.dto.request.InstitutionRegisterReqDTO;

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
}
