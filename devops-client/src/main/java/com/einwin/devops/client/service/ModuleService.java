package com.einwin.devops.client.service;

import com.einwin.devops.api.bo.ModuleBO;
import com.einwin.devops.api.constant.DevopsInterface;
import com.einwin.devops.api.model.Module;
import com.einwin.devops.api.service.ModuleRemoteService;
import com.einwin.framework.model.Pagination;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.model.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 服务熔断
 *
 * @author ：Joy
 * @createTime ：2018/03/19
 */
@FeignClient(name = DevopsInterface.SERVICE_NAME, fallback = com.einwin.devops.client.service.ModuleService.HystrixClientFallback.class)
public interface ModuleService extends ModuleRemoteService {
    @Component
    public static class HystrixClientFallback implements com.einwin.devops.client.service.ModuleService {
        private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallback.class);
        @Override
        public ResponseData add(@RequestBody Module module) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData remove(@PathVariable("id") Long id) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData edit(@RequestBody Module module) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData(ResponseCode.UNKOWN_EXCEPTION);
        }

        @Override
        public ResponseData<Module> get(@PathVariable("id") Long id){
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData<Module>(ResponseCode.UNKOWN_EXCEPTION, null);
        }

        @Override
        public Pagination<Module> page(@RequestBody ModuleBO query) {
            logger.info("---------系统压力山大，熔断了--------------");
            return new Pagination<Module>();
        }

        @Override
        public ResponseData<List<Module>> list(@RequestBody ModuleBO query){
            logger.info("---------系统压力山大，熔断了--------------");
            return new ResponseData<List<Module>>(ResponseCode.UNKOWN_EXCEPTION, null);
        }
    }
}
