package com.wbs.chd_res.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wbs.chd_res.pojo.*;
import com.wbs.chd_res.service.UserInfoService;
import com.wbs.chd_res.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 20:00
 */
@RestController //前后端异步交互使用这个注解
@RequestMapping("/sms/userInfoController")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getUsers")
    public Result getUsers(){
        List<UserInfo> userInfos = userInfoService.list();
        return Result.ok(userInfos);
    }

    @GetMapping("/changeUserPhone")
    public Result changeUserPhone(HttpServletRequest request){
        String userPhone= request.getParameter("userPhone");
        Integer userId= Integer.valueOf(request.getParameter("userId"));

        UserInfo user = userInfoService.getById(userId);
        user.setUserPhone(userPhone);
        userInfoService.updateById(user);
        return Result.ok();
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserInfo aUser){
        BaseMapper<UserInfo> userInfoBaseMapper = userInfoService.getBaseMapper();
        userInfoBaseMapper.insert(aUser);
        return Result.ok();
    }

    @PostMapping("/addUsers")
    public Result addUsers(@RequestBody AcUserList userList){

        BaseMapper<UserInfo> userInfoBaseMapper = userInfoService.getBaseMapper();
        Iterator<UserInfo> iterator = userList.getUserList().iterator();
        while (iterator.hasNext()) {
            UserInfo user = iterator.next();
            userInfoBaseMapper.insert(user);
        }
        return Result.ok();
    }

    @PostMapping("/deleteUsers")
    public Result deleteUsers(@RequestBody AcUsers acUsers){
        String[] userList = acUsers.getUserList();
        for (String userStr:userList) {
            Integer userId = Integer.valueOf(userStr);
            userInfoService.removeById(userId);
        }
        return Result.ok();
    }

    @GetMapping("/recharge")
    public Result recharge(HttpServletRequest request){
        Integer userId= Integer.valueOf(request.getParameter("userId"));
        Integer rechargeNum= Integer.valueOf(request.getParameter("rechargeNum"));

        UserInfo user = userInfoService.getById(userId);
        user.setUserAccount(user.getUserAccount()+rechargeNum);
        userInfoService.updateById(user);
        return Result.ok();
    }
}
