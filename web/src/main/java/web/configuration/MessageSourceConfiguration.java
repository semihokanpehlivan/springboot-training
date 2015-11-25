package web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by semihokan on 12/10/15.
 */
@Configuration
public class MessageSourceConfiguration{

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource =
                new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("properties/messages");
        return resourceBundleMessageSource;
    }

}
