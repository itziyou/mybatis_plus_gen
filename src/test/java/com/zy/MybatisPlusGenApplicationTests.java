package com.zy;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.zy.test.entity.GlobalConfigProperties;
import com.zy.test.entity.PackageInfoProperties;
import com.zy.test.entity.StrategyProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusGenApplicationTests {
    // 数据库相关配置
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driverName;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    private GlobalConfigProperties globalConfigProperties;
    @Autowired
    private PackageInfoProperties packageInfoProperties;
    @Autowired
    private StrategyProperties strategyProperties;


    @Test
    public void run() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 生成文件的输出目录
        String outputDir = globalConfigProperties.getOutputDir();
        if (StringUtils.isNotBlank(outputDir)) {
            gc.setOutputDir(outputDir);
        } else {
            gc.setOutputDir(projectPath + "/src/main/java");
        }

        // 作者
        gc.setAuthor(globalConfigProperties.getAuthor());
        // 是否打开输出目录
        gc.setOpen(globalConfigProperties.getOpen());
        // 是否在xml中添加二级缓存配置
        gc.setEnableCache(globalConfigProperties.getEnableCache());
        // 是否覆盖已有文件
        gc.setFileOverride(globalConfigProperties.getFileOverride());
        gc.setServiceName(globalConfigProperties.getServiceName());
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(packageInfoProperties.getModuleName());
        pc.setParent(packageInfoProperties.getParent());
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();


        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略
        strategy.setNaming(this.getNamingStrategy(strategyProperties.getNaming()));
        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(this.getNamingStrategy(strategyProperties.getColumnNaming()));
        // 【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(strategyProperties.getEntityLombokModel());
        // 生成 @RestController 控制器
        strategy.setRestControllerStyle(strategyProperties.getRestControllerStyle());
        // 默认激活进行sql模糊表名匹配,关闭之后likeTable与notLikeTable将失效，include和exclude将使用内存过滤
        strategy.setEnableSqlFilter(strategyProperties.getEnableSqlFilter());

        // 包含的表名
        String include = strategyProperties.getInclude();
        if (StringUtils.isNotBlank(include)) {
            strategy.setInclude(include.split(","));
        }
        // 不包含的表明
        String exclude = strategyProperties.getExclude();
        if (StringUtils.isNotBlank(exclude)) {
            strategy.setExclude(exclude.split(","));
        }

        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(strategyProperties.getControllerMappingHyphenStyle());
        // 表前缀
        String tablePrefix = strategyProperties.getTablePrefix();
        if (StringUtils.isNotBlank(tablePrefix)) {
            strategy.setTablePrefix(tablePrefix);
        }
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }


    /**
     * 翻译
     *
     * @param naming
     * @return
     */
    private NamingStrategy getNamingStrategy(String naming) {
        switch (naming) {
            case "no_change":
                return NamingStrategy.no_change;
            default:
                return NamingStrategy.underline_to_camel;

        }
    }

}
