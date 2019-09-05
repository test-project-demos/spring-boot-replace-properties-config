package com.example.springbootreplacepropertiesconfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.util.StringValueResolver;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author zhixiao.mzx
 * @date 2019/9/5
 */
@Slf4j
@Configuration
public class BeanFactoryPostProcessor4Config implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
        throws BeansException {
        StringValueResolver stringValueResolver = generateStringValueResolver();

        //String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        //Stream.of(beanDefinitionNames)
        //    .map(configurableListableBeanFactory::getBeanDefinition)
        //    .forEach(beanDefinition -> {
        //        BeanDefinitionVisitor beanDefinitionVisitor = new BeanDefinitionVisitor(stringValueResolver);
        //        beanDefinitionVisitor.visitBeanDefinition(beanDefinition);
        //    });
        configurableListableBeanFactory.addEmbeddedValueResolver(stringValueResolver);
    }

    private StringValueResolver generateStringValueResolver() {
        return strVal -> {
            if (StringUtils.isBlank(strVal)) {
                return strVal;
            }
            log.info("BeanFactoryPostProcessor4LogConfig: {}", strVal);

            if (Objects.equals(strVal, "xxx-value")) {
                String newStrVal = "yyy-value";
                log.warn("origin value [{}], new value [{}]", strVal, newStrVal);
                return newStrVal;
            }
            return strVal;
        };
    }
}
