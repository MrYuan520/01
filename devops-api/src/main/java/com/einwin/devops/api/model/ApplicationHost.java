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

/**
 * <pre>
 * 实体类
 * 数据库表名称：application_host
 * </pre>
 */
public class ApplicationHost extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 字段名称：应用ID
     * 
     * 数据库字段信息:application_id BIGINT(19)
     */
    private Long applicationId;

    /**
     * 字段名称：主机ID
     * 
     * 数据库字段信息:host_id BIGINT(19)
     */
    private Long hostId;

    /**
     * 字段名称：主机名称
     *
     * 数据库字段信息:host_name VARCHAR(50)
     */
    private String hostName;

    /**
     * 字段名称：主机IP
     *
     * 数据库字段信息:host_ip VARCHAR(50)
     */
    private String hostIp;

    public ApplicationHost() {
    }	
    public Long getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
	
    public Long getHostId() {
        return this.hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }
	
    public String getHostName() {
        return this.hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostIp() {
        return this.hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }
}