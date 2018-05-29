

package com.einwin.devops.api.model;

import com.einwin.framework.model.GenericModel;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 实体类
 * 数据库表名称：host
 * </pre>
 */
public class Host extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 
     * 数据库字段信息:host_ip VARCHAR(50)
     */
    private String hostIp;

    /**
     * 字段名称：主机名称
     * 
     * 数据库字段信息:hostname VARCHAR(50)
     */
    private String hostname;

    /**
     * 字段名称：运营状态
     * 
     * 数据库字段信息:status INT(10)
     */
    private String status;

    /**
     * 字段名称：操作系统
     * 
     * 数据库字段信息:system VARCHAR(50)
     */
    private String system;

    /**
     * 字段名称：标签
     * 
     * 数据库字段信息:tag VARCHAR(50)
     */
    private String tag;

    /**
     * 字段名称：操作系统架构
     * 
     * 数据库字段信息:system_architect VARCHAR(50)
     */
    private String systemArchitect;

    /**
     * 字段名称：操作系统类型
     * 
     * 数据库字段信息:system_type VARCHAR(50)
     */
    private String systemType;

    /**
     * 字段名称：系统发行版本
     * 
     * 数据库字段信息:released_version VARCHAR(50)
     */
    private String releasedVersion;

    /**
     * 字段名称：系统内核发行版本
     * 
     * 数据库字段信息:kernel_version VARCHAR(50)
     */
    private String kernelVersion;

    /**
     * 字段名称：cpu型号
     * 
     * 数据库字段信息:cpu_type VARCHAR(50)
     */
    private String cpuType;

    /**
     * 字段名称：cpu频率
     * 
     * 数据库字段信息:GHz INT(10)
     */
    private String ghz;

    /**
     * 字段名称：CPU物理核心数量
     * 
     * 数据库字段信息:CPUcore_Num INT(10)
     */
    private String cpucoreNum;

    /**
     * 字段名称：内存大小
     * 
     * 数据库字段信息:RAM INT(10)
     */
    private String ram;

    /**
     * 字段名称：硬盘大小
     * 
     * 数据库字段信息:ROM VARCHAR(50)
     */
    private String rom;

    /**
     * 字段名称：物理地址
     * 
     * 数据库字段信息:MAC VARCHAR(50)
     */
    private String mac;

    /**
     * 字段名称：维护人员
     */
    private List<HostMaintainer> list;

    public List<HostMaintainer> getList() {
        return list;
    }

    public void setList(List<HostMaintainer> list) {
        this.list = list;
    }

    public Host() {
    }	
    public String getHostIp() {
        return this.hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }
	
    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
	
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	
    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
	
    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
	
    public String getSystemArchitect() {
        return this.systemArchitect;
    }

    public void setSystemArchitect(String systemArchitect) {
        this.systemArchitect = systemArchitect;
    }
	
    public String getSystemType() {
        return this.systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }
	
    public String getReleasedVersion() {
        return this.releasedVersion;
    }

    public void setReleasedVersion(String releasedVersion) {
        this.releasedVersion = releasedVersion;
    }
	
    public String getKernelVersion() {
        return this.kernelVersion;
    }

    public void setKernelVersion(String kernelVersion) {
        this.kernelVersion = kernelVersion;
    }
	
    public String getCpuType() {
        return this.cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }
	
    public String getGhz() {
        return this.ghz;
    }

    public void setGhz(String ghz) {
        this.ghz = ghz;
    }
	
    public String getCpucoreNum() {
        return this.cpucoreNum;
    }

    public void setCpucoreNum(String cpucoreNum) {
        this.cpucoreNum = cpucoreNum;
    }
	
    public String getRam() {
        return this.ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
	
    public String getRom() {
        return this.rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }
	
    public String getMac() {
        return this.mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}