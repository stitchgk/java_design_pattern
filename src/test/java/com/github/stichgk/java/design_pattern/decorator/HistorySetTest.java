package com.github.stichgk.java.design_pattern.decorator;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class HistorySetTest {

    @Test
    public void removedElementTest() {
        HistorySet<Integer> historySet = new HistorySet<>(new HashSet<>());
        historySet.add(1);
        historySet.add(2);
        historySet.add(3);
        historySet.add(4);
        historySet.add(5);
        historySet.add(6);
        historySet.remove(6);
        historySet.remove(6);
        historySet.remove(5);
        historySet.remove(3);
        historySet.remove(3);
        historySet.remove(4);
        System.out.println(historySet);
    }

}
