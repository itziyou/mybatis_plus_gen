package com.zy.test.entity;

import lombok.Data;

/**
 * @author ziyou
 * <p>
 * 全局策略配置
 * </p>
 */
@Data
public class GlobalConfig {

    /**
     * 生成文件的输出目录
     */
    private String outputDir;

    /**
     * 是否覆盖已有文件
     */
    private Boolean fileOverride = true;

    /**
     * 是否打开输出目录
     */
    private Boolean open = false;

    /**
     * 是否在xml中添加二级缓存配置
     */
    private Boolean enableCache = false;

    /**
     * 开发人员
     */
    private String author = "admin";

    /**
     * 开启 swagger2 模式
     */
    private Boolean swagger2;

    /**
     * 时间类型对应策略
     */
    private String dateType;

    /**
     * 实体命名方式
     * 默认值：null 例如：%sEntity 生成 UserEntity
     */
    private String entityName;

    /**
     * mapper 命名方式
     * 默认值：null 例如：%sDao 生成 UserDao
     */
    private String mapperName;

    /**
     * Mapper xml 命名方式
     * 默认值：null 例如：%sDao 生成 UserDao.xml
     */
    private String xmlName;

    /**
     * service 命名方式
     * 默认值：null 例如：%sBusiness 生成 UserBusiness
     */
    private String serviceName = "%sService";

    /**
     * service impl 命名方式
     * 默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
     */
    private String serviceImplName;

    /**
     * controller 命名方式
     * 默认值：null 例如：%sAction 生成 UserAction
     */
    private String controllerName;

    /**
     * 指定生成的主键的ID类型
     */
    private String idType;
}
