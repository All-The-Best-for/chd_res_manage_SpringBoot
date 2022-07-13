package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.StallAppraisalMapper;
import com.wbs.chd_res.pojo.StallAppraisal;
import com.wbs.chd_res.service.StallAppraisalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:53
 */
@Service("stallAppraisalServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class StallAppraisalServiceImpl
        extends ServiceImpl<StallAppraisalMapper, StallAppraisal>
        implements StallAppraisalService {
}
