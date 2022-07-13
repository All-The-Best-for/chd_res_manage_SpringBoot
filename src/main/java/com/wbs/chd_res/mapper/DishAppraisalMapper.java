package com.wbs.chd_res.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wbs.chd_res.pojo.DishAppraisal;
import org.springframework.stereotype.Repository;

/**
 * @author wbs
 * @create 2022-05-02 17:38
 */
@Repository     //方便spring识别这个接口
public interface DishAppraisalMapper extends BaseMapper<DishAppraisal> {   //继承一些MyBatis Plus中已有的一些增删改查的方法
}
