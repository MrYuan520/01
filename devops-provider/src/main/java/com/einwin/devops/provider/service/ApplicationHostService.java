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
 * @createTime ：2018-4-25
 */

package com.einwin.devops.provider.service;

import com.einwin.devops.api.model.ApplicationHost;
import com.einwin.devops.provider.mapper.ApplicationHostMapper;
import com.einwin.framework.exception.ApplicationException;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * 业务类
 * </pre>
 */
@Service("applicationHostService")
public class ApplicationHostService extends GenericService<ApplicationHost, Long> {
    public ApplicationHostService(@Autowired ApplicationHostMapper applicationHostMapper) {
        super(applicationHostMapper);
    }
    
    public ApplicationHostMapper getMapper() {
        return (ApplicationHostMapper) super.genericMapper;
    }

    public int disabledByAppId(Long appId) {
        try {
            return this.getMapper().disabledByAppId(appId);
        } catch (Exception ex) {
            logger.error(ResponseCode.UPDATE_EXCEPTION.getMessage(), ex);
            throw new ApplicationException(ResponseCode.UPDATE_EXCEPTION);
        }
    }

    public int deleteByAppId(Long appId) {
        try {
            return this.getMapper().deleteByAppId(appId);
        } catch (Exception ex) {
            logger.error(ResponseCode.DELETE_EXCEPTION.getMessage(), ex);
            throw new ApplicationException(ResponseCode.DELETE_EXCEPTION);
        }
    }

    public List<ApplicationHost> getByAppId(Long appId) {
        try {
            return this.getMapper().getByAppId(appId);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_EXCEPTION.getMessage(), ex);
            throw new ApplicationException(ResponseCode.SELECT_EXCEPTION);
        }
    }
}