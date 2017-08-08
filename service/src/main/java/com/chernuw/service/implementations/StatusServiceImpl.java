package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.StatusDao;
import com.chernuw.model.Status;
import com.chernuw.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("statusService")
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusDao statusDao;

    public List<Status> getStatuses() {
        return statusDao.getStatuses();
    }
}
