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

package com.einwin.devops.api.model;

import com.einwin.framework.model.GenericModel;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 实体类
 * 数据库表名称：application
 * </pre>
 */
public class Application extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 字段名称：应用图标
     * 
     * 数据库字段信息:icon_url VARCHAR(255)
     */
    private String iconUrl;

    /**
     * 字段名称：应用名称
     * 
     * 数据库字段信息:name VARCHAR(50)
     */
    private String name;

    /**
     * 字段名称：应用描述
     * 
     * 数据库字段信息:description VARCHAR(255)
     */
    private String description;

    /**
     * 字段名称：版本库类型
     * 
     * 数据库字段信息:version_control_type VARCHAR(30)
     */
    private String versionControlType;

    /**
     * 字段名称：源码地址
     * 
     * 数据库字段信息:source_code_url VARCHAR(255)
     */
    private String sourceCodeUrl;

    /**
     * 字段名称：源码登录用户
     * 
     * 数据库字段信息:user_name VARCHAR(50)
     */
    private String userName;

    /**
     * 字段名称：源码登录密码
     * 
     * 数据库字段信息:pass_word VARCHAR(50)
     */
    private String passWord;

    private List<ApplicationMaintainer> applicationMaintainers;

    private List<ApplicationHost> applicationHosts;

    public Application() {
    }
    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersionControlType() {
        return this.versionControlType;
    }

    public void setVersionControlType(String versionControlType) {
        this.versionControlType = versionControlType;
    }

    public String getSourceCodeUrl() {
        return this.sourceCodeUrl;
    }

    public void setSourceCodeUrl(String sourceCodeUrl) {
        this.sourceCodeUrl = sourceCodeUrl;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<ApplicationMaintainer> getApplicationMaintainers() {
        return applicationMaintainers;
    }

    public void setApplicationMaintainers(List<ApplicationMaintainer> applicationMaintainers) {
        this.applicationMaintainers = applicationMaintainers;
    }

    public List<ApplicationHost> getApplicationHosts() {
        return applicationHosts;
    }

    public void setApplicationHosts(List<ApplicationHost> applicationHosts) {
        this.applicationHosts = applicationHosts;
    }
}