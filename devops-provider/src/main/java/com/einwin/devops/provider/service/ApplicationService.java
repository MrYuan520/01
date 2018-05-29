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

import com.einwin.devops.api.model.Application;
import com.einwin.devops.api.model.ApplicationHost;
import com.einwin.devops.api.model.ApplicationMaintainer;
import com.einwin.devops.provider.mapper.ApplicationMapper;
import com.einwin.framework.exception.ApplicationException;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 接口信息表业务类
 * </pre>
 */
@Service("applicationService")
public class ApplicationService extends GenericService<Application, Long> {
    public ApplicationService(@Autowired ApplicationMapper applicationMapper) {
        super(applicationMapper);
    }
    
    public ApplicationMapper getMapper() {
        return (ApplicationMapper) super.genericMapper;
    }

    @Autowired
    ApplicationMaintainerService maintainerService;

    @Autowired
    ApplicationHostService hostService;

    public int add(Application application) {
        int result = 0;
        try {
            result = this.insert(application);

            List<ApplicationMaintainer> maintainers = application.getApplicationMaintainers();
            List<ApplicationHost> hosts = application.getApplicationHosts();

            List<ApplicationMaintainer> insertMaintainers = new ArrayList<ApplicationMaintainer>();
            if (maintainers != null && maintainers.size() > 0) {
                for (ApplicationMaintainer maintainer : maintainers) {
                    ApplicationMaintainer insert = new ApplicationMaintainer();
                    insert.setApplicationId(application.getId());
                    insert.setMemberId(maintainer.getMemberId());
                    insert.setMemberName(maintainer.getMemberName());
                    insert.setMemberPhone(maintainer.getMemberPhone());
                    insert.setMemberNo(maintainer.getMemberNo());
                    insertMaintainers.add(insert);
                }
                maintainerService.insertBatch(insertMaintainers);
            }

            if (hosts != null && hosts.size() > 0) {
                List<ApplicationHost> insertHosts = new ArrayList<ApplicationHost>();
                for (ApplicationHost host : hosts) {
                    ApplicationHost insert = new ApplicationHost();
                    insert.setApplicationId(application.getId());
                    insert.setHostId(host.getHostId());
                    insertHosts.add(insert);
                }
                hostService.insertBatch(insertHosts);
            }

            return result;
        } catch (Exception var4) {
            logger.error(ResponseCode.INSERT_EXCEPTION.getMessage(), var4);
            throw new ApplicationException(ResponseCode.INSERT_EXCEPTION);
        }
    }

    public int remove(Long id) {
        int result = 0;
        try {
            result = this.disable(id);
            maintainerService.disabledByAppId(id);
            hostService.disabledByAppId(id);
            return result;
        } catch (Exception var4) {
            logger.error(ResponseCode.DELETE_EXCEPTION.getMessage(), var4);
            throw new ApplicationException(ResponseCode.DELETE_EXCEPTION);
        }
    }

    public int edit(Application application) {
        int result = 0;
        try {
            result = this.updateSelective(application);
            maintainerService.deleteByAppId(application.getId());
            hostService.deleteByAppId(application.getId());

            List<ApplicationMaintainer> maintainers = application.getApplicationMaintainers();
            List<ApplicationHost> hosts = application.getApplicationHosts();

            if (maintainers != null && maintainers.size() > 0) {
                List<ApplicationMaintainer> insertMaintainers = new ArrayList<ApplicationMaintainer>();
                for (ApplicationMaintainer maintainer : maintainers) {
                    ApplicationMaintainer insert = new ApplicationMaintainer();
                    insert.setApplicationId(application.getId());
                    insert.setMemberId(maintainer.getMemberId());
                    insert.setMemberName(maintainer.getMemberName());
                    insert.setMemberPhone(maintainer.getMemberPhone());
                    insert.setMemberNo(maintainer.getMemberNo());
                    insertMaintainers.add(insert);
                }
                maintainerService.insertBatch(insertMaintainers);
            }

            if (hosts != null && hosts.size() > 0) {
                List<ApplicationHost> insertHosts = new ArrayList<ApplicationHost>();
                for (ApplicationHost host : hosts) {
                    ApplicationHost insert = new ApplicationHost();
                    insert.setApplicationId(application.getId());
                    insert.setHostId(host.getHostId());
                    insertHosts.add(insert);
                }
                hostService.insertBatch(insertHosts);
            }

            return result;
        } catch (Exception var4) {
            logger.error(ResponseCode.UPDATE_EXCEPTION.getMessage(), var4);
            throw new ApplicationException(ResponseCode.UPDATE_EXCEPTION);
        }
    }
}