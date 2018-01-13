package com.soecode.lyf.service;

import com.soecode.lyf.entity.Wages;

import java.util.List;

public interface WagesService {
    List<Wages> queryList();
    Wages addWages(Wages wages);
    Wages deleteWages(int id);
    Wages updateWages(Wages wages);
}
