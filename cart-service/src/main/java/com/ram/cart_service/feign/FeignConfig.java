package com.ram.cart_service.feign;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {

        return requestTemplate -> {

            RequestAttributes requestAttributes =
                    RequestContextHolder.getRequestAttributes();

            if(requestAttributes != null){

                HttpServletRequest request =
                        ((ServletRequestAttributes)
                                requestAttributes)
                                .getRequest();

                String authorization =
                        request.getHeader(
                                "Authorization"
                        );

                if(authorization != null){

                    requestTemplate.header(
                            "Authorization",
                            authorization
                    );
                }
            }
        };
    }
}