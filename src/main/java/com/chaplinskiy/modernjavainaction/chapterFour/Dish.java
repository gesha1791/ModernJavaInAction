package com.chaplinskiy.modernjavainaction.chapterFour;

import lombok.Data;

@Data
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
}
