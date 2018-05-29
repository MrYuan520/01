/**************************************************************************/
/*                                                                        */
/* Copyright (c) 2017 CCPG Company                                        */
/* 长城物业集团股份有限公司版权所有                                         */
/*                                                                        */
/* PROPRIETARY RIGHTS of CCPG Company are involved in the                 */
/* subject matter of this material. All manufacturing, reproduction, use, */
/* and sales rights pertaining to this subject matter are governed by the */
/* license agreement. The recipient of this software implicitly accepts   */
/* the terms of the license.                                              */
/* 本软件文档资料是长城物业集团股份有限公司的资产，任何人士阅读和             */
/* 使用本资料必须获得相应的书面授权，承担保密责任和接受相应的法律约束。       */
/*                                                                        */
/**************************************************************************/

/**
 * 一句话的功能说明描述
 *
 * @author ：Joy
 * @createTime ：2017-10-24
 */

package com.einwin.devops.provider.controller;

import com.einwin.devops.api.bo.UserAuthBO;
import com.einwin.devops.api.model.Module;
import com.einwin.devops.api.service.UserAuthRemoteService;
import com.einwin.devops.provider.service.ModuleService;
import com.einwin.devops.provider.service.UserAuthService;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.model.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
//@RequestMapping(value = "/devops/userAuth")
public class UserAuthController implements UserAuthRemoteService {
    private static final Logger logger = LoggerFactory.getLogger(ModuleController.class);
    
    @Autowired
    private UserAuthService userAuthService;
    @Autowired
    private ModuleService moduleService;

    @Override
    public ResponseData<List<Module>> getAuthModule(@RequestBody UserAuthBO query) {
        try {
            List<Module> list = this.userAuthService.getAuthModule(query.getVo().getUserId());
            return new ResponseData<List<Module>>(ResponseCode.SUCCESS, list);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_EXCEPTION.getMessage(), ex);
            return new ResponseData<List<Module>>(ResponseCode.SELECT_ONE_EXCEPTION, null);
        }
    }

    @Override
    public ResponseData save(@RequestBody Module module) {
        try {
            this.userAuthService.save(module);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.UPDATE_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.UPDATE_EXCEPTION);
        }
    }

    @Override
    public ResponseData<List<Module>> getMenu(@RequestBody UserAuthBO query) {
        try {
            List<Module> allList = this.userAuthService.getAuthModule(query.getVo().getUserId());
            return new ResponseData<List<Module>>(ResponseCode.SUCCESS, allList);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_EXCEPTION.getMessage(), ex);
            return new ResponseData<List<Module>>(ResponseCode.SELECT_EXCEPTION, null);
        }
    }
}