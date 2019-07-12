package com.chaplinskiy.modernjavainaction.chapterFive;

import com.chaplinskiy.modernjavainaction.chapterFour.Type;
import lombok.Data;

@Data
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
}
