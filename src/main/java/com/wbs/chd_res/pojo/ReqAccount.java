package com.wbs.chd_res.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接收余额扣款请求实体类
 * @author wbs
 * @create 2022-05-28 22:19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReqAccount {
    private Integer userId;
    private Double orderAmount;
}
