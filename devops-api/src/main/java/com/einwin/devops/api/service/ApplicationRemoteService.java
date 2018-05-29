package com.einwin.devops.api.service;

import com.einwin.framework.model.Pagination;
import com.einwin.framework.model.ResponseData;
import com.einwin.devops.api.bo.ApplicationBO;
import com.einwin.devops.api.model.Application;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 服务接口
 *
 * @author ：Joy
 * @createTime ：2018/03/19
 */
public interface ApplicationRemoteService {
    @RequestMapping(value = "/devops/application/add", method = RequestMethod.POST)
    public ResponseData add(@RequestBody Application application);

    @RequestMapping(value = "/devops/application/remove/{id}", method = RequestMethod.DELETE)
    public ResponseData remove(@PathVariable("id") Long id);

    @RequestMapping(value = "/devops/application/edit", method = RequestMethod.PUT)
    public ResponseData edit(@RequestBody Application application);

    @RequestMapping(value = "/devops/application/get/{id}", method = RequestMethod.GET)
    public ResponseData<Application> get(@PathVariable("id") Long id);

    @RequestMapping(value = "/devops/application/page", method = RequestMethod.POST)
    public Pagination<Application> page(@RequestBody ApplicationBO query);

}
