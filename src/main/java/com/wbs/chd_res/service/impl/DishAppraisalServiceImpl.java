package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.DishAppraisalMapper;
import com.wbs.chd_res.pojo.DishAppraisal;
import com.wbs.chd_res.service.DishAppraisalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:07
 */
@Service("dishAppraisalServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class DishAppraisalServiceImpl
        extends ServiceImpl<DishAppraisalMapper, DishAppraisal> //帮助实现IService接口中的方法
        implements DishAppraisalService {
}
