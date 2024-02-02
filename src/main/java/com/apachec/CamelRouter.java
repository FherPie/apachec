package com.apachec;

import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;

//A simple Camel Rest DSL route with OpenApi API documentation
@Component
public class CamelRouter extends RouteBuilder {

    @Autowired
    private Environment env;


    @Value("${camel.servlet.mapping.context-path}")
    private String contextPath;


    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true")
                .enableCORS(true)
                .port(env.getProperty("server.port", "8080"))
                .contextPath(contextPath.substring(0, contextPath.length()-2))
                //turn on openapi api-doc
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "User API")
                .apiProperty("api.version", "1.0.0");

        rest("/usuarios").description("Servicio Rest")
                .consumes("application/json")
                .produces("application/json");




    }
}
