package com.cbcing.springcloudzuul.config;

import com.cbcing.springcloudzuul.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfiguration {

    /**
     * 启动设置好的过滤器。
     * @return
     */
    @Bean
    public AccessFilter accessFilter() {
        return  new AccessFilter();
    }

}
