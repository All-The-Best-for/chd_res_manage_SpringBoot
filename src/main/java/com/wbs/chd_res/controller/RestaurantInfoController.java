package com.wbs.chd_res.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wbs.chd_res.pojo.AcRess;
import com.wbs.chd_res.pojo.RestaurantAdmin;
import com.wbs.chd_res.pojo.RestaurantInfo;
import com.wbs.chd_res.pojo.TopAdminInfo;
import com.wbs.chd_res.service.RestaurantAdminService;
import com.wbs.chd_res.service.RestaurantInfoService;
import com.wbs.chd_res.service.TopAdminInfoService;
import com.wbs.chd_res.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 19:55
 */
@RestController //前后端异步交互使用这个注解
@RequestMapping("/sms/restaurantInfoController")
public class RestaurantInfoController {
    @Autowired
    private RestaurantInfoService restaurantInfoService;
    @Autowired
    private TopAdminInfoService topAdminInfoService;
    @Autowired
    private RestaurantAdminService restaurantAdminService;

    @GetMapping("/getRess")
    public Result getRess(){
        List<RestaurantInfo> restaurantInfos = restaurantInfoService.list();
        return Result.ok(restaurantInfos);
    }

    @PostMapping("/addRes")
    public Result addRes(@RequestBody RestaurantInfo aRes, HttpServletRequest request){
        String newTopName= request.getParameter("newTopName");
//        将信息存入resInfo表
        restaurantInfoService.save(aRes);
//        读取新存入的信息
        QueryWrapper<RestaurantInfo> restaurantInfoQueryWrapper=new QueryWrapper<>();
        restaurantInfoQueryWrapper.eq("res_name", aRes.getResName());
        RestaurantInfo newRes = restaurantInfoService.getOne(restaurantInfoQueryWrapper);
//        将管理员信息存储到topAdminInfo表
        topAdminInfoService.save(new TopAdminInfo(0, newTopName, newTopName, "男", "19829263229", "123", "", ""));
//        将新存入的管理员信息读出
        QueryWrapper<TopAdminInfo> topAdminInfoQueryWrapper=new QueryWrapper<>();
        topAdminInfoQueryWrapper.eq("top_admin_name", newTopName);
        TopAdminInfo newTopAdmin = topAdminInfoService.getOne(topAdminInfoQueryWrapper);
//        将管理关系存入res--admin表
        restaurantAdminService.save(new RestaurantAdmin(newRes.getResId(), newTopAdmin.getTopAdminId()));
        return Result.ok();
    }

    @GetMapping("/cahngeResName")
    public Result cahngeResName(HttpServletRequest request){
        String newResName= request.getParameter("newResName");
        Integer resId= Integer.valueOf(request.getParameter("resId"));

        RestaurantInfo oldRes = restaurantInfoService.getById(resId);
        oldRes.setResName(newResName);

        restaurantInfoService.updateById(oldRes);

        return Result.ok();
    }

    @PostMapping("/deleteRess")
    public Result deleteRess(@RequestBody AcRess acRess){
        String[] resList = acRess.getResList();
        for (String resStr:resList
             ) {
            Integer resId= Integer.valueOf(resStr);
//            删除餐厅信息要删除与之相关的管理员、餐厅-管理员关系
            restaurantInfoService.removeById(resId);
            QueryWrapper<RestaurantAdmin> restaurantAdminQueryWrapper=new QueryWrapper<>();
            restaurantAdminQueryWrapper.eq("restaurant_id", resId);
            RestaurantAdmin oldResAdmin = restaurantAdminService.getOne(restaurantAdminQueryWrapper);
            restaurantAdminService.remove(restaurantAdminQueryWrapper);
            QueryWrapper<TopAdminInfo> topAdminInfoQueryWrapper=new QueryWrapper<>();
            topAdminInfoQueryWrapper.eq("top_admin_id", oldResAdmin.getTopAdminId());
            topAdminInfoService.remove(topAdminInfoQueryWrapper);
//            topAdminInfoService.removeById(oldResAdmin.getTopAdminId());
        }
        return Result.ok();
    }
}
