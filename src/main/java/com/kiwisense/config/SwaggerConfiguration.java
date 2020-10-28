package com.kiwisense.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
  private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));

  @Bean
  public Docket api() {
    ParameterBuilder parameterBuilder = new ParameterBuilder();
    parameterBuilder.name("Authorization")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .description("JWT token")
            .required(false)
            .build();
    List<Parameter> parameters = new ArrayList<>();
    parameters.add(parameterBuilder.build());
    return new Docket(DocumentationType.SWAGGER_2)
        .produces(DEFAULT_PRODUCES_CONSUMES)
        .consumes(DEFAULT_PRODUCES_CONSUMES)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())  
        .build()
        // Setting globalOperationParameters ensures that authentication header is applied to all APIs
        .globalOperationParameters(parameters);
    
    
//    return new Docket(DocumentationType.SWAGGER_2)  
//            .select()                                  
//            .apis(RequestHandlerSelectors.any())              
//            .paths(PathSelectors.any())                          
//            .build();   
 }
}