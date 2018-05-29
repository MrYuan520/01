
package com.einwin.devops.provider.mapper;

import com.einwin.devops.api.model.HostMaintainer;
import com.einwin.framework.mapper.GenericMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <pre>
 * 数据访问接口
 * </pre>
 */
@Mapper
public interface HostMaintainerMapper extends GenericMapper<HostMaintainer, Long> {

     List<HostMaintainer> searchByHostId(Long hostId);

     Integer disableByHostId(Long hostId);
}