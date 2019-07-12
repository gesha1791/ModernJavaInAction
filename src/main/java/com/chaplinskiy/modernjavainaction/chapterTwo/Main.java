package com.chaplinskiy.modernjavainaction.chapterTwo;

import com.chaplinskiy.modernjavainaction.chapterTwo.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.chaplinskiy.modernjavainaction.chapterTwo.Color.GREEN;
import static com.chaplinskiy.modernjavainaction.chapterTwo.Color.RED;

public class Main {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        Apple apple = new Apple(GREEN, 199);
        Apple apple2 = new Apple(RED, 120);
        Apple apple3 = new Apple(GREEN, 187);
        Apple apple4 = new Apple(RED, 179);

        apples.add(apple);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);

        List<Apple> apples1 = filterApples(apples, GREEN, 0, true);
        List<Apple> apples2 = filterApples(apples, null, 150, false);


        List<Apple> apples3 = filterApples(apples, new AppleRedAndHeavyPredicate());

        //apples3.forEach(System.out :: println);

        prettyPrintApple(apples, new AppleFancyFormatter());

        prettyPrintApple(apples, new AppleSimpleFormatter());

        filterApples(apples, (Apple a) -> RED.equals(a.getColor()));

        List<Integer> numbers = Arrays.asList(4, 6, 8);

        List<Integer> filter = filter(numbers, (Integer i) -> i % 2 == 0);
        filter.forEach(System.out::println);


        apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        apples.forEach(System.out::println);


    }

    private static List<Apple> filterGreenApples(List<Apple> inventory, Color color) {
        List<Apple> apples = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getColor().equals(color))
                apples.add(apple);
        }
        return apples;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        ArrayList<Apple> result = new ArrayList<>();

        for(Apple apple : inventory){
            if(GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApplesByWeight(List <Apple> inventory, int weight){
        List<Apple> apples = new ArrayList<>();

        for(Apple apple : inventory){
            if(apple.getWeight() > weight){
                apples.add(apple);
            }
        }
        return apples;
    }

    // An ugly attempt to merge all attributes might be as follows:
    private static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if ( (flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight) ){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
        ArrayList<Apple> apples = new ArrayList<>();

        for(Apple apple : inventory){
            if(applePredicate.test(apple)){
                apples.add(apple);
            }
        }
        return apples;
    }

    public static void prettyPrintApple(List<Apple> inventory,
                                        AppleFormatter formatter) {
        for(Apple apple: inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e: list) {
            if(p.test(e)) {
                result.add(e);
            } }
        return result;
    }


}
