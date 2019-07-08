package com.chaplinskiy.modernjavainaction.chapterTwo.service;

import com.chaplinskiy.modernjavainaction.chapterTwo.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
