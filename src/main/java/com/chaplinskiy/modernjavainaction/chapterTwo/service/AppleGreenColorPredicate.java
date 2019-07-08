package com.chaplinskiy.modernjavainaction.chapterTwo.service;

import com.chaplinskiy.modernjavainaction.chapterTwo.Apple;

import static com.chaplinskiy.modernjavainaction.chapterTwo.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

}