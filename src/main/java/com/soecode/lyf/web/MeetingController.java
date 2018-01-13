package com.soecode.lyf.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soecode.lyf.constant.BaseModel;
import com.soecode.lyf.dao.MeetingDao;
import com.soecode.lyf.entity.Meeting;
import com.soecode.lyf.excel.ReadyExcel;
import com.soecode.lyf.service.MeethingService;
import com.sun.net.httpserver.Authenticator;
import org.apache.ibatis.javassist.bytecode.SyntheticAttribute;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.*;

@Controller
@RequestMapping(value = "/service")
public class MeetingController {

    @Autowired
    private MeethingService meethingService;

//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
//    @ResponseBody
//    private Map uploadFile(@RequestParam("upfile") MultipartFile file) throws Exception {
//
////        ReadyExcel re = new ReadyExcel();
////        Collection<Map> rs = re.importXlsx("data.xlsx");
//
//
//        return new HashMap();
//    }

//    byIdDelete

    @RequestMapping(value = "/byIdQuery",method = RequestMethod.POST)
    @ResponseBody
    public BaseModel byIdQuery(String id){
        List<Meeting> meeting = meethingService.byIdQuery(id);
        if(meeting!=null){
            return new BaseModel(200,meeting);
        }else{
            return new BaseModel(400,"操作失败");
        }
    }

    @RequestMapping(value = "/queryList",method = RequestMethod.POST)
    @ResponseBody
    public BaseModel queryList(){
        List<Meeting> meeting = meethingService.queryList();
        if(meeting!=null){
            return new BaseModel(200,meeting);
        }else{
            return new BaseModel(400,"操作失败");
        }

    }

    @RequestMapping(value = "/byIdDelete",method = RequestMethod.POST)
    @ResponseBody
    public BaseModel byIdDelete(String id){
        Boolean flag = meethingService.byIdDelete(id);
        if(flag==true){
            return new BaseModel(200,"操作成功");
        }else{
            return new BaseModel(400,"操作失败");
        }

    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public BaseModel insertList(Map m){
        Meeting meeting = new Meeting();

        meeting.setDepartment((String) m.get("department"));
        meeting.setCustom((String) m.get("custom"));
        meeting.setID(m.get("ID"));
        meeting.setName((String) m.get("name"));
        meeting.setShould( m.get("should"));
        meeting.setReals( m.get("reals"));
        meeting.setLate( m.get("late"));
        meeting.setLeavs( m.get("leavs"));
        meeting.setAbsent( m.get("absent"));
        meeting.setOvertime( m.get("overtime"));
        meeting.setOuts( m.get("outs"));
        meeting.setBusinessout( m.get("businessout"));
        meeting.setTime( m.get("time"));
        meeting.setShSign( m.get("shSign"));
        meeting.setSign( m.get("sign"));
        meeting.setSignOut( m.get("signOut"));
        meeting.setNoSign( m.get("noSign"));
        meeting.setNoSignout( m.get("noSignout"));
        meeting.setLeaves( m.get("leaves"));
        meeting.setOfficialOut( m.get("officialOut"));
        meeting.setSickLeave( m.get("sickLeave"));
        meeting.setAffairLeave( m.get("affairLeave"));
        meeting.setHomeLeave( m.get("homeLeave"));
        meeting.setOrdinary( m.get("ordinary"));
        meeting.setWeekend( m.get("weekend"));
        meeting.setHoliday( m.get("holiday"));
        meeting.setAttendTime( m.get("attendTime"));
        meeting.setOrdinaryOvertime( m.get("ordinaryOvertime"));
        meeting.setWeekendOvertime( m.get("weekendOvertime"));
        meeting.setHolidayOvertime( m.get("holidayOvertime"));

//            System.out.println(meeting.toString());
        meethingService.insertList(meeting);

        List<Meeting> resMeeting = meethingService.byIdQuery((String) m.get("ID"));
        if(resMeeting!=null){
            return new BaseModel(200,resMeeting);
        }else{
            return new BaseModel(500,"添加失败");
        }
    }


    @RequestMapping(value = "/byIdChange",method = RequestMethod.POST)
    @ResponseBody
    public BaseModel byIdChange(Map m){
        Meeting meeting = new Meeting();

        meeting.setDepartment((String) m.get("department"));
        meeting.setCustom((String) m.get("custom"));
        meeting.setID(m.get("ID"));
        meeting.setName((String) m.get("name"));
        meeting.setShould( m.get("should"));
        meeting.setReals( m.get("reals"));
        meeting.setLate( m.get("late"));
        meeting.setLeavs( m.get("leavs"));
        meeting.setAbsent( m.get("absent"));
        meeting.setOvertime( m.get("overtime"));
        meeting.setOuts( m.get("outs"));
        meeting.setBusinessout( m.get("businessout"));
        meeting.setTime( m.get("time"));
        meeting.setShSign( m.get("shSign"));
        meeting.setSign( m.get("sign"));
        meeting.setSignOut( m.get("signOut"));
        meeting.setNoSign( m.get("noSign"));
        meeting.setNoSignout( m.get("noSignout"));
        meeting.setLeaves( m.get("leaves"));
        meeting.setOfficialOut( m.get("officialOut"));
        meeting.setSickLeave( m.get("sickLeave"));
        meeting.setAffairLeave( m.get("affairLeave"));
        meeting.setHomeLeave( m.get("homeLeave"));
        meeting.setOrdinary( m.get("ordinary"));
        meeting.setWeekend( m.get("weekend"));
        meeting.setHoliday( m.get("holiday"));
        meeting.setAttendTime( m.get("attendTime"));
        meeting.setOrdinaryOvertime( m.get("ordinaryOvertime"));
        meeting.setWeekendOvertime( m.get("weekendOvertime"));
        meeting.setHolidayOvertime( m.get("holidayOvertime"));

//            System.out.println(meeting.toString());
        meethingService.byIdChange(meeting);

        List<Meeting> resMeeting = meethingService.byIdQuery((String) m.get("ID"));
        if(resMeeting!=null){
            return new BaseModel(200,resMeeting);
        }else{
            return new BaseModel(500,"添加失败");
        }
    }


    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    @ResponseBody
    public BaseModel fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {

        //用来检测程序运行时间
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());
        System.out.println("fileName：" + file.getInputStream());

        InputStream in = file.getInputStream();
//        System.out.println(in);
//        try {
//            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
//            // 一次读一个字节
//            int tempbyte;
//            while ((tempbyte = in.read()) != -1) {
////                System.out.write(tempbyte);
//            }
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }

        ReadyExcel re = new ReadyExcel();
        Collection<Map> rs = re.inputSteamFile(in);
        for (Map m : rs) {
//            JSONObject item = JSONObject.parseObject(JSON.toJSONString(m));
//            System.out.println(item);

            Meeting meeting = new Meeting();

            meeting.setDepartment((String) m.get("department"));
            meeting.setCustom((String) m.get("custom"));
            meeting.setID(m.get("ID"));
            meeting.setName((String) m.get("name"));
            meeting.setShould( m.get("should"));
            meeting.setReals( m.get("reals"));
            meeting.setLate( m.get("late"));
            meeting.setLeavs( m.get("leavs"));
            meeting.setAbsent( m.get("absent"));
            meeting.setOvertime( m.get("overtime"));
            meeting.setOuts( m.get("outs"));
            meeting.setBusinessout( m.get("businessout"));
            meeting.setTime( m.get("time"));
            meeting.setShSign( m.get("shSign"));
            meeting.setSign( m.get("sign"));
            meeting.setSignOut( m.get("signOut"));
            meeting.setNoSign( m.get("noSign"));
            meeting.setNoSignout( m.get("noSignout"));
            meeting.setLeaves( m.get("leaves"));
            meeting.setOfficialOut( m.get("officialOut"));
            meeting.setSickLeave( m.get("sickLeave"));
            meeting.setAffairLeave( m.get("affairLeave"));
            meeting.setHomeLeave( m.get("homeLeave"));
            meeting.setOrdinary( m.get("ordinary"));
            meeting.setWeekend( m.get("weekend"));
            meeting.setHoliday( m.get("holiday"));
            meeting.setAttendTime( m.get("attendTime"));
            meeting.setOrdinaryOvertime( m.get("ordinaryOvertime"));
            meeting.setWeekendOvertime( m.get("weekendOvertime"));
            meeting.setHolidayOvertime( m.get("holidayOvertime"));

//            System.out.println(meeting.toString());
            meethingService.insertList(meeting);
        }
//        System.out.println(rs);

        return new BaseModel(200, rs);
    }





//    @Test
//    public void meetings() throws FileNotFoundException {
//
//        ReadyExcel re = new ReadyExcel();
//        Collection<Map> rs = re.importXlsx("data.xlsx");
//
////        System.out.println(rs);
//        for (Map m : rs) {
////            String item = JSON.toJSONString(m);
////            List<Meeting> meetingList = JSON.parseArray(item,Meeting.class);
////            System.out.println( "list:"+meetingList);
//
////            System.out.println(item);
//
////            System.out.println(m.get("ID"));
//
//            Meeting meeting = new Meeting();
//
//            meeting.setDepartment((String) m.get("department"));
//            meeting.setCustom((String) m.get("custom"));
//            meeting.setID(m.get("ID"));
//            meeting.setName((String) m.get("name"));
//            meeting.setShould( m.get("should"));
//            meeting.setReals( m.get("reals"));
//            meeting.setLate( m.get("late"));
//            meeting.setLeavs( m.get("leavs"));
//            meeting.setAbsent( m.get("absent"));
//            meeting.setOvertime( m.get("overtime"));
//            meeting.setOuts( m.get("outs"));
//            meeting.setBusinessout( m.get("businessout"));
//            meeting.setTime( m.get("time"));
//            meeting.setShSign( m.get("shSign"));
//            meeting.setSign( m.get("sign"));
//            meeting.setSignOut( m.get("signOut"));
//            meeting.setNoSign( m.get("noSign"));
//            meeting.setNoSignout( m.get("noSignout"));
//            meeting.setLeaves( m.get("leaves"));
//            meeting.setOfficialOut( m.get("officialOut"));
//            meeting.setSickLeave( m.get("sickLeave"));
//            meeting.setAffairLeave( m.get("affairLeave"));
//            meeting.setHomeLeave( m.get("homeLeave"));
//            meeting.setOrdinary( m.get("ordinary"));
//            meeting.setWeekend( m.get("weekend"));
//            meeting.setHoliday( m.get("holiday"));
//            meeting.setAttendTime( m.get("attendTime"));
//            meeting.setOrdinaryOvertime( m.get("ordinaryOvertime"));
//            meeting.setWeekendOvertime( m.get("weekendOvertime"));
//            meeting.setHolidayOvertime( m.get("holidayOvertime"));
//
////            System.out.println(meeting.toString());
//            meethingService.insertList(meeting);
//        }
//    }
}
