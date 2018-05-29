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

package com.einwin.devops.api.model;

import com.einwin.framework.model.GenericModel;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 实体类
 * 数据库表名称：module
 * </pre>
 */
public class Module extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 字段名称：上级ID
     *
     * 数据库字段信息:parentId bigint
     */
    private Long parentId;

    /**
     * 字段名称：编码
     *
     * 数据库字段信息:code VARCHAR(100)
     */
    private String code;

    /**
     * 字段名称：名称
     * 
     * 数据库字段信息:name VARCHAR(100)
     */
    private String name;

    /**
     * 字段名称：路径
     *
     * 数据库字段信息:path VARCHAR(100)
     */
    private String path;

    /**
     * 字段名称：图标
     *
     * 数据库字段信息:icon VARCHAR(100)
     */
    private String icon;

    /**
     * 字段名称：顺序
     *
     * 数据库字段信息:order tinyint
     */
    private Integer order;

    /**
     * 字段名称：描述
     *
     * 数据库字段信息:desc VARCHAR(300)
     */
    private String desc;

    public Module() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    // 查询分页用
    private String includeIds;
    // 查询模块是否已授权
    private Integer authorized;
    // 用户ID
    private String userId;
    //授权的模块ID
    private List<UserAuth> userAuthList;

    public String getIncludeIds() {
        return includeIds;
    }

    public void setIncludeIds(String includeIds) {
        this.includeIds = includeIds;
    }

    public Integer getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Integer authorized) {
        this.authorized = authorized;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<UserAuth> getUserAuthList() {
        return userAuthList;
    }

    public void setUserAuthList(List<UserAuth> userAuthList) {
        this.userAuthList = userAuthList;
    }
}