package com.example.springbootreplacepropertiesconfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhixiao.mzx
 * @date 2019/9/5
 */
@Data
@Component
@ConfigurationProperties("key-with-prefix")
public class TestPrefixValue {
    private String key;
}
