package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.MeetingDao;
import com.soecode.lyf.entity.Meeting;
import com.soecode.lyf.service.MeethingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class MeetingServiceImpl implements MeethingService {

    @Autowired
    private MeetingDao meetingDao;

    @Override
    public List<Meeting> queryList() {
        return meetingDao.queryList();
    }

    @Override
    public void insertList(Meeting meeting) {
        meetingDao.insertList(meeting);
    }

    @Override
    public Boolean byIdDelete(String id) {
        meetingDao.byIdDelete(id);
        List<Meeting> meeting= meetingDao.byIdQuery(id);
        if (meeting!=null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<Meeting> byIdQuery(String id) {
        return meetingDao.byIdQuery(id);
    }

    @Override
    public void byIdChange(Meeting meeting) {
        meetingDao.byIdChange(meeting);
    }
}
