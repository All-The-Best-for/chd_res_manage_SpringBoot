package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.StallAdminMapper;
import com.wbs.chd_res.pojo.StallAdmin;
import com.wbs.chd_res.service.StallAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:52
 */
@Service("stallAdminServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class StallAdminServiceImpl
        extends ServiceImpl<StallAdminMapper, StallAdmin>
        implements StallAdminService {
}
