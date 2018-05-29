
package com.einwin.devops.provider.service;

import com.einwin.devops.api.model.HostMaintainer;
import com.einwin.devops.provider.mapper.HostMaintainerMapper;
import com.einwin.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * 业务类
 * </pre>
 */
@Service("hostMaintainerService")
public class HostMaintainerService extends GenericService<HostMaintainer, Long> {
    public HostMaintainerService(@Autowired HostMaintainerMapper hostMaintainerMapper) {
        super(hostMaintainerMapper);
    }
    
    public HostMaintainerMapper getMapper() {
        return (HostMaintainerMapper) super.genericMapper;
    }

    public List<HostMaintainer> searchByHostId(Long hostId) {
        return getMapper().searchByHostId(hostId);
    }

    public void disableByHostId(Long hostId) {
        getMapper().disableByHostId(hostId);
    }
}