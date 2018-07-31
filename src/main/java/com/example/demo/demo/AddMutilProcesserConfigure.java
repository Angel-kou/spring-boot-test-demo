package com.example.demo.demo;


import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class AddMutilProcesserConfigure {

    @Autowired
    ApplicationContext context;

    @Bean
    public NumberProcessor numberProcessor(){
        return new NumberProcessor(ImmutableList.of(
                context.getBean(AddProcessor.class),
                context.getBean(MutilProcesser.class)
        ));
    }


}
