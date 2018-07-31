package com.example.demo.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class OddProcesser implements Processer{

    @Override
    public List<Integer> process(List<Integer> input) {
        return input.stream().filter(item->item % 2 == 0).collect(Collectors.toList());
    }
}
