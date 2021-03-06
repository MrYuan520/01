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

package com.einwin.devops.api.bo;

import com.einwin.devops.api.model.UserAuth;
import com.einwin.framework.model.GenericBO;

/**
 * <pre>
 * 业务实体类
 * </pre>
 */
public class UserAuthBO extends GenericBO<UserAuth> {
    public UserAuthBO() {
        setVo(new UserAuth());
    }

    public UserAuth getApi() {
        return (UserAuth) getVo();
    }

    public void setApi(UserAuth vo) {
        setVo(vo);
    }
}