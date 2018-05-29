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
 * 数据库表名称：application_maintainer
 * </pre>
 */
public class ApplicationMaintainer extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 字段名称：应用ID
     * 
     * 数据库字段信息:application_id BIGINT(19)
     */
    private Long applicationId;

    /**
     * 字段名称：成员ID
     * 
     * 数据库字段信息:member_id VARCHAR(100)
     */
    private String memberId;

    /**
     * 字段名称：成员名称
     * 
     * 数据库字段信息:member_name VARCHAR(50)
     */
    private String memberName;

    /**
     * 字段名称：成员手机
     * 
     * 数据库字段信息:member_phone VARCHAR(16)
     */
    private String memberPhone;

    /**
     * 字段名称：成员工号
     * 
     * 数据库字段信息:member_no VARCHAR(16)
     */
    private String memberNo;

    public ApplicationMaintainer() {
    }	
    public Long getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
	
    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
	
    public String getMemberName() {
        return this.memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
	
    public String getMemberPhone() {
        return this.memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
	
    public String getMemberNo() {
        return this.memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
}