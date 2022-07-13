package com.wbs.chd_res.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 专门用来返回档口信息中的商品类别,对应前端中的goods的每一个good
 *
 * @author wbs
 * @create 2022-05-03 18:06
 */
@Data
public class ReFoodSort {
    private String name; //实际是分类名称
    private String icon; //类别前面的小标志，可有可无
    private List<DishInfo> dishInfoList;    //每个类别下的餐品

    public ReFoodSort(String name, String icon, List<DishInfo> dishInfoList){
        this.name=name;
        this.icon=icon;
        this.dishInfoList=dishInfoList;
    }
}
