package com.example.demo.demo;

import com.google.common.collect.ImmutableList;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@ActiveProfiles({"dev","test"})
@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberProcesserTest {


    @Autowired
    private NumberProcessor numberProcessor ;

    @MockBean
    private AddProcessor addProcessor;
//
//    @MockBean
//    private MutilProcesser mutilProcesser;

    @Test
    public void shouldReturnAddValue1() {
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        when(addProcessor.process(argumentCaptor.capture())).thenReturn(ImmutableList.of(1,1,1));
        assertThat(numberProcessor.process("1 2 3 4 5"),is("2 2 2"));
//        System.out.println(argumentCaptor.getAllValues());
    }




}
