package com.example.springbootreplacepropertiesconfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhixiao.mzx
 * @date 2019/9/5
 */
@Data
@Component
public class TestEmbeddedValue {
    @Value("${xxx-key}")
    private String configValue;
}
