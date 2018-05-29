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

import com.einwin.devops.api.bo.ApplicationBO;
import com.einwin.devops.api.constant.DevopsCode;
import com.einwin.devops.api.model.Application;
import com.einwin.devops.api.service.ApplicationRemoteService;
import com.einwin.devops.provider.service.ApplicationHostService;
import com.einwin.devops.provider.service.ApplicationMaintainerService;
import com.einwin.devops.provider.service.ApplicationService;
import com.einwin.framework.model.AppCode;
import com.einwin.framework.model.Pagination;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.model.ResponseData;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
//@RequestMapping(value = "/devops/application")
public class ApplicationController implements ApplicationRemoteService {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
    
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    ApplicationMaintainerService maintainerService;

    @Autowired
    ApplicationHostService hostService;

    @Override
    public ResponseData add(@RequestBody Application application) {
        try {
            AppCode appCode = checkArg(application);
            if (appCode.getCode() != ResponseCode.SUCCESS.getCode()) {
                return new ResponseData(appCode);
            }
            this.applicationService.add(application);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.INSERT_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.INSERT_EXCEPTION);
        }
    }

    @Override
    public ResponseData remove(@PathVariable("id") Long id) {
        try {
            this.applicationService.remove(id);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.DELETE_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.DELETE_EXCEPTION);
        }
    }

    @Override
    //@PropertyFiltration(clazz = Application.class, excludes = {"updationDate", "enabledFlag"}, includes = {"createdBy"})
    public ResponseData edit(@RequestBody Application application) {
        try {
            AppCode appCode = checkArg(application);
            if (appCode.getCode() != ResponseCode.SUCCESS.getCode()) {
                return new ResponseData(appCode);
            }
            this.applicationService.edit(application);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.UPDATE_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.UPDATE_EXCEPTION);
        }
    }

    @Override
    public ResponseData<Application> get(@PathVariable("id") Long id) {
        try {
            Application application = this.applicationService.get(id);
            application.setApplicationMaintainers(this.maintainerService.getByAppId(id));
            application.setApplicationHosts(this.hostService.getByAppId(id));
            return new ResponseData<Application>(ResponseCode.SUCCESS, application);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_ONE_EXCEPTION.getMessage(), ex);
            return new ResponseData<Application>(ResponseCode.SELECT_ONE_EXCEPTION, null);
        }
    }

    @Override
    public Pagination<Application> page(@RequestBody ApplicationBO query) {
        Pagination<Application> page = new Pagination<Application>();
        try {
            page.setPageSize(query.getPageSize());
            page.setPage(query.getPage());
            page.setCriteria(query);
            this.applicationService.search(page);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_PAGINATION_EXCEPTION.getMessage(), ex);
        }
        return page;
    }

    private AppCode checkArg(Application application) {
        if (application == null) {
            return DevopsCode.ARG_ERROR.format("传入参数为空");
        }
        if (StringUtil.isEmpty(application.getName())) {
            return DevopsCode.ARG_ERROR.format("应用名称不能为空");
        }
        if (StringUtil.isEmpty(application.getVersionControlType())) {
            return DevopsCode.ARG_ERROR.format("版本库类型不能为空");
        }
        if (StringUtil.isEmpty(application.getSourceCodeUrl())) {
            return DevopsCode.ARG_ERROR.format("源码地址不能为空");
        }
        if (StringUtil.isEmpty(application.getUserName())) {
            return DevopsCode.ARG_ERROR.format("用户名不能为空");
        }
        if (StringUtil.isEmpty(application.getPassWord())) {
            return DevopsCode.ARG_ERROR.format("密码不能为空");
        }
        return ResponseCode.SUCCESS;
    }
}