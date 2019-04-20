package com.panghu.study;

import com.google.common.collect.Lists;
import com.panghu.common.constant.PangHuConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder languagePar = new ParameterBuilder();
        tokenPar.name(PangHuConstant.tokenHeader).description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        languagePar.name(PangHuConstant.languageHeader).description("语言").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        List<Parameter> params = Lists.newArrayList();
        params.add(tokenPar.build());
        params.add(languagePar.build());
        //添加head参数end
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.phq"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(params);
    }
}
