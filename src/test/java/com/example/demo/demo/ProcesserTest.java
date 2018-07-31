package com.example.demo.demo;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ActiveProfiles({"test"})
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcesserTest {

    List<Integer> input = new ArrayList<>();

    @Before
    public void beforeEach() {
        input = ImmutableList.of(1,2,3,4,5);
    }

    @Autowired
    private AddProcessor addProcessor;

    @Autowired
    private SubProcessor subProcessor;

    @Autowired
    private MutilProcesser mutilProcesser;

    @Autowired
    private OddProcesser oddProcesser;

    @Autowired
    private EvenProcesser evenProcesser;


    @Test
    public void shouldReturnAddValue() {
        List<Integer> result = Arrays.asList(3,4,5,6,7);
        assertThat(addProcessor.process(input),is(result));
    }

    @Test
    public void shouldReturnSubValue() {
        List<Integer> result = Arrays.asList(-1,0,1,2,3);
        assertThat(subProcessor.process(input),is(result));
    }


    @Test
    public void shouldReturnMutilValue() {
        List<Integer> result = Arrays.asList(2,4,6,8,10);
        assertThat(mutilProcesser.process(input),is(result));
    }

    @Test
    public void shouldReturnOddValue() {
        List<Integer> result = Arrays.asList(1,3,5);
        assertThat(oddProcesser.process(input),is(result));
    }

    @Test
    public void shouldReturnEvenValue() {
        List<Integer> result = Arrays.asList(2,4);
        assertThat(evenProcesser.process(input),is(result));
    }
}
