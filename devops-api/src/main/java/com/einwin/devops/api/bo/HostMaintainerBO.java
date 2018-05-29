
package com.einwin.devops.api.bo;

import com.einwin.devops.api.model.HostMaintainer;
import com.einwin.framework.model.GenericBO;

/**
 * <pre>
 * 业务实体类
 * </pre>
 */
public class HostMaintainerBO extends GenericBO {
    public HostMaintainerBO() {
        setVo(new HostMaintainer());
    }
    
    public HostMaintainer getHostMaintainer() {
        return (HostMaintainer) getVo();
    }
    
    public void setHostMaintainer(HostMaintainer vo) {
    	setVo(vo);
    }
}