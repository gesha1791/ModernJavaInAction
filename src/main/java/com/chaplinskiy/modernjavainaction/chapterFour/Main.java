package com.chaplinskiy.modernjavainaction.chapterFour;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.chaplinskiy.modernjavainaction.chapterFour.Type.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<Dish> exampleMenu = new ArrayList<>();

        List<String> collect = exampleMenu.stream()
                .filter(d -> d.getCalories() < 400) // select dishes that are below 400 calories
                .sorted(comparing(Dish::getCalories)) // sort them by calories
                .map(Dish::getName) // extract the names of these dishes
                .collect(toList()); // stores


        // multicore architecture
        List<String> collectParallelStream = exampleMenu.parallelStream()
                .filter(d -> d.getCalories() < 400) // select dishes that are below 400 calories
                .sorted(comparing(Dish::getCalories)) // sort them by calories
                .map(Dish::getName) // extract the names of these dishes
                .collect(toList()); // stores


        Map<Type, List<Dish>> collect1 = exampleMenu.stream().collect(groupingBy(Dish::getType));

            /*{FISH=[prawns, salmon],
            OTHER=[french fries, rice, season fruit, pizza],
            MEAT=[pork, beef, chicken]}*/



        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, MEAT),
                new Dish("beef", false, 700, MEAT),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, OTHER),
                new Dish("rice", true, 350, OTHER),
                new Dish("season fruit", true, 120, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH));

        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories()>300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);

        List<String> title = Arrays.asList("Modern", "Java", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);

        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        // s.forEach(System.out::println);


        // external iteration with a for-each loop
        List<String> names = new ArrayList<>();

        for(Dish dish : menu){
            names.add(dish.getName());
        }

        //Streams: internal iteration
        List<String> collect2 = menu.stream()
                .map(Dish::getName)
                .collect(toList());


        // Intermediate and terminal operation

        List<String> collect3 = menu.stream()
                .filter(dish -> {  // intermeadiate operation
                    System.out.println("filtering: " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());
        //System.out.println(collect3);

        menu.stream().forEach(System.out::println);
    }


}
