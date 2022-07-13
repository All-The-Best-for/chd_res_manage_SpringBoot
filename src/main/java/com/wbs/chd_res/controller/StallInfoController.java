package com.wbs.chd_res.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wbs.chd_res.pojo.*;
import com.wbs.chd_res.service.*;
import com.wbs.chd_res.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author wbs
 * @create 2022-05-02 19:57
 */
@RestController //前后端异步交互使用这个注解
@RequestMapping("/sms/stallInfolController")
public class StallInfoController {

    @Autowired
    private StallInfoService stallInfoService;
    @Autowired
    private DishInfoService dishInfoService;
    @Autowired
    private StallDishService stallDishService;
    @Autowired
    private StallAdminService stallAdminService;
    @Autowired
    private OrderUserService orderUserService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private RestaurantAdminService restaurantAdminService;
    @Autowired
    private RestaurantInfoService restaurantInfoService;
    @Autowired
    private TopAdminInfoService topAdminInfoService;
    @Autowired
    private SecondaryAdminInfoService secondaryAdminInfoService;

//    获取档口列表
    @GetMapping("/getStalls")
    public Result getStalls(){
        Map<String,Object> map=new LinkedHashMap<>();
//        获取stall列表
        List<StallInfo> stallInfos=stallInfoService.getStalls();
//        遍历stall列表，根据其中的stall_id查询对应的dish信息
        Iterator<StallInfo> iterator = stallInfos.iterator();
        ArrayList<ReStallInfo> reStallInfo = new ArrayList<>();
        while (iterator.hasNext()) {
            StallInfo stall = iterator.next();
            List<StallDish> stallDishes= stallDishService.getDishByDishIds(stall.getStallId());
//            创建ReFoodSort列表
            List<ReFoodSort> reFoodSorts=new ArrayList<>();
            for (StallDish stallDish:stallDishes) {
//                根据对应表查出某个档口对应的餐品表
                DishInfo dishInfo=dishInfoService.getDish(stallDish.getDishId());

//                将查询到的每一个餐品放到ReFoodSort中
                List<String> dishSortNames=dishInfoService.getSortName(stall.getStallId());
                Iterator<String> iterator2 = dishSortNames.iterator();
                while(iterator2.hasNext()){
                    String next = iterator2.next();
                    ReFoodSort reFoodSort = new ReFoodSort(next, null, new ArrayList<>());
                    List<DishInfo> dishInfosBySort=dishInfoService.getGoods(next);
                    reFoodSort.getDishInfoList().addAll(dishInfosBySort);
                    reFoodSorts.add(reFoodSort);
                }
            }
//                生成返回商家信息对象
            reStallInfo.add(new ReStallInfo(stall, reFoodSorts));
        }
        map.put("stall", reStallInfo);
        return Result.ok(map);
    }

//    根据商家管理员id获取商家信息（包括商品信息、订单信息、商家基本信息）
    @GetMapping("/getStall")
    public Result getStall(HttpServletRequest request){
        Integer manageId= Integer.valueOf(request.getParameter("manageId"));
        Map<String,Object> map=new LinkedHashMap<>();

//        先查询商家-管理员表，获取与管理员对应的商家id
        QueryWrapper<StallAdmin> stallAdminQueryWrapper=new QueryWrapper<>();
        stallAdminQueryWrapper.eq("secondary_admin_id", manageId);
        StallAdmin stallAdminOne = stallAdminService.getOne(stallAdminQueryWrapper);


//        查询商家信息表，获取商家信息，将其加入返回map
        QueryWrapper<StallInfo> stallInfoQueryWrapper=new QueryWrapper<>();
        stallInfoQueryWrapper.eq("stall_id", stallAdminOne.getStallId());
        StallInfo stallInfoOne = stallInfoService.getOne(stallInfoQueryWrapper);
        map.put("stallInfo", stallInfoOne);


//        查询商家菜谱表，获取商家对应的商品信息，并加入map
        List<StallDish> stallDishes= stallDishService.getDishByDishIds(stallInfoOne.getStallId());
//            创建ReFoodSort列表
        List<ReFoodSort> reFoodSorts=new ArrayList<>();
        for (StallDish stallDish:stallDishes) {
//                将查询到的每一个餐品放到ReFoodSort中
            List<String> dishSortNames=dishInfoService.getSortName(stallInfoOne.getStallId());
            Iterator<String> iterator2 = dishSortNames.iterator();
            while(iterator2.hasNext()){
                String next = iterator2.next();
                ReFoodSort reFoodSort = new ReFoodSort(next, null, new ArrayList<>());
                List<DishInfo> dishInfosBySort=dishInfoService.getGoods(next);
                reFoodSort.getDishInfoList().addAll(dishInfosBySort);
                reFoodSorts.add(reFoodSort);
            }
        }
        map.put("goods", reFoodSorts);
//        查询订单表，获取商家对应的所有订单信息，并加入map
//          获取订单用户信息，根据商家id获取订单用户list
        BaseMapper<OrderUser> orderUserBaseMapper = orderUserService.getBaseMapper();
        QueryWrapper<OrderUser> orderUserQueryWrapper=new QueryWrapper<>();
        orderUserQueryWrapper.eq("stall_id", stallInfoOne.getStallId());
        List<OrderUser> orderUserList = orderUserBaseMapper.selectList(orderUserQueryWrapper);
//          创建一个空的返回订单信息实体类List
        List<ReOrder> reOrders=new ArrayList<>();
//          遍历订单用户list，根据其中订单号查询订单详情表得到订单详情列表
        for (OrderUser orderUser:orderUserList) {
            List<OrderInfo> orderInfos = orderInfoService.getOrderInfos(orderUser.getOrderId());
            reOrders.add(new ReOrder(orderUser.getIsPay(), orderUser.getOrderAmount(),
                    orderUser.getOrderId(), orderUser.getOrderTime(), orderUser.getUserId(),
                    orderUser.getStallId(), orderInfos));
        }
        map.put("orders", reOrders);

//        查询订单评论表，获取商家对应的评论信息，并加入map

        return Result.ok(map);
    }

//    修改商家基本信息
    @PostMapping("/changeStallBase")
    public Result changeStallBase(@RequestBody StallInfo aStallInfo){
        StallInfo oldstallInfo = stallInfoService.getById(aStallInfo.getStallId());
        oldstallInfo.setStallName(aStallInfo.getStallName());
        oldstallInfo.setStallText(aStallInfo.getStallText());
        stallInfoService.updateById(oldstallInfo);
        return Result.ok();
    }

//    根据餐厅管理员id获取其对应的餐厅的下辖商家列表
    @GetMapping("/getStallsByRes")
    public Result getStallsByRes(HttpServletRequest request){
        Integer manageId= Integer.valueOf(request.getParameter("manageId"));
        Map<String,Object> map=new LinkedHashMap<>(); //存放两个内容，一是该管理员对应的餐厅信息。二是餐厅下辖的商家id数组
//        根据餐厅管理员id查找res—admin表，查找其管理的餐厅id
        QueryWrapper<RestaurantAdmin> restaurantAdminQueryWrapper=new QueryWrapper<>();
        restaurantAdminQueryWrapper.eq("top_admin_id", manageId);
        RestaurantAdmin restaurantAdmin = restaurantAdminService.getOne(restaurantAdminQueryWrapper);
//        查询resInfo表，获取对应的餐厅信息
        RestaurantInfo res = restaurantInfoService.getById(restaurantAdmin.getRestaurantId());
        map.put("res", res);
//        根据餐厅id查询stallInfo表，查找对应的商家，将商家id组成的数组返回
        QueryWrapper<StallInfo> stallInfoQueryWrapper=new QueryWrapper<>();
        stallInfoQueryWrapper.eq("stall_restaurant", res.getResId());
        List<StallInfo> stallInfos = stallInfoService.list(stallInfoQueryWrapper);
        List<Integer> stallIds=new ArrayList<>();
        for (StallInfo stall:stallInfos
             ) {
            stallIds.add(stall.getStallId());
        }
        map.put("stalls", stallIds);
        return Result.ok(map);
    }

//    更改商家营业状态
    @GetMapping("/changeStallWork")
    public  Result changeStallWork(HttpServletRequest request){
        Integer stallId = Integer.valueOf(request.getParameter("stallId"));
        StallInfo stallInfo = stallInfoService.getById(stallId);
        if(stallInfo.getIsWork()==1){
            stallInfo.setIsWork(0);
        }else{
            stallInfo.setIsWork(1);
        }
        stallInfoService.updateById(stallInfo);
        return Result.ok();
    }

//    添加一个商家信息
    @PostMapping("/addStallBase")
    public Result addStallBase(@RequestBody StallInfo aStallInfo,HttpServletRequest request){
        String newSecName = request.getParameter("newSecName");
        stallInfoService.save(aStallInfo);
        QueryWrapper<StallInfo> stallInfoQueryWrapper=new QueryWrapper<>();
        stallInfoQueryWrapper.eq("stall_name", aStallInfo.getStallName());
        StallInfo newStall = stallInfoService.getOne(stallInfoQueryWrapper);
        secondaryAdminInfoService.save(new SecondaryAdminInfo(0, newSecName, newSecName, "男", "19829263229", "123", "", ""));
        QueryWrapper<SecondaryAdminInfo> secondaryAdminInfoQueryWrapper=new QueryWrapper<>();
        secondaryAdminInfoQueryWrapper.eq("secondary_admin_name", newSecName);
        SecondaryAdminInfo newSecAdmin = secondaryAdminInfoService.getOne(secondaryAdminInfoQueryWrapper);
        stallAdminService.save(new StallAdmin(newStall.getStallId(), newSecAdmin.getSecondaryAdminId()));
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("newStallId", newStall.getStallId());
        map.put("newStallAdmin", newSecAdmin.getSecondaryAdminName());
        return Result.ok(map);
    }

//    删除商家列表中的商家
    @PostMapping("/deleteStalls")
    public Result deleteStalls(@RequestBody AcStalls acStalls){
        String[] stallList = acStalls.getStallList();
        for (String stallStr:stallList) {
            Integer stallId= Integer.valueOf(stallStr);
            StallInfo stallInfo = stallInfoService.getById(stallId);
//            删除stallInfo表中的信息
            stallInfoService.removeById(stallId);
//            删除与之关联的管理员信息
            QueryWrapper<StallAdmin> stallAdminQueryWrapper=new QueryWrapper<>();
            stallAdminQueryWrapper.eq("stall_id", stallId);
            StallAdmin one = stallAdminService.getOne(stallAdminQueryWrapper);
            stallAdminService.remove(stallAdminQueryWrapper);
            SecondaryAdminInfo secondaryAdminById = secondaryAdminInfoService.getSecondaryAdminById(Long.valueOf(one.getSecondaryAdminId()));
            secondaryAdminInfoService.removeById(secondaryAdminById.getSecondaryAdminId());
//            删除与之关联的商品

//            还应该对与之相关联的订单进行处理
        }

        return Result.ok();
    }
}

