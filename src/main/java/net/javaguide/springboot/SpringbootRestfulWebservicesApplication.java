package net.javaguide.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring boot Rest Api Documentation",
                description = "Spring boot Rest Api Documentation",
                version = "2.2.0",
                contact = @Contact(
                        name = "Ahmed",
                        email = "ahmed21@gmail.com",
                        url = "https://www.javajuides.net"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.javajuides.net/licensc"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "spring boot user management documentation",
                url = "https://www.javajuides.net/user_management.html"
        )
)
public class SpringbootRestfulWebservicesApplication {
    //configure model mapper class as a spring Bean
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
    }
}
