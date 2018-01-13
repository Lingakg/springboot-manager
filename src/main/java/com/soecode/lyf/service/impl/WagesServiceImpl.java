package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.WagesDao;
import com.soecode.lyf.entity.Wages;
import com.soecode.lyf.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WagesServiceImpl implements WagesService{

    @Autowired
    private WagesDao wagesDao;

    @Override
    public List<Wages> queryList() {
        return wagesDao.queryList();
    }

    @Override
    public Wages addWages(Wages wages) {
        return wagesDao.addWages(wages);
    }

    @Override
    public Wages deleteWages(int id) {
        return wagesDao.deleteWages(id);
    }

    @Override
    public Wages updateWages(Wages wages) {
        return wagesDao.updateWages(wages);
    }
}
