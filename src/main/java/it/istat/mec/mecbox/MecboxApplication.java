package it.istat.mec.mecbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 *
 * @author Istat MecBox Team
 */
@SpringBootApplication
public class MecboxApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MecboxApplication.class, args);
    }
    
    @Bean
    public ResourceBundleMessageSource messageSource () {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        return messageSource;
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MecboxApplication.class);
    }
    
   
}
