package com.thinkful.spring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfiguration {

    @Bean
    public RestOperations restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList();
        httpMessageConverters.add(jacksonMessageConverter());
        restTemplate.setMessageConverters(httpMessageConverters);

        return restTemplate;
    }

    @Bean
    public RequestMappingHandlerAdapter annotationMethodHandlerAdapter() {
        RequestMappingHandlerAdapter mappingHandlerAdapter = new RequestMappingHandlerAdapter();

        List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList();
        httpMessageConverters.add(jacksonMessageConverter());
        mappingHandlerAdapter.setMessageConverters(httpMessageConverters);

        return mappingHandlerAdapter;
    }

    @Bean
    public HttpMessageConverter jacksonMessageConverter()
    {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper().getObject());
        mappingJackson2HttpMessageConverter.setPrettyPrint(false);

        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        mediaTypes.add(MediaType.TEXT_HTML);

        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        return mappingJackson2HttpMessageConverter;
    }

    @Bean
    public Jackson2ObjectMapperFactoryBean objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JodaModule());

        Jackson2ObjectMapperFactoryBean jacksonFactoryBean = new Jackson2ObjectMapperFactoryBean();
        jacksonFactoryBean.setIndentOutput(true);
        jacksonFactoryBean.setSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        jacksonFactoryBean.setObjectMapper(objectMapper);

        return jacksonFactoryBean;
    }
}
