package com.example.demo.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static com.sun.tools.internal.xjc.reader.Ring.add;

@Component
@Profile("!test")
public class DemoAppRunner implements ApplicationRunner,ApplicationContextAware {

    private ApplicationContext context;

    @Autowired
    private NumberProcessor numberProcessor;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println(numberProcessor.process("1 2 3 4 5"));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
