package com.chaplinskiy.modernjavainaction.chapterTwo.service;

import com.chaplinskiy.modernjavainaction.chapterTwo.Apple;

public class AppleSimpleFormatter implements AppleFormatter {
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
