package com.soecode.lyf.service;

import com.soecode.lyf.entity.Meeting;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface MeethingService {
    List<Meeting> queryList();
    void insertList(Meeting meeting);
    Boolean byIdDelete(String id);

    List<Meeting> byIdQuery(String id);

    void byIdChange(Meeting meeting);
}
