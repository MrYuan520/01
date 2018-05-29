

package com.einwin.devops.provider.mapper;

import com.einwin.devops.api.model.Host;
import com.einwin.framework.mapper.GenericMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <pre>
 * 数据访问接口
 * </pre>
 */
@Mapper
public interface HostMapper extends GenericMapper<Host, Long> {
}