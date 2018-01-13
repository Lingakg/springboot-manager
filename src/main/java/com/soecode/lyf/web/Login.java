package com.soecode.lyf.web;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.soecode.lyf.constant.BaseModel;
import com.soecode.lyf.entity.Admin;
import com.soecode.lyf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping(value = "/api")
public class Login {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    private BaseModel loginto(String adminName, String password) {
        BaseModel loginBM;
        Admin admin = adminService.queryAdmin(adminName);
        if (admin != null) {
            if (admin.getPassword().equals(password)) {
                loginBM = new BaseModel(200, "success");
            } else {
                loginBM =new  BaseModel(400, "密码错误");
            }
        } else {
            loginBM = new BaseModel(403, "用户未注册");
        }
        return loginBM;
    }
}

