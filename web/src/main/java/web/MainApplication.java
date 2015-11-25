package web;

import com.qbloomy.DataMainApplication;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import otherpackage.OtherMainApplication;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MainApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(MainApplication.class, OtherMainApplication.class, DataMainApplication.class);
		app.setShowBanner(true);
        ConfigurableApplicationContext context = app.run(args);
        for (String beans : context.getBeanDefinitionNames()) {
            System.out.println(beans);
        }
    }

}