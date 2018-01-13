package com.soecode.lyf.dao;

import com.soecode.lyf.entity.Wages;
import org.springframework.stereotype.Component;

import java.util.List;

public interface WagesDao {
    List<Wages> queryList();
    Wages addWages(Wages wages);
    Wages deleteWages(int id);
    Wages updateWages(Wages wages);
}
