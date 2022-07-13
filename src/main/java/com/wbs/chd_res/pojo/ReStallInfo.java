package com.wbs.chd_res.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 专门用来返回商家信息的对象
 *
 * @author wbs
 * @create 2022-05-03 14:33
 */
@Data
@NoArgsConstructor
public class ReStallInfo {
    private Map<String,StallInfo> stallInfo=new LinkedHashMap<>();    //店铺信息
    private Map<String,List<ReFoodSort>> dishInfo=new LinkedHashMap<>();  //餐品信息

    public ReStallInfo(StallInfo stallInfo,List<ReFoodSort> dishInfo){
        this.stallInfo.put("stallInfo", stallInfo);
        this.dishInfo.put("dishInfo", dishInfo);
    }
}
