

package com.einwin.devops.api.bo;

import com.einwin.devops.api.model.Host;
import com.einwin.framework.model.GenericBO;

/**
 * <pre>
 * 业务实体类
 * </pre>
 */
public class HostBO extends GenericBO {
    public HostBO() {
        setVo(new Host());
    }
    
    public Host getHost() {
        return (Host) getVo();
    }
    
    public void setHost(Host vo) {
    	setVo(vo);
    }
}