package com.wbs.chd_res.controller;
import com.wbs.chd_res.pojo.*;
import com.wbs.chd_res.service.*;
import com.wbs.chd_res.util.JwtHelper;
import com.wbs.chd_res.util.Result;
import com.wbs.chd_res.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 存放非针对数据库进行增删改查的操作
 *
 * @author wbs
 * @create 2022-05-02 20:02
 */
@RestController //前后端异步交互使用这个注解
@RequestMapping("/sms/system")
public class SystemController {

    @Autowired
    private TopAdminInfoService topAdminInfoService;
    @Autowired
    private SuperAdminInfoService superAdminInfoService;
    @Autowired
    private SecondaryAdminInfoService secondaryAdminInfoService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private DishInfoService dishInfoService;
    @Autowired
    private StallInfoService stallInfoService;

//    登录方法，@requestBody可以帮助转换成LoginForm对象
    @PostMapping("/userlogin")
    public Result userLogin(@RequestBody LoginForm loginForm,HttpServletRequest request){
//        进行账号密码校验
//        准备一个map用于存放相应的数据
        Map<String,Object> map=new LinkedHashMap<>();
        try {
            UserInfo userInfo= userInfoService.login(loginForm);
            if (null!=userInfo) {
                map.put("info", userInfo);
            }else {
                throw new RuntimeException("用户名或密码有误");
            }
            return Result.ok(map);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.fail().message("无此用户");
        }
    }

//    后台登录
    @PostMapping("/manageLogin")
    public Result login(@RequestBody ManageLoginForm loginForm){
//        进行账号密码校验
//        准备一个map用于存放相应的数据
        Map<String,Object> map=new LinkedHashMap<>();
        switch (loginForm.getManageClass()){
//            1:商家管理员，2：餐厅管理员，3：超级管理员
            case 3:
                try {
                    SuperAdminInfo superAdminInfo= superAdminInfoService.login(new LoginForm(loginForm.getName(),loginForm.getPwd()));
                    if (null!=superAdminInfo) {
                        map.put("userInfo", superAdminInfo);
                        return Result.ok(map);
                    }else {
                        return Result.fail();
                    }
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
            case 2:
                try {
                    TopAdminInfo topAdminInfo= topAdminInfoService.login(new LoginForm(loginForm.getName(),loginForm.getPwd()));
                    if (null!=topAdminInfo) {
                        map.put("userInfo", topAdminInfo);
                        return Result.ok(map);
                    }else {
                        return Result.fail();
                    }
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
            case 1:
                try {
                    SecondaryAdminInfo secAdminInfo= secondaryAdminInfoService.login(new LoginForm(loginForm.getName(),loginForm.getPwd()));
                    if (null!=secAdminInfo) {
                        map.put("userInfo", secAdminInfo);
                        return Result.ok(map);
                    }else {
                        return Result.fail();
                    }
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }

        }
        return Result.fail().message("无此用户");

    }

    //     登陆后返回信息的方法
    @GetMapping("/getInfo")
    public Result getInfoByToken(@RequestHeader("token") String token) {
        // 获取用户中请求的token
        // 检查token 是否过期 20H
        boolean isEx = JwtHelper.isExpiration(token);
        if (isEx) {
            return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
        }
        // 解析token,获取用户id和用户类型
        Long userId =JwtHelper.getUserId(token);
        Integer  userType =JwtHelper.getUserType(token);
        // 准备一个Map集合用于存响应的数据
        Map<String,Object> map=new LinkedHashMap<>();
        switch (userType){
            case 1:
                SuperAdminInfo superAdminInfo = superAdminInfoService.getSuperAdminById(userId);
                map.put("userType",1);
                map.put("user",superAdminInfo);
                break;
            case 2:
                TopAdminInfo topAdminInfo = topAdminInfoService.getTopAdminById(userId);
                map.put("userType",2);
                map.put("user",topAdminInfo);
                break;
            case 3:
                SecondaryAdminInfo secAdminInfo = secondaryAdminInfoService.getSecondaryAdminById(userId);
                map.put("userType",3);
                map.put("user",secAdminInfo);
                break;
        }
        return Result.ok(map);
    }

    //测试的hhh方法
    @GetMapping("/hhh")
    public Result hhh(){
        return  Result.ok();
    }

//    商品图标上传
    @PostMapping("/uploadGoodIcon")
    public Result uploadGoodIcon(HttpServletRequest request, MultipartFile file){
        Integer dishId = Integer.valueOf(request.getParameter("dishId"));
        //判断文件类型
        String pType=file.getContentType();
        pType=pType.substring(pType.indexOf("/")+1);
        if("jpeg".equals(pType)){
            pType="jpg";
        }
        //绝对路径
        String path="C:\\Users\\28615\\Desktop\\chd_res\\src\\main\\resources\\static\\images\\dishIcon\\dishId"+dishId+"."+pType;
        try{
//            将图片保存到后端服务器
            file.transferTo(new File(path));
            //文件路径保存到数据库中
            DishInfo dish = dishInfoService.getDish(dishId);
            dish.setDishIcon(path.substring(path.indexOf("images")));
            boolean b = dishInfoService.updateById(dish);
            if(b){
                return Result.ok();
            }else{
                return Result.fail();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.ok();
    }

//    商品详情图片上传
    @PostMapping("/uploadGoodPic")
    public Result uploadGoodPic(HttpServletRequest request, MultipartFile file){
        Integer dishId = Integer.valueOf(request.getParameter("dishId"));
        //判断文件类型
        String pType=file.getContentType();
        pType=pType.substring(pType.indexOf("/")+1);
        if("jpeg".equals(pType)){
            pType="jpg";
        }
        //绝对路径
        String path="C:\\Users\\28615\\Desktop\\chd_res\\src\\main\\resources\\static\\images\\dishPic\\dishId"+dishId+"."+pType;
        try{
//            将图片保存到后端服务器
            file.transferTo(new File(path));
            //文件路径保存到数据库中
            DishInfo dish = dishInfoService.getDish(dishId);
            dish.setDishPicture1(path.substring(path.indexOf("images")));
            boolean b = dishInfoService.updateById(dish);
            if(b){
                return Result.ok();
            }else{
                return Result.fail();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.ok();
    }

    //    商家图标上传
    @PostMapping("/uploadStallIcon")
    public Result uploadStallIcon(HttpServletRequest request, MultipartFile file){
        Integer stallId = Integer.valueOf(request.getParameter("stallId"));
        //判断文件类型
        String pType=file.getContentType();
        pType=pType.substring(pType.indexOf("/")+1);
        if("jpeg".equals(pType)){
            pType="jpg";
        }
        //绝对路径
        String path="C:\\Users\\28615\\Desktop\\chd_res\\src\\main\\resources\\static\\images\\stallIcon\\stallId"+stallId+"."+pType;
        try{
//            将图片保存到后端服务器
            file.transferTo(new File(path));
            //文件路径保存到数据库中
            StallInfo stall = stallInfoService.getById(stallId);
            stall.setStallIcon(path.substring(path.indexOf("images")));
            boolean b = stallInfoService.updateById(stall);
            if(b){
                return Result.ok();
            }else{
                return Result.fail();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.ok();
    }

    //    商家详情图片上传
    @PostMapping("/uploadStallPic")
    public Result uploadStallPic(HttpServletRequest request, MultipartFile file){
        Integer stallId = Integer.valueOf(request.getParameter("stallId"));
        //判断文件类型
        String pType=file.getContentType();
        pType=pType.substring(pType.indexOf("/")+1);
        if("jpeg".equals(pType)){
            pType="jpg";
        }
        //绝对路径
        String path="C:\\Users\\28615\\Desktop\\chd_res\\src\\main\\resources\\static\\images\\stallPic\\stallId"+stallId+"."+pType;
        try{
//            将图片保存到后端服务器
            file.transferTo(new File(path));
            //文件路径保存到数据库中
            StallInfo stall = stallInfoService.getById(stallId);
            stall.setStallPicture1(path.substring(path.indexOf("images")));
            boolean b = stallInfoService.updateById(stall);
            if(b){
                return Result.ok();
            }else{
                return Result.fail();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.ok();
    }
}


