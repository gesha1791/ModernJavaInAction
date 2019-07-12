package com.chaplinskiy.modernjavainaction.chapterTwo.service;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}