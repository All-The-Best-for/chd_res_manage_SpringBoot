package com.wbs.chd_res.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wbs.chd_res.mapper.StallDishMapper;
import com.wbs.chd_res.pojo.AcGoods;
import com.wbs.chd_res.pojo.DishInfo;
import com.wbs.chd_res.pojo.StallDish;
import com.wbs.chd_res.service.DishInfoService;
import com.wbs.chd_res.service.StallDishService;
import com.wbs.chd_res.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wbs
 * @create 2022-05-02 19:17
 */
@RestController //前后端异步交互使用这个注解
@RequestMapping("/sms/dishInfoController")
public class DishInfoController {
    @Autowired
    private DishInfoService dishInfoService;
    @Autowired
    private StallDishService stallDishService;


//    修改商品的请求函数
    @PostMapping("/changeGoodBase")
    public Result changeGoodBase(@RequestBody DishInfo dishInfo){
        DishInfo oldDish = dishInfoService.getDish(dishInfo.getDishId());
        dishInfo.setOldPrice(oldDish.getDishPrice());
        boolean b = dishInfoService.updateById(dishInfo);
        if(b){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

//    提交商品的请求函数
    @PostMapping("/addGoodBase")
    public Result addGoodBase(@RequestBody DishInfo dishInfo, HttpServletRequest request){
//        获取stallId
        Integer stallId= Integer.valueOf(request.getParameter("stallId"));
//        将商品信息插入商品表
        BaseMapper<DishInfo> dishInfoBaseMapper=dishInfoService.getBaseMapper();
        int insert = dishInfoBaseMapper.insert(dishInfo);
//        查询新插入的信息，获取自动递增的id返回
        QueryWrapper<DishInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("dish_name", dishInfo.getDishName());
        DishInfo newDish = dishInfoService.getOne(queryWrapper);
//        将商品与商家关系插入商家菜谱表
        BaseMapper<StallDish> stallDishBaseMapper = stallDishService.getBaseMapper();
        stallDishBaseMapper.insert(new StallDish(stallId, newDish.getDishId(), 1, 1, 1000));
        return Result.ok(newDish.getDishId());
    }

//    删除商品列表中的商品信息
    @PostMapping("/deleteGoods")
    public Result deleteGoods(@RequestBody AcGoods acGoods){

        String[] goodList = acGoods.getGoodList();
        for (String goodIdStr:goodList) {
            Integer goodId= Integer.valueOf(goodIdStr);
            dishInfoService.removeById(goodId);
//            从食谱表中移除信息
            QueryWrapper<StallDish> stallDishQueryWrapper=new QueryWrapper<>();
            stallDishQueryWrapper.eq("dish_id", goodId);
            stallDishService.remove(stallDishQueryWrapper);
        }

        return Result.ok();

    }
}
