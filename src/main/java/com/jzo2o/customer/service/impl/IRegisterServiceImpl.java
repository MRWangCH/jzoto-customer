package com.jzo2o.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jzo2o.common.constants.UserType;
import com.jzo2o.common.expcetions.BadRequestException;
import com.jzo2o.customer.mapper.ServeProviderMapper;
import com.jzo2o.customer.model.domain.ServeProvider;
import com.jzo2o.customer.model.dto.request.InstitutionRegisterReqDTO;
import com.jzo2o.customer.service.IRegisterService;
import com.jzo2o.customer.service.IServeProviderSettingsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: wangchuan
 * @Desc:
 * @create: 2024-08-18 14:22
 **/

@Service
public class IRegisterServiceImpl extends ServiceImpl<ServeProviderMapper, ServeProvider> implements IRegisterService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private IServeProviderSettingsService serveProviderSettingsService;

    /**
     * 机构注册方法
     *
     * @param registerDto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServeProvider register(InstitutionRegisterReqDTO registerDto) throws Exception {
        // 校验手机号是否存在
        ServeProvider existServeProvider = lambdaQuery().eq(ServeProvider::getPhone, registerDto.getPhone())
                .one();
        if (existServeProvider != null) {
            if (existServeProvider.getType().equals(UserType.WORKER)) {
                throw new BadRequestException("该账号已被服务人员注册");
            } else {
                throw new BadRequestException("该账号已被机构注册");
            }
        }
        ServeProvider register = new ServeProvider();
        register.setPhone(registerDto.getPhone());
        String pwd = passwordEncoder.encode(registerDto.getPassword());
        register.setPassword(pwd);
        register.setType(3);
        register.setStatus(0);
        baseMapper.insert(register);
        serveProviderSettingsService.add(register.getId(), register.getType());
        return register;
    }
}
