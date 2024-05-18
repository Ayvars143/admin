package com.example.adminms;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class AdminMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminMsApplication.class, args);
	}
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addParameters("globalHeader",
						new Parameter().in("header").name("X-MyHeader").required(true).description("Custom header").example("example-value")))
				.info(new Info()
						.title("Online-Movie-Ticket-Booking-Admin-page")
						.version("1.0")
						.description("This API is used for Adding, Deleting, Updateing, Fetching the details of Loactions,Movies,Theaters,Screens"));
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();

	}

}
