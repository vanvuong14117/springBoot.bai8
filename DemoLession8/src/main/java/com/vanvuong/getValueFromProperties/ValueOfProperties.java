/**
 * 
 */
package com.vanvuong.getValueFromProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * @author Admin
 *
 */
@Configuration
@PropertySource("file:E:/work_space_java_nangcao/DemoLession8/src/main/resources/message.properties")
public class ValueOfProperties {

	/*
	 * @Value("${NotBlank.user.userName}") private String isNotBlankMessage;
	 * 
	 * @Bean public static PropertySourcesPlaceholderConfigurer
	 * propertyConfigInDev() { return new PropertySourcesPlaceholderConfigurer(); }
	 */
	
	@Autowired
    private Environment env;

    public String getBlankMessage() {
        String value ="";
        return value=env.getProperty("NotBlank.user.userName");
    }

}
