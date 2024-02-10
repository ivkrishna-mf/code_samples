package mongodbjpasp3service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@SpringBootApplication
public class MongodbJpaApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(MongodbJpaApplication.class, args);
	}

	@Bean
	 public OpenAPI openApiInformation() {
	  Server localServer = new Server()
	                      .url("http://localhost:8080")
	                      .description("Localhost Server URL");
	  
	  Server localServer2 = new Server()
              .url("http://localhost:8081")
              .description("Localhost2 Server URL");

	  Contact contact = new Contact()
	                    .email("ione@gmail.com")
	                    .name("ione tech krishna");

	  Info info = new Info()
	              .contact(contact)
	              .description("Spring Boot 3 + Open API 3:description")
	              .summary("Demo of Spring Boot 3 & Open API 3 Integration:summary")
	              .title("Spring Boot 3 + Open API 3:title")
	              .version("V1.0.0")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org"));

	  return new OpenAPI().info(info).addServersItem(localServer).addServersItem(localServer2);
	 }
// setting for the default media type for response
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		WebMvcConfigurer.super.configureContentNegotiation(configurer);
		//By default JSON is the priority output
//		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
	
	
	
}
