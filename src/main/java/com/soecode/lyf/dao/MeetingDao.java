package com.soecode.lyf.dao;

import com.soecode.lyf.entity.Meeting;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface MeetingDao {
    void insertList(Meeting meeting);
    List<Meeting> queryList();
    void byIdDelete(String id);
    void byIdChange(Meeting meeting);
    List<Meeting> byIdQuery(String id);
}
