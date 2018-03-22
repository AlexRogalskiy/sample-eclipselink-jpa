package pl.piomin.services.jpa;

import static springfox.documentation.builders.PathSelectors.any;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JpaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(JpaApplication.class).web(WebApplicationType.NONE).run(args);
	}
	
	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
				.apis(RequestHandlerSelectors.basePackage("pl.piomin.services.jpa"))
				.paths(any())
			.build()
			.apiInfo(new ApiInfoBuilder().version("1.0").title("JPA API").description("Documentation JPA API v1.0").build());
	}
	
}
