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

package com.einwin.devops.provider.service;

import com.einwin.devops.api.model.Module;
import com.einwin.devops.provider.mapper.ModuleMapper;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 业务类
 * </pre>
 */
@Service("moduleService")
public class ModuleService extends GenericService<Module, Long> {
    public ModuleService(@Autowired ModuleMapper moduleMapper) {
        super(moduleMapper);
    }
    
    public ModuleMapper getMapper() {
        return (ModuleMapper) super.genericMapper;
    }

    public List<Module> getAll() {
        Object result = null;
        try {
            result = this.getMapper().getAll();
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_EXCEPTION.getMessage(), ex);
        }

        if(result == null) {
            result = new ArrayList();
        }

        return (List)result;
    }
}