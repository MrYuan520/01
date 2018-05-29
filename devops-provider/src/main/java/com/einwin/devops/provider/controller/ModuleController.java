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

import com.einwin.devops.api.bo.ModuleBO;
import com.einwin.devops.api.constant.DevopsCode;
import com.einwin.devops.api.model.Module;
import com.einwin.devops.api.service.ModuleRemoteService;
import com.einwin.devops.provider.service.ModuleService;
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

import java.util.List;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
//@RequestMapping(value = "/devops/module")
public class ModuleController implements ModuleRemoteService {
    private static final Logger logger = LoggerFactory.getLogger(ModuleController.class);
    
    @Autowired
    private ModuleService moduleService;

    @Override
    public ResponseData add(@RequestBody Module module) {
        try {
            AppCode appCode = checkArg(module);
            if (appCode.getCode() != ResponseCode.SUCCESS.getCode()) {
                return new ResponseData(appCode);
            }
            this.moduleService.insert(module);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.INSERT_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.INSERT_EXCEPTION);
        }
    }

    @Override
    public ResponseData remove(@PathVariable("id") Long id) {
        try {
            this.moduleService.disable(id);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.DELETE_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.DELETE_EXCEPTION);
        }
    }

    @Override
    public ResponseData edit(@RequestBody Module module) {
        try {
            AppCode appCode = checkArg(module);
            if (appCode.getCode() != ResponseCode.SUCCESS.getCode()) {
                return new ResponseData(appCode);
            }
            this.moduleService.updateSelective(module);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.UPDATE_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.UPDATE_EXCEPTION);
        }
    }

    @Override
    public ResponseData<Module> get(@PathVariable("id") Long id) {
        try {
            Module module = this.moduleService.get(id);
            return new ResponseData<Module>(ResponseCode.SUCCESS, module);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_ONE_EXCEPTION.getMessage(), ex);
            return new ResponseData<Module>(ResponseCode.SELECT_ONE_EXCEPTION, null);
        }
    }

    @Override
    public Pagination<Module> page(@RequestBody ModuleBO query) {
        Pagination<Module> page = new Pagination<Module>();
        try {
            page.setPageSize(query.getPageSize());
            page.setPage(query.getPage());
            page.setCriteria(query);
            this.moduleService.search(page);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_PAGINATION_EXCEPTION.getMessage(), ex);
        }
        return page;
    }

    @Override
    public ResponseData<List<Module>> list(@RequestBody ModuleBO query) {
        try {
            List<Module> list = this.moduleService.getAll();
            return new ResponseData<List<Module>>(ResponseCode.SUCCESS, list);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_EXCEPTION.getMessage(), ex);
            return new ResponseData<List<Module>>(ResponseCode.SELECT_ONE_EXCEPTION, null);
        }
    }

    private AppCode checkArg(Module module) {
        if (module == null) {
            return DevopsCode.ARG_ERROR.format("传入参数为空");
        }
        if (StringUtil.isEmpty(module.getCode())) {
            return DevopsCode.ARG_ERROR.format("编码不能为空");
        }
        if (StringUtil.isEmpty(module.getName())) {
            return DevopsCode.ARG_ERROR.format("名称不能为空");
        }
        if (StringUtil.isEmpty(module.getPath())) {
            return DevopsCode.ARG_ERROR.format("路径不能为空");
        }
        if (module.getOrder() == null) {
            return DevopsCode.ARG_ERROR.format("序号不能为空");
        }
        return ResponseCode.SUCCESS;
    }
}