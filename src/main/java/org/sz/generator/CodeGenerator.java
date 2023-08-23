package org.sz.generator;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * mybaties plus 代码生成器
 */
public class CodeGenerator {
    private static final String author = System.getProperty("user.name");
    private static final String driverName = "com.mysql.cj.jdbc.Driver";

    private static final String url = "jdbc:mysql://10.27.74.56:4000/smsdb?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private static final String userName = "sysbench";
    private static final String password = "SysBench12";
    private static final String tableNames = "sms_send_2";
    //生成在该目录下
    private static final String package_name = "org.sz";

    public static void main(String[] args) {
        for (String tableName : tableNames.split(",")) {
            generator(tableName);
        }
    }

    public static void generator(String tableName) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/__code-generator/src/main/java");
        //不覆盖已有，则为false
        gc.setFileOverride(true);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(false);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setIdType(IdType.AUTO);
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setEntityName(convertToClassHumpName(tableName));
        gc.setMapperName(convertToClassHumpName(tableName) + "Mapper");
        //gc.setControllerName(name_prex + "Controller");
        gc.setServiceName(convertToClassHumpName(tableName) + "Service");
        gc.setServiceImplName(convertToClassHumpName(tableName) + "ServiceImpl");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent(package_name);
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/__code-generator/src/main/resources/mapper" /*+ pc.getModuleName()*/
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(false);
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude(tableName);
        //strategy.setSuperEntityColumns("id");
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


    public static String convertToClassHumpName(String name) {
        StringBuilder mapKeyName = new StringBuilder("");
        if (name == null) {
            return null;
        }
        name = name.toLowerCase();
        boolean flag = false;
        for (int i = 0; i < name.length(); i++) {
            char keyChar = name.charAt(i);
            if (i == 0 && '_' != keyChar) {
                mapKeyName.append(Character.toUpperCase(keyChar));
                continue;
            }
            if ('_' == keyChar) {
                if (i != 0) {
                    flag = true;
                }
                continue;
            }
            if (flag) {
                keyChar = Character.toUpperCase(keyChar);
                flag = false;
            }
            mapKeyName.append(keyChar);
        }

        return mapKeyName.toString();
    }
}