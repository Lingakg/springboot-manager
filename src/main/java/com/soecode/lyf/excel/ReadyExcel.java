package com.soecode.lyf.excel;

import com.soecode.lyf.ExcelUtil.ExcelLogs;
import com.soecode.lyf.ExcelUtil.ExcelUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

public class ReadyExcel {
    public Collection<Map> importXlsx(String path) throws FileNotFoundException {
        File f=new File(path);
        InputStream inputStream= new FileInputStream(f);

        ExcelLogs logs =new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs , 0);

//        System.out.println(importExcel);
//        for(Map m : importExcel){
//            System.out.println(m);
//        }
        return importExcel;
    }
    public Collection<Map> inputSteamFile(InputStream stream){
//        File f=new File(path);
        InputStream inputStream= stream;

        ExcelLogs logs =new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs , 0);

//        System.out.println(importExcel);
//        for(Map m : importExcel){
//            System.out.println(m);
//        }
        return importExcel;
    }
}