package com.example.demo.demo;

import org.springframework.stereotype.Component;

import java.util.List;

public interface Processer {
    public List<Integer> process(List<Integer> input);
}
