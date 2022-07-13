package com.wbs.chd_res.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wbs.chd_res.pojo.DishInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 17:43
 */
@Repository     //方便spring识别这个接口
public interface DishInfoMapper extends BaseMapper<DishInfo> {

    @Select("SELECT DISTINCT dish_sort FROM dish_info WHERE dish_id IN(SELECT dish_id FROM stall_dish WHERE stall_id=#{stall_id})")
    List<String> getSortsByStall(@Param("stall_id") Integer stall_id);
}
