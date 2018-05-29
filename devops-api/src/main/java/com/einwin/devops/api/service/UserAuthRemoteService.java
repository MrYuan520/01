package com.einwin.devops.api.service;

import com.einwin.devops.api.bo.UserAuthBO;
import com.einwin.devops.api.model.Module;
import com.einwin.framework.model.ResponseData;
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
public interface UserAuthRemoteService {

    @RequestMapping(value = "/devops/userAuth/getAuthModule", method = RequestMethod.POST)
    public ResponseData<List<Module>> getAuthModule(@RequestBody UserAuthBO query);

    @RequestMapping(value = "/devops/userAuth/save", method = RequestMethod.PUT)
    public ResponseData save(@RequestBody Module module);

    @RequestMapping(value = "/devops/userAuth/getMenu", method = RequestMethod.POST)
    public ResponseData<List<Module>> getMenu(@RequestBody UserAuthBO query);
}
