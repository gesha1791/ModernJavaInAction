package com.chaplinskiy.modernjavainaction.chapterTwo;

import com.chaplinskiy.modernjavainaction.chapterTwo.service.*;

import java.util.ArrayList;
import java.util.List;

import static com.chaplinskiy.modernjavainaction.chapterTwo.Color.GREEN;
import static com.chaplinskiy.modernjavainaction.chapterTwo.Color.RED;

public class Main {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        Apple apple = new Apple(GREEN, 100);
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


}
