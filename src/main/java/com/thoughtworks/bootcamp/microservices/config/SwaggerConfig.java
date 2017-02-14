package com.thoughtworks.bootcamp.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by abhijeek on 14/02/17.
 */
@ConfigurationProperties(prefix="swagger")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private String description;
    private String version;
    private String termsOfServiceUrl;
    private String contactName;
    private String contactURL;
    private String contactEmail;
    private String license;
    private String licenseURL;
    private String title;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex(".*doctors.*"))
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo())
                ;
    }

    /**
     * This method will return the API info object to swagger which will in turn display the information on the swagger UI.
     *
     * @return the API information
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("title").description("description").contact(new Contact(contactName, contactURL, contactEmail)).build();
    }
}
