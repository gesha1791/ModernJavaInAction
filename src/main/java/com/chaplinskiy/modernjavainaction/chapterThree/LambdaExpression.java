package com.chaplinskiy.modernjavainaction.chapterThree;


import com.chaplinskiy.modernjavainaction.chapterThree.service.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExpression {
    public static void main(String[] args) {

        // Examples of lambdas

        // (List<String> list) -> list.isEmpty(); - boolean expression

        // () -> new Apple(10); - creating objects

        /*(Apple a) -> {
            System.out.println(a.getWeight()); - consuming from object
        }*/

        // (String s) -> s.length(); - select/extract from object

        // (int a, int b) -> a * b; combine two values

        // (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()); compare two objects

    }

    public <T> void forEach(List<T> list, Consumer<T> c) {
        forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i));

    }


}
