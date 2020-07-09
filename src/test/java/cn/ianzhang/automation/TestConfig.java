package cn.ianzhang.automation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({
        "classpath:automation-common.properties",
        "classpath:automation-${test.env:sit}.properties",
})
@ComponentScan(value = "cn.ianzhang.automation.data")
public class TestConfig {

    @Autowired
    private Environment env;


}
