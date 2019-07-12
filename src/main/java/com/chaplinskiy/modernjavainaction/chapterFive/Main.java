package com.chaplinskiy.modernjavainaction.chapterFive;

import com.chaplinskiy.modernjavainaction.chapterFour.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.chaplinskiy.modernjavainaction.chapterFour.Type.*;
import static com.chaplinskiy.modernjavainaction.chapterFour.Type.FISH;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<com.chaplinskiy.modernjavainaction.chapterFour.Dish> menu = Arrays.asList(
                new com.chaplinskiy.modernjavainaction.chapterFour.Dish("pork", false, 800, MEAT),
                new com.chaplinskiy.modernjavainaction.chapterFour.Dish("beef", false, 700, MEAT),
                new com.chaplinskiy.modernjavainaction.chapterFour.Dish("chicken", false, 400, MEAT),
                new com.chaplinskiy.modernjavainaction.chapterFour.Dish("french fries", true, 530, OTHER),
                new com.chaplinskiy.modernjavainaction.chapterFour.Dish("rice", true, 350, OTHER),
                new com.chaplinskiy.modernjavainaction.chapterFour.Dish("season fruit", true, 120, OTHER),
                new com.chaplinskiy.modernjavainaction.chapterFour.Dish("pizza", true, 550, OTHER),
                new com.chaplinskiy.modernjavainaction.chapterFour.Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH));


        // filtering with a predicate
        List<Dish> collect = menu.stream()
                .filter(dish -> dish.isVegetarian())
                .collect(toList());

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        // filtering unique elements
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct() // delete duplicate
                .forEach(System.out::println);

        // Slicing a stream Java 9


        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("rice", true, 350, OTHER),
                new Dish("chicken", false, 400, MEAT),
                new Dish("goose", true, 280, OTHER),
                new Dish("french fries", true, 530, OTHER));

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println("filteredMenu < 320");
        filteredMenu.forEach(System.out::println);

        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList()); // seasonal fruit, prawns

        System.out.println("slicedMenu1 (takeWhile) < 320");
        slicedMenu1.forEach(System.out::println);

        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());// rice, chicken, french fries

        System.out.println("slicedMenu2 (dropWhile < 320)");
        slicedMenu2.forEach(System.out::println);


        List<Dish> filterWithLimit = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());
        System.out.println("filterWithLimit > 300");
        filterWithLimit.forEach(System.out::println);

        List<Dish> dishes = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println("skip 2 elements > 300");
        dishes.forEach(System.out::println);
    }
}
