package com.springboot.www.component;

import com.springboot.www.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Configuration
//@EnableWebMvc
public class WebConfiguration{

    @Bean
    public User userO1(){
        return new User(1, "wang", "wang");
    }


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        return new WebMvcConfigurer() {
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, User>() {
                    @Override
                    public User convert(String source) {
                        User user = new User();
                        if (!StringUtils.isEmpty(source)){
                            String[] strings = source.split(",");
                            user.setName(strings[0]);
                            user.setPassword(strings[1]);
                        }
                        return user;
                    }
                });
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new WebMessageConverter());
            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

                Map<String, MediaType> mediaTypeMap = new HashMap<>();
                mediaTypeMap.put("json", MediaType.APPLICATION_JSON);
                mediaTypeMap.put("xml", MediaType.APPLICATION_XML);
                mediaTypeMap.put("dd", MediaType.parseMediaType("application/x-y-z"));
                ParameterContentNegotiationStrategy negotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypeMap);
                configurer.strategies(Arrays.asList(negotiationStrategy));
            }
        };
    }
}
