package com.zy.test.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ziyou
 * <p>
 * 包名配置，通过该配置，指定生成代码的包路径
 * </p>
 */
@Data
@Configuration
@ConfigurationProperties("zy.package-info")
public class PackageInfoProperties {

    /**
     * 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     */
    private String parent = "com.baomidou";

    /**
     * 父包模块名
     */
    private String moduleName ="example";

    /**
     * Entity包名
     */
    private String entity;

    /**
     * Service包名
     */
    private String service;

    /**
     * Service Impl包名
     */
    private String serviceImpl;

    /**
     * Mapper包名
     */
    private String mapper;

    /**
     * Mapper XML包名
     */
    private String xml;

    /**
     * Controller包名
     */
    private String controller;

    /**
     * 路径配置信息
     */
    private String pathInfo;
}
