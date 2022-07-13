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
 * @create 2022-05-02 19:17
 */
@RestController //前后端异步交互使用这个注解
@RequestMapping("/sms/orderUserController")
public class OrderUserController {
    @Autowired
    private OrderUserService orderUserService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private DishInfoService dishInfoService;
    @Autowired
    private StallInfoService stallInfoService;
    @Autowired
    private RestaurantInfoService restaurantInfoService;
    @Autowired
    private UserInfoService userInfoService;

//    根据用户获取订单列表
    @PostMapping("/getOrders")
    public Result getOrders(@RequestBody NowUser theUser){
        Integer userId=theUser.getUserId();
        Map<String,Object> map=new LinkedHashMap<>();
//        创建一个空的返回订单信息实体类List
        List<ReOrder> reOrders=new ArrayList<>();
//        获取orderUser列表
        List<OrderUser> orders = orderUserService.getOrders(userId);
//        根据orderUser列表查询orderInfo表
        Iterator<OrderUser> iterator=orders.iterator();
        while(iterator.hasNext()){
            OrderUser nextOrder = iterator.next();
            List<OrderInfo> orderInfos = orderInfoService.getOrderInfos(nextOrder.getOrderId());
            reOrders.add(new ReOrder(nextOrder.getIsPay(), nextOrder.getOrderAmount(), nextOrder.getOrderId(),
                    nextOrder.getOrderTime(), nextOrder.getUserId(), nextOrder.getStallId(), orderInfos));
        }
        map.put("orders", reOrders);
        return Result.ok(map);
    }

    //    根据用户获取订单详情列表
    @PostMapping("/getOrderInfos")
    public Result getOrderInfos(@RequestBody NowUser theUser){
        Integer userId=theUser.getUserId();
        Map<String,Object> map=new LinkedHashMap<>();
//        获取列表
        List<OrderInfo> orderInfos = orderInfoService.getOrderInfos(userId);
        map.put("orderInfos", orderInfos);
        return Result.ok(map);
    }

    //    生成未支付的订单
    @PostMapping("/createOrder")
    public Result createOrder(@RequestBody NewOrder newOrder){
//        先填充OrderUser表，存放订单号等信息
//        默认订单状态为待支付
        BaseMapper<OrderUser> orderUserBaseMapper = orderUserService.getBaseMapper();
        orderUserBaseMapper.insert(new OrderUser(newOrder.getOrderId(), newOrder.getUserId(),
                newOrder.getOrderAmount(), newOrder.getStallInfo().getStallId(),
                2, 0, newOrder.getOrderTime()));
//        再填充OrderInfo表，存放订单中的多个菜品
        Iterator<NewOrderDishInfo> iterator=newOrder.getOrderDishs().iterator();
        while(iterator.hasNext()){
            NewOrderDishInfo dishInfo= iterator.next();
            orderInfoService.myInsert(newOrder.getOrderId(),
                    dishInfo.getDishId(),dishInfo.getCount());
        }
//        返回
        return Result.ok();
    }

//    支付订单
    @PostMapping("/pay")
    public Result payOrder(@RequestBody NowOrder theOrder){
//        先根据订单号将订单信息查询出来
        OrderUser nowOrder = orderUserService.getNowOrder(theOrder.getOrderId());
//        订单更新为待取餐状态
        nowOrder.setIsPay(3);
//        根据订单号更新订单支付信息
        orderUserService.updateById(nowOrder);
//        根据变更的订单信息更新菜品销量，档口销量，餐厅销量，用户余额等信息
//        查询得到订单对应的商家
        QueryWrapper<StallInfo> stallInfoQueryWrapper=new QueryWrapper<>();
        stallInfoQueryWrapper.eq(("stall_id"), nowOrder.getStallId());
        StallInfo stall = stallInfoService.getOne(stallInfoQueryWrapper);
//        更新商家销售额
        stall.setStallAccount(nowOrder.getOrderAmount()+stall.getStallAccount());
//        查询得到该订单对应的餐厅信息
        QueryWrapper<RestaurantInfo> restaurantInfoQueryWrapper=new QueryWrapper<>();
        restaurantInfoQueryWrapper.eq("res_id", stall.getStallRestaurant());
        RestaurantInfo restaurant = restaurantInfoService.getOne(restaurantInfoQueryWrapper);
//        更新餐厅销售额
        restaurant.setResAccount(restaurant.getResAccount()+nowOrder.getOrderAmount());
//            现根据订单id查询订单详情，由订单详情中的商品id查询商品信息表
        List<OrderInfo> orderInfos = orderInfoService.getOrderInfos(nowOrder.getOrderId());
        Iterator<OrderInfo> iterator=orderInfos.iterator();
        while(iterator.hasNext()){
            OrderInfo orderInfo= iterator.next();
//            根据订单详情中的商品id查询菜品表
            QueryWrapper<DishInfo> dishInfoQueryWrapper=new QueryWrapper<>();
            dishInfoQueryWrapper.eq("dish_id", orderInfo.getOrderDish());
            DishInfo dish = dishInfoService.getOne(dishInfoQueryWrapper);
//            更新菜品销量
            dish.setDishSales(orderInfo.getCount()+dish.getDishSales());
            dishInfoService.updateById(dish);
//            根据订单用户实体类中的商家id更新档口销量
            stall.setAmount(stall.getAmount()+orderInfo.getCount());
            stallInfoService.updateById(stall);
//            更新餐厅销量
            restaurant.setResAmount(restaurant.getResAmount()+orderInfo.getCount());
            restaurantInfoService.updateById(restaurant);
        }
        return Result.ok();
    }

//    余额扣款请求
    @PostMapping("/consumeAccount")
    public Result consumeAccount(@RequestBody ReqAccount reqAccount){
        QueryWrapper<UserInfo> userInfoQueryWrapper=new QueryWrapper<>();
        userInfoQueryWrapper.eq("user_id", reqAccount.getUserId());
        UserInfo user = userInfoService.getOne(userInfoQueryWrapper);
        user.setUserAccount((float) (user.getUserAccount()-reqAccount.getOrderAmount()));
        userInfoService.updateById(user);
        return Result.ok();
    }

//    根据订单id删除订单
    @PostMapping("/deleteOrder")
    public Result deleteOrder(@RequestBody NowOrder theOrder){
//        按照订单号删除订单用户表
        int count1= orderUserService.deleteOrder(theOrder);
//        按照订单号删除订单详情表
        int count2= orderInfoService.deleteOrders(theOrder);

        if(count1==1&&count2>1){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

//    取消订单请求
    @PostMapping("/cancelOrder")
    public Result cancelOrder(@RequestBody NowOrder theOrder){
//        根据订单号查询后台并设置订单状态为5
        Boolean isOk=orderUserService.updateIsPay(theOrder.getOrderId(),5);

        if(isOk){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

//    后台扫取餐码以完成取餐操作
    @GetMapping("/pick")
    public Result pickOrder(HttpServletRequest request){
        Integer orderId= Integer.valueOf(request.getParameter("id"));
//        修改订单状态为1
        Boolean isOk=orderUserService.updateIsPay(orderId, 4);
        return Result.ok("取餐成功");
    }
}
