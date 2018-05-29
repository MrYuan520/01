
/**
  * <pre>
  * 作   者：袁博
  * 创建日期：2018-4-25
  * </pre>
  */

package com.einwin.devops.api.model;

import com.einwin.framework.model.GenericModel;

import java.io.Serializable;

/**
 * <pre>
 * 实体类
 * 数据库表名称：host_maintainer
 * </pre>
 */
public class HostMaintainer extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 字段名称：主机ID
     * 
     * 数据库字段信息:host_id BIGINT(19)
     */
    private Long hostId;

    /**
     * 字段名称：人员姓名
     * 
     * 数据库字段信息:username VARCHAR(50)
     */
    private String fnameL2;

    /**
     * 字段名称：人员编号
     * 
     * 数据库字段信息:fnumber VARCHAR(50)
     */
    private String fnumber;

    /**
     * 字段名称：人员电话号码
     * 
     * 数据库字段信息:tellphone VARCHAR(50)
     */
    private String fcell;

    public HostMaintainer() {
    }	
    public Long getHostId() {
        return this.hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public String getFnumber() {
        return this.fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public String getFnameL2() {
        return fnameL2;
    }

    public void setFnameL2(String fnameL2) {
        this.fnameL2 = fnameL2;
    }

    public String getFcell() {
        return fcell;
    }

    public void setFcell(String fcell) {
        this.fcell = fcell;
    }
}