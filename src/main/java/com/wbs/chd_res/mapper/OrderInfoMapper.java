package com.wbs.chd_res.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wbs.chd_res.pojo.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 17:46
 */
@Repository
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    @Select("INSERT INTO order_info (order_id,order_dish,count)  VALUES  (#{order_id},#{order_dish},#{count})")
    List<String> myInsert(
            @Param("order_id") Integer order_id,
            @Param("order_dish") Integer order_dish,
            @Param("count") Integer count);
}
