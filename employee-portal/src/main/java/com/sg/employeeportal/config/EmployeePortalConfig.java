package com.sg.employeeportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

@Configuration
public class EmployeePortalConfig {

  @Bean
  public Docket produceApi() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage("com.sg.employeeportal.controller"))
        .paths(paths()).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Employee Portal API")
        .description("List of all the Rest API's for Employee Portal")
        .version("0.0.1-SNAPSHOT").build();
  }

  private Predicate<String> paths() {
    return Predicates.and(PathSelectors.regex("/employee.*"),
        Predicates.not(PathSelectors.regex("/error.*")));
  }

}
