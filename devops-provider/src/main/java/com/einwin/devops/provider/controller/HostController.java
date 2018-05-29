

package com.einwin.devops.provider.controller;

import com.einwin.devops.api.bo.HostBO;
import com.einwin.devops.api.constant.DevopsCode;
import com.einwin.devops.api.model.Host;
import com.einwin.devops.api.service.HostRemoteService;
import com.einwin.devops.provider.service.HostMaintainerService;
import com.einwin.devops.provider.service.HostService;
import com.einwin.framework.model.AppCode;
import com.einwin.framework.model.Pagination;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.model.ResponseData;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * 表现层控制类
 * </pre>
 */
//@RefreshScope
@RestController
//@RequestMapping(value = "/devops/host")
public class HostController implements HostRemoteService {
    private static final Logger logger = LoggerFactory.getLogger(HostController.class);

    @Autowired
    private HostService hostService;

    @Autowired
    public HostMaintainerService maintainerService;

    @Override
    public ResponseData get(@PathVariable("id") Long id) {
        try {
            Host host  = hostService.getById(id);
            return new ResponseData(ResponseCode.SUCCESS,host);
        } catch (Exception ex) {
            logger.error(ResponseCode.INSERT_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.SELECT_ONE_EXCEPTION);
        }
    }


    @Override
    public ResponseData add(@RequestBody Host host) {
        try {
            AppCode appCode = checkArg(host);
            if(appCode.getCode() != ResponseCode.SUCCESS.getCode()){
                return new ResponseData(appCode);
            }
            this.hostService.add(host);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.INSERT_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.INSERT_EXCEPTION);
        }
    }

    @Override
    public ResponseData remove(@PathVariable("id") Long id) {
        try {
            this.hostService.disableById(id);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.DELETE_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.DELETE_EXCEPTION);
        }
    }

    @Override
    public ResponseData edit(@RequestBody Host host) {
        try {
            AppCode appCode = checkArg(host);
            if(appCode.getCode() != ResponseCode.SUCCESS.getCode()){
                return new ResponseData(appCode);
            }
            this.hostService.myUpdateSelective(host);
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception ex) {
            logger.error(ResponseCode.UPDATE_EXCEPTION.getMessage(), ex);
            return new ResponseData(ResponseCode.UPDATE_EXCEPTION);
        }
    }

    @Override
    public Pagination<Host> page(@RequestBody HostBO query) {
        Pagination<Host> page = new Pagination<Host>();
        try {
            page.setPageSize(query.getPageSize());
            page.setPage(query.getPage());
            page.setCriteria(query);
            this.hostService.search(page);
        } catch (Exception ex) {
            logger.error(ResponseCode.SELECT_PAGINATION_EXCEPTION.getMessage(), ex);
        }
        return page;
    }

    private AppCode checkArg(Host host) {
        if (host == null) {
            return DevopsCode.ARG_ERROR.format("传入参数为空");
        }
        if (StringUtil.isEmpty(host.getHostname())) {
            return DevopsCode.ARG_ERROR.format("主机名称不能为空");
        }
        if (StringUtil.isEmpty(host.getHostIp())) {
            return DevopsCode.ARG_ERROR.format("主机IP不能为空");
        }
        if (StringUtil.isEmpty(host.getStatus())) {
            return DevopsCode.ARG_ERROR.format("主机备注不能为空");
        }
        return ResponseCode.SUCCESS;
    }

}