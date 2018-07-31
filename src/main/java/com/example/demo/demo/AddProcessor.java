package com.example.demo.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddProcessor implements Processer{

    @Value("${addNumber}")
    private int number;

    @Override
    public List<Integer> process(List<Integer> input) {
        System.out.println("kmk-----------"+number);
        return input.stream().map(item -> item + number).collect(Collectors.toList());
    }
}
