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
import com.einwin.devops.api.model.UserAuth;
import com.einwin.devops.provider.mapper.UserAuthMapper;
import com.einwin.framework.exception.ApplicationException;
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
@Service("userAuthService")
public class UserAuthService extends GenericService<UserAuth, Long> {
    public UserAuthService(@Autowired UserAuthMapper userAuthMapper) {
        super(userAuthMapper);
    }
    
    public UserAuthMapper getMapper() {
        return (UserAuthMapper) super.genericMapper;
    }

    public List<Module> getAuthModule(String userId) {
        Object result = null;
        try {
            result = this.getMapper().getAuthModule(userId);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_EXCEPTION.getMessage(), ex);
        }

        if(result == null) {
            result = new ArrayList();
        }

        return (List)result;
    }

    public int deleteUserAuthByUserId(String userId) {
        try {
            return this.getMapper().deleteUserAuthByUserId(userId);
        } catch (Exception ex) {
            logger.error(ResponseCode.DELETE_EXCEPTION.getMessage(), ex);
            throw new ApplicationException(ResponseCode.DELETE_EXCEPTION);
        }
    }

    public int save(Module module) {
        int result = 0;
        if (module != null) {
            try {
                this.deleteUserAuthByUserId(module.getUserId());

                List<UserAuth> userAuthList = module.getUserAuthList();
                List<UserAuth> insertList = new ArrayList<UserAuth>();
                for (UserAuth userAuth : userAuthList) {
                    UserAuth insert = new UserAuth();
                    insert.setUserId(module.getUserId());
                    insert.setModuleId(userAuth.getModuleId());
                    insertList.add(insert);
                }
                this.insertBatch(insertList);
            } catch (Exception e) {
                logger.error(ResponseCode.UPDATE_EXCEPTION.getMessage(), e);
                throw new ApplicationException(ResponseCode.UPDATE_EXCEPTION);
            }
        }
        return result;
    }
}