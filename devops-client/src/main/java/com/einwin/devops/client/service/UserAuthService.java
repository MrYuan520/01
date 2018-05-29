package com.einwin.devops.client.service;

import com.einwin.devops.api.bo.UserAuthBO;
import com.einwin.devops.api.constant.DevopsInterface;
import com.einwin.devops.api.model.Module;
import com.einwin.devops.api.service.UserAuthRemoteService;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.model.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 服务熔断
 *
 * @author ：Joy
 * @createTime ：2018/03/19
 */
@FeignClient(name = DevopsInterface.SERVICE_NAME, fallback = com.einwin.devops.client.service.UserAuthService.HystrixClientFallback.class)
public interface UserAuthService extends UserAuthRemoteService {
    @Component
    public static class HystrixClientFallback implements com.einwin.devops.client.service.UserAuthService {
        private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallback.class);

        @Override
        public ResponseData<List<Module>> getAuthModule(@RequestBody UserAuthBO query){
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData<List<Module>>(ResponseCode.UNKOWN_EXCEPTION, null);
        }

        @Override
        public ResponseData save(@RequestBody Module module) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData<List<Module>> getMenu(@RequestBody UserAuthBO query) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData<List<Module>>(ResponseCode.UNKOWN_EXCEPTION, null);
        }
    }
}
