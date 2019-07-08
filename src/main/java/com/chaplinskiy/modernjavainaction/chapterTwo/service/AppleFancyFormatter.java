package com.chaplinskiy.modernjavainaction.chapterTwo.service;

import com.chaplinskiy.modernjavainaction.chapterTwo.Apple;

public class AppleFancyFormatter implements AppleFormatter {
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" :
                "light";
        return "A " + characteristic +
                " " + apple.getColor() +" apple";
    }
}
