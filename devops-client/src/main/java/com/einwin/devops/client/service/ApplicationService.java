package com.einwin.devops.client.service;

import com.einwin.framework.model.Pagination;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.model.ResponseData;
import com.einwin.devops.api.bo.ApplicationBO;
import com.einwin.devops.api.constant.DevopsInterface;
import com.einwin.devops.api.model.Application;
import com.einwin.devops.api.service.ApplicationRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 服务熔断
 *
 * @author ：Joy
 * @createTime ：2018/03/19
 */
@FeignClient(name = DevopsInterface.SERVICE_NAME, fallback = com.einwin.devops.client.service.ApplicationService.HystrixClientFallback.class)
public interface ApplicationService extends ApplicationRemoteService {
    @Component
    public static class HystrixClientFallback implements com.einwin.devops.client.service.ApplicationService {
        private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallback.class);
        @Override
        public ResponseData add(@RequestBody Application application) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData remove(@PathVariable("id") Long id) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData edit(@RequestBody Application application) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData<Application> get(@PathVariable("id") Long id){
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData<Application>(ResponseCode.UNKOWN_EXCEPTION, null);
        }

        @Override
        public Pagination<Application> page(@RequestBody ApplicationBO query) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new Pagination<Application>();
        }
    }
}
