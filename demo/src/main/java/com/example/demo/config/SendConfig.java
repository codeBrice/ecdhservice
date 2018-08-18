package com.example.demo.config;

import com.example.demo.client.SendClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * class responsible for connecting external services with our service.
 *
 * @since 1.0
 * @author teamJeb
 * @version 1.0
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.example.demo.controller")
public class SendConfig extends WebMvcConfigurerAdapter {

    /**
     * Creates a bean of a SendClient.
     * config endpoint banano send sendservice.
     * @param endpoint url service.
     * @return SendClient.
     */
    @Bean (name = "SendClient")
    public SendClient sendClient(@Value("${service.banano.send}")final String endpoint) {
        return new SendClient(endpoint);
    }

    /**
     * Creates a bean of a HttpRequestMappingHandler Adapter.
     * In charge of transforming json to an object.
     * @return HttpRequestMappingHandler.
     */
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        final RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        final List<HttpMessageConverter<?>> messageConverterList = new ArrayList<>();
        messageConverterList.add(new MappingJackson2HttpMessageConverter());
        requestMappingHandlerAdapter.setMessageConverters(messageConverterList);
        return requestMappingHandlerAdapter;
    }
}
