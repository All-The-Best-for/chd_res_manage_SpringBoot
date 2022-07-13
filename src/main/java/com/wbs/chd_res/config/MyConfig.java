package com.wbs.chd_res.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义配置文件
 *
 * @author wbs
 * @create 2022-04-28 19:04
 */
@Configuration
@MapperScan("com.wbs.chd_res.mapper")
public class MyConfig {
    /**
     * 配置mybatis-plus的分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
        return paginationInterceptor;
    }

    //新增加一个类用来添加虚拟路径映射
    @Configuration
    public class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/images/**").addResourceLocations("file:C:\\Users\\28615\\Desktop\\chd_res\\src\\main\\resources\\static\\images\\");
        }
    }
}
