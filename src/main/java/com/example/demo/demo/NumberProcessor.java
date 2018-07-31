package com.example.demo.demo;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NumberProcessor {


//    @Autowired
    private List<Processer> processers ;


    @Autowired
    public NumberProcessor(List<Processer> processers) {
        this.processers = processers;
    }
//     @Value("${number}")
//     private int number;

//    public NumberProcessor(@Value("2") String number) {
//        this.number = Integer.parseInt(number);
//    }

    String process(String input){

        List<Integer> temp = Arrays.asList(input.split(" ")).stream().map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();

        for (Processer p : processers){
            System.out.println("processer :" + p);
            list = p.process(temp);
            System.out.println(list);
            temp = list;
        }

        List<String> res = list.stream().map(String::valueOf).collect(Collectors.toList());
        return String.join(" ",res);

    }

}
