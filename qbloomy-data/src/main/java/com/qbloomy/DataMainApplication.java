package com.qbloomy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Semih Okan Pehlivan.
 */
@SpringBootApplication
public class DataMainApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DataMainApplication.class);
        ConfigurableApplicationContext context = springApplication.run();
//        QuestionRepositoryImp questionRepositoryImp = (QuestionRepositoryImp)context.getBean("rrr");
//        questionRepositoryImp.addQuestion(new Question("okan","sf"));

        for (String str : context.getBeanDefinitionNames()) {
            System.out.println(str);
        }
    }

}
