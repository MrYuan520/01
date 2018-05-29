package com.einwin.devops.api.service;

import com.einwin.devops.api.bo.ModuleBO;
import com.einwin.devops.api.model.Module;
import com.einwin.framework.model.Pagination;
import com.einwin.framework.model.ResponseData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 服务接口
 *
 * @author ：Joy
 * @createTime ：2018/03/19
 */
public interface ModuleRemoteService {
    @RequestMapping(value = "/devops/module/add", method = RequestMethod.POST)
    public ResponseData add(@RequestBody Module module);

    @RequestMapping(value = "/devops/module/remove/{id}", method = RequestMethod.DELETE)
    public ResponseData remove(@PathVariable("id") Long id);

    @RequestMapping(value = "/devops/module/edit", method = RequestMethod.PUT)
    public ResponseData edit(@RequestBody Module module);

    @RequestMapping(value = "/devops/module/get/{id}", method = RequestMethod.GET)
    public ResponseData<Module> get(@PathVariable("id") Long id);

    @RequestMapping(value = "/devops/module/page", method = RequestMethod.POST)
    public Pagination<Module> page(@RequestBody ModuleBO query);

    @RequestMapping(value = "/devops/module/list", method = RequestMethod.POST)
    public ResponseData<List<Module>> list(@RequestBody ModuleBO query);
}
