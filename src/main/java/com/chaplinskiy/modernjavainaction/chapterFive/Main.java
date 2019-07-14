package com.chaplinskiy.modernjavainaction.chapterFive;

import com.chaplinskiy.modernjavainaction.chapterFour.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                new Dish("chickenYoung", false, 423, MEAT),
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

        List<String> map = specialMenu.stream()
                .map(Dish::getName)
                .collect(toList());
        map.forEach(System.out::println);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

        List<Integer> lenghtWords = words.stream()
                .map(String::length)
                .collect(toList());

        List<Integer> collect1 = specialMenu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        collect1.forEach(System.out::println);

        List<String> strings = Arrays.asList("Hello", "world");


        // Incorrect use of map to find unique characters from a list of words
        List<String[]> collect2 = strings.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());

        String [] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        List<Stream<String>> collect3 = strings.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        List<String> flatMapStringWords = strings.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        List <Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        integers.stream()
                .map(num -> num * num)
                .collect(toList());

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> collect4 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());


        List<int[]> collect5 = numbers1.stream()
                .flatMap(i ->
                        numbers2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})
                )
                .collect(toList());



        // The anyMatch method returns a boolean and is therefore a terminal operation.
        if (menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly");
        }

        // The allMatch method works similarly to anyMatch but will check to see if all the elements
        // of the stream match the given predicate. The allMatch method works similarly to anyMatch
        // but will check to see if all the elements of the stream match the given predicate.
        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);


        boolean b = menu.stream().noneMatch(d -> d.getCalories() >= 1000);


        Optional<Dish> dishVegetarian = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        menu.stream()
                .filter(Dish :: isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));


        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);

        someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .ifPresent(n -> System.out.println(n));


        // Summing the elements, loop
        int sum = 0;
        for (int x : someNumbers) {
            sum += x;
        }

        // reduce
        Integer reduce = someNumbers.stream().reduce(0, (a, c) -> a + c);
        System.out.println(reduce);

        Integer reduce2 = someNumbers.stream().reduce(0, Integer::sum);

        Integer reduce1 = numbers.stream().reduce(1, (a, c) -> a * c);
        System.out.println(reduce1);

        // The reduce operation can’t return a sum because it doesn’t have an initial value
        Optional<Integer> reduce3 = numbers.stream().reduce((z, x) -> (z + x));


        Optional<Integer> maxInteger = someNumbers.stream().reduce(Integer::max);

        Optional<Integer> minInteger = someNumbers.stream().reduce(Integer::min);

        Integer reduce4 = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, c) -> a + c);

        long count = menu.stream().count();

        System.out.println(reduce4 + " " + count);

    }

}
