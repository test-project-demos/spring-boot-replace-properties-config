package com.example.springbootreplacepropertiesconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Collections;
import java.util.Objects;

/**
 * @author zhixiao.mzx
 * @date 2019/9/5
 */
@Slf4j
@Configuration
//@Order(LoggingApplicationListener.DEFAULT_ORDER - 1)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EnvironmentPreparedEventListener4LogConfig implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        String originConfigProperty = environment.getProperty(LoggingApplicationListener.CONFIG_PROPERTY);

        if (Objects.equals(originConfigProperty, "log4j.properties")) {
            String newConfigProperty = "classpath:logback-spring.xml";
            environment.getPropertySources().addFirst(new MapPropertySource("modify log config",
                Collections.singletonMap(LoggingApplicationListener.CONFIG_PROPERTY, newConfigProperty)));

            log.warn("replace [{}] to [{}]", originConfigProperty, newConfigProperty);
        }
    }
}
