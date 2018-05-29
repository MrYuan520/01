package com.einwin.devops.api.service;

import com.einwin.devops.api.bo.HostBO;
import com.einwin.devops.api.model.Host;
import com.einwin.framework.model.Pagination;
import com.einwin.framework.model.ResponseData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 服务接口
 *
 * @author ：袁博
 * @createTime ：2018/04/25
 */
public interface HostRemoteService {
    @RequestMapping(value = "/devops/host/add", method = RequestMethod.POST)
    public ResponseData add(@RequestBody Host host);

    @RequestMapping(value = "/devops/host/remove/{id}", method = RequestMethod.DELETE)
    public ResponseData remove(@PathVariable("id") Long id);

    @RequestMapping(value = "/devops/host/edit", method = RequestMethod.PUT)
    public ResponseData edit(@RequestBody Host host);

    @RequestMapping(value = "/devops/host/get/{id}", method = RequestMethod.GET)
    public ResponseData<Host> get(@PathVariable("id") Long id);

    @RequestMapping(value = "/devops/host/page", method = RequestMethod.POST)
    public Pagination<Host> page(@RequestBody HostBO query);


}
