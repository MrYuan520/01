
package com.einwin.devops.provider.service;

import com.einwin.devops.api.model.Host;
import com.einwin.devops.api.model.HostMaintainer;
import com.einwin.devops.provider.mapper.HostMapper;
import com.einwin.framework.model.ResponseCode;
import com.einwin.framework.model.ResponseData;
import com.einwin.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * <pre>
 * 业务类
 * </pre>
 */
@Service("hostService")
public class HostService extends GenericService<Host, Long> {
    public HostService(@Autowired HostMapper hostMapper) {
        super(hostMapper);
    }

    public HostMapper getMapper() {
        return (HostMapper) super.genericMapper;
    }

    @Autowired
    public HostMaintainerService maintainerService;

    public ResponseData add(Host host){
        insert(host);
        List<HostMaintainer> list = host.getList();
        list.forEach(HostMaintainer->HostMaintainer.setHostId(host.getId()));
        maintainerService.insertBatch(list);
        return new ResponseData(ResponseCode.SUCCESS);
    }

    public Host getById(Long id){
        Host host = get(id);
        Long hostId = host.getId();
        List<HostMaintainer> hostMaintainers = maintainerService.searchByHostId(hostId);
        host.setList(hostMaintainers);
        return host;
    }


    public int disableById(Long id) {
        int disable = disable(id);
        maintainerService.disableByHostId(id);
        return disable;
    }

    public ResponseData myUpdateSelective(Host host) {
        updateSelective(host);
        List<HostMaintainer> addList = host.getList();
        addList.forEach(HostMaintainer->HostMaintainer.setHostId(host.getId()));
        List<HostMaintainer> removeList = maintainerService.searchByHostId(host.getId());
        List<HostMaintainer> updateList = new ArrayList<>();

        addList.forEach(newMaintainer->{
            removeList.forEach(oldMaintainer->{
                if (newMaintainer.getFnumber().equals(oldMaintainer.getFnumber())) {
                    newMaintainer.setId(oldMaintainer.getId());
                    updateList.add(newMaintainer);
                }
            });
        });

        if(null != updateList && updateList.size() != 0){
            Iterator<HostMaintainer> rmIterator = removeList.iterator();
            while (rmIterator.hasNext()){
                HostMaintainer rmMaintainer = rmIterator.next();
                updateList.forEach(upMaintainer->{
                    if(upMaintainer.getFnumber().equals(rmMaintainer.getFnumber())){
                        rmIterator.remove();
                    }
                });
            }

            Iterator<HostMaintainer> addIterator = addList.iterator();
            while (addIterator.hasNext()){
                HostMaintainer addMaintainer = addIterator.next();
                updateList.forEach(upMaintainer->{
                    if(upMaintainer.getFnumber().equals(addMaintainer.getFnumber())){
                        addIterator.remove();
                    }
                });
            }
            maintainerService.updateBatch(updateList);
        }

        if (null != removeList && removeList.size() != 0){
            removeList.forEach(removeMaintainer->maintainerService.disable(removeMaintainer.getId()));
        }
        if (null != addList && addList.size() != 0){
            maintainerService.insertBatch(addList);
        }
        return new ResponseData(ResponseCode.SUCCESS);
    }


}