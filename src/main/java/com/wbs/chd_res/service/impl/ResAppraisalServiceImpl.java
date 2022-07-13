package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.ResAppraisalMapper;
import com.wbs.chd_res.pojo.ResAppraisal;
import com.wbs.chd_res.service.ResAppraisalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:45
 */
@Service("resAppraisalServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class ResAppraisalServiceImpl
        extends ServiceImpl<ResAppraisalMapper, ResAppraisal>
        implements ResAppraisalService {
}
