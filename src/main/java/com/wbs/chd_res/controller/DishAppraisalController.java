package com.wbs.chd_res.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wbs.chd_res.pojo.*;
import com.wbs.chd_res.service.*;
import com.wbs.chd_res.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 19:12
 */
@RestController //前后端异步交互使用这个注解
@RequestMapping("/sms/dishAppraisalController")
public class DishAppraisalController {

    @Autowired
    private DishAppraisalService dishAppraisalService;
    @Autowired
    private DishInfoService dishInfoService;
    @Autowired
    private StallInfoService stallInfoService;
    @Autowired
    private RestaurantInfoService restaurantInfoService;
    @Autowired
    private OrderUserService orderUserService;
    @Autowired
    private OrderInfoService orderInfoService;

    @PostMapping("/rate")
    public Result rate(@RequestBody DishAppraisal dishAppraisal,HttpServletRequest request){

        Float dishRate= Float.valueOf(request.getParameter("dishRate"));
        Float stallRate= Float.valueOf(request.getParameter("stallRate"));
        Float resRate= Float.valueOf(request.getParameter("resRate"));
        Integer stallId= Integer.valueOf(request.getParameter("stallId"));
//        本订单中商品数量
        Integer count= Integer.valueOf(request.getParameter("count"));

        dishAppraisalService.save(dishAppraisal);

//        根据三个评分变化相应实体星级
//          拿到对应的商家信息
        StallInfo stall = stallInfoService.getById(stallId);
//          变化该商家的商家评价
        float oldStallRate = stall.getStallStar() * (stall.getAmount()-count);
        float newStallRate=(count*stallRate+oldStallRate)/stall.getAmount();
        stall.setStallStar(newStallRate);
        stallInfoService.updateById(stall);

//        变化对应的餐厅信息
        RestaurantInfo res = restaurantInfoService.getById(stall.getStallRestaurant());
        float oldResRate = res.getResStar() * (res.getResAmount() - count);
        float newResRate = (count * resRate + oldResRate) / res.getResAmount();
        res.setResStar(newResRate);
        restaurantInfoService.updateById(res);
        
//        更新商品的评分信息
//           获取该订单中的详情信息
        List<OrderInfo> orderInfos = orderInfoService.getOrderInfos(dishAppraisal.getDishId());
        Iterator<OrderInfo> iterator = orderInfos.iterator();
        while (iterator.hasNext()) {
            OrderInfo orderInfo = iterator.next();
//            获取订单详情中的商品信息
            DishInfo dish = dishInfoService.getDish(orderInfo.getOrderDish());
            float olddishRate = dish.getDishStar() * (dish.getDishSales() - orderInfo.getCount());
            float newDishRate = (orderInfo.getCount() * dishRate + olddishRate) / dish.getDishSales();
            dish.setDishStar(newDishRate);
            dishInfoService.updateById(dish);
        }

//        变化订单状态为1
        OrderUser orderUser = orderUserService.getById(dishAppraisal.getDishId());
        orderUser.setIsPay(1);
        orderUserService.updateById(orderUser);

        return Result.ok();
        }


    @GetMapping("/getRateByStall")
    public Result getRateByStall(HttpServletRequest request){
        Integer stallId= Integer.valueOf(request.getParameter("stallId"));
//        根据stallId查询olderUser
        QueryWrapper<OrderUser> orderUserQueryWrapper=new QueryWrapper<>();
        orderUserQueryWrapper.eq("stall_id", stallId);
        List<OrderUser> orderUsers = orderUserService.list(orderUserQueryWrapper);
//        返回使用的list
        List<DishAppraisal> appraisals=new ArrayList<>();
        Iterator<OrderUser> iterator = orderUsers.iterator();
        while (iterator.hasNext()) {
            OrderUser order = iterator.next();
//            根据订单id查询评论表
            QueryWrapper<DishAppraisal> dishAppraisalQueryWrapper=new QueryWrapper<>();
            dishAppraisalQueryWrapper.eq("dish_id", order.getOrderId());
            DishAppraisal appraisal = dishAppraisalService.getOne(dishAppraisalQueryWrapper);
            if(appraisal!=null){
                appraisals.add(appraisal);

            }
        }
        return Result.ok(appraisals);
    }
}
