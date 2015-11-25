package web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import web.configuration.security.CsrfHandlerInterceptor;
import web.formatter.DateFormatter;

/**
 * Created by semihokan on 12/10/15.
 */
@Configuration
@EnableWebMvc
public class WebApplicationConfiguration extends WebMvcConfigurerAdapter{

    @Autowired
    DateFormatter dateFormatter;

    @Autowired
    CsrfHandlerInterceptor csrfHandlerInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(dateFormatter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(csrfHandlerInterceptor);
    }
}
