package com.zy.test.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ziyou
 * <p>
 * 自定义配置
 * </p>
 */
@Data
@Configuration
@ConfigurationProperties("zy")
public class CustomerConfig {

    /**
     * 数据库表配置
     */
    private Strategy strategy;

    /**
     * 包名配置
     */
    private PackageInfo packageInfo;

    /**
     * 全局策略配置
     */
    private GlobalConfig globalConfig;

}
