package com.fristProject.articleRecomender;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.xml.bind.v2.schemagen.xmlschema.Documentation;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}

}
