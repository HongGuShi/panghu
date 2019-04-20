package com.panghu.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.panghu")
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.panghu.study.dao")
public class StudyApplication {//extends SpringBootServletInitializer 将项目打成war包使用

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(StudyApplication.class);
//    }

//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        Properties properties = new Properties();
//        properties.put("mappers", "tk.mybatis.mapper.common.Mapper,tk.mybatis.mapper.common.MySqlMapper,com.phq.common.base.IdInserListMapper");
//        MapperScannerConfigurer msc = new MapperScannerConfigurer();
//        msc.getMapperHelper().setProperties(properties);
//        msc.setBasePackage("com.panghu.study.dao");
//        return msc;
//    }

}
