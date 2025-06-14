package com.ruoyi.framework.config;

import java.util.TimeZone;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 程式註解配置
 *
 * @author ruoyi
 */
@Configuration
// 表示透過aop框架暴露該代理物件,AopContext能夠訪問
@EnableAspectJAutoProxy(exposeProxy = true)
// 指定要掃描的Mapper類的包的路徑
@MapperScan("com.ruoyi.**.mapper")
public class ApplicationConfig
{
    /**
     * 時區配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization()
    {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }
}
