package com.zy.test.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ziyou
 * <p>
 * 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
 * </p>
 */
@Data
@Configuration
@ConfigurationProperties("zy.strategy")
public class StrategyProperties {

    /**
     * 数据库表映射到实体的命名策略
     */
    private String naming = "underline_to_camel";

    /**
     * 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
     */
    private String columnNaming = "underline_to_camel";

    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 字段前缀
     */
    private String fieldPrefix;

    /**
     * enableSqlFilter（since 3.3.1）
     * <p>
     * 默认激活进行sql模糊表名匹配
     * <p>
     * 关闭之后likeTable与notLikeTable将失效，include和exclude将使用内存过滤
     * <p>
     * 如果有sql语法兼容性问题的话，请手动设置为false
     */
    private Boolean enableSqlFilter = false;

    /**
     * 需要包含的表名，当enableSqlFilter为false时，允许正则表达式（与exclude二选一配置）
     */
    private String include;

    /**
     * 自3.3.0起，模糊匹配表名（与notLikeTable二选一配置）
     */
    private String likeTable;

    /**
     * 需要排除的表名，当enableSqlFilter为false时，允许正则表达式
     */
    private String exclude;

    /**
     * 自3.3.0起，模糊排除表名
     */
    private String notLikeTable;

    /**
     * 【实体】是否为lombok模型（默认 false）
     */
    private Boolean entityLombokModel = false;

    /**
     * Boolean类型字段是否移除is前缀（默认 false）
     */
    private Boolean entityBooleanColumnRemoveIsPrefix;

    /**
     * 生成 @RestController 控制器
     */
    private Boolean restControllerStyle = true;

    /**
     * 驼峰转连字符
     */
    private Boolean controllerMappingHyphenStyle = true;

    /**
     * 是否生成实体时，生成字段注解
     */
    private Boolean entityTableFieldAnnotationEnable;

}
