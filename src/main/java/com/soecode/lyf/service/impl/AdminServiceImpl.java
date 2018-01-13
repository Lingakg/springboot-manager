package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.AdminDao;
import com.soecode.lyf.entity.Admin;
import com.soecode.lyf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin queryAdmin(String name) {
        return adminDao.queryAdmin(name);
    }
}
