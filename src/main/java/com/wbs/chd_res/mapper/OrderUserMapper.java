package com.wbs.chd_res.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wbs.chd_res.pojo.OrderUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 17:47
 */
@Repository
public interface OrderUserMapper extends BaseMapper<OrderUser> {

    @Select("INSERT INTO order_user  ( user_id,order_id,order_amount,stall_id,is_pay,is_accept,order_time )  VALUES  ( #{user_id},#{order_id},#{order_amount},#{stall_id},#{is_pay},#{is_accept},#{order_time} )")
    List<String> myInsert(
            @Param("user_id") Integer user_id,
            @Param("order_id") Integer order_id,
            @Param("order_amount") Integer order_amount,
            @Param("stall_id") Integer stall_id,
            @Param("is_pay") Integer is_pay,
            @Param("is_accept") Integer is_accept,
            @Param("order_time") Date order_time);

    @Update("UPDATE order_user SET is_pay=#{is_pay} WHERE order_id=#{order_id}")
    Boolean updateIsPayById(
            @Param("is_pay") Integer is_pay,
            @Param("order_id") Integer order_id);
}