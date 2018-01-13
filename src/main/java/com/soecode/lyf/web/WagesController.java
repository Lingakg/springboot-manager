package com.soecode.lyf.web;

import com.soecode.lyf.entity.Meeting;
import com.soecode.lyf.entity.Wages;
import com.soecode.lyf.excel.ReadyExcel;
import com.soecode.lyf.service.WagesService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/service")
public class WagesController {

    @Autowired
    private WagesService wagesService;

    @RequestMapping(value = "/wagesList",method= RequestMethod.GET)
    @ResponseBody
    public List<Wages> list(){
        return wagesService.queryList();
    }

    @RequestMapping(value = "/deleteWages",method= RequestMethod.GET)
    @ResponseBody
    public Wages deleteWages(int id){
        return wagesService.deleteWages(id);
    }

    @RequestMapping(value = "/updateWages",method= RequestMethod.GET)
    @ResponseBody
    public Wages updateWages(Wages wages){
        return wagesService.updateWages(wages);
    }

    @RequestMapping(value = "/addWages",method= RequestMethod.GET)
    @ResponseBody
    public Wages addWages(Wages wages){
        return wagesService.addWages(wages);
    }


//    @Test
//    public void upload() throws FileNotFoundException {
////        return wagesService.addWages(wages);
//        ReadyExcel re = new ReadyExcel();
//        Collection<Map> rs = re.importXlsx("data.xlsx");
//
//        System.out.println(rs);
//
//
//        for(Map m:rs){
//            System.out.println(m.get("name"));
//        }
//    }

}
