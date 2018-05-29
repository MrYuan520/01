package com.einwin.devops.client.service;

import com.einwin.devops.api.bo.HostBO;
import com.einwin.devops.api.constant.DevopsInterface;
import com.einwin.devops.api.model.Host;
import com.einwin.devops.api.service.HostRemoteService;
import com.einwin.framework.model.Pagination;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.model.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 服务熔断
 *
 * @author ：YuanBo
 * @createTime ：2018/04/27
 */
@FeignClient(name = DevopsInterface.SERVICE_NAME, fallback = HostService.HystrixClientFallback.class)
public interface HostService extends HostRemoteService {
    @Component
    public static class HystrixClientFallback implements HostService {
        private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallback.class);
        @Override
        public ResponseData add(@RequestBody Host host) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData remove(@PathVariable("id") Long id) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData edit(@RequestBody Host host) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData<Host> get(@PathVariable("id") Long id){
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData<Host>(ResponseCode.UNKOWN_EXCEPTION, null);
        }

        @Override
        public Pagination<Host> page(@RequestBody HostBO query) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new Pagination<Host>();
        }
    }
}
