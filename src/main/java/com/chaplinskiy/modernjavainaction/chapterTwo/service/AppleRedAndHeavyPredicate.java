package com.chaplinskiy.modernjavainaction.chapterTwo.service;

import com.chaplinskiy.modernjavainaction.chapterTwo.Apple;

import static com.chaplinskiy.modernjavainaction.chapterTwo.Color.RED;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple){
        return RED.equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
