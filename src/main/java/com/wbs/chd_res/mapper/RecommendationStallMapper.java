package com.wbs.chd_res.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wbs.chd_res.pojo.RecommendationStall;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-04 8:49
 */
@Repository     //方便spring识别这个接口
public interface RecommendationStallMapper extends BaseMapper<RecommendationStall> {

    @Select("INSERT INTO recommendation_stall  ( stall_id,is_admin )  VALUES  ( #{stall_id},#{is_admin} )")
    List<String> myInsert(@Param("stall_id") Integer stall_id,@Param("is_admin") Integer is_admin);
}
