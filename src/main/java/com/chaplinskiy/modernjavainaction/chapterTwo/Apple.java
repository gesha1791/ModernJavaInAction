package com.chaplinskiy.modernjavainaction.chapterTwo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Apple {
    private Enum color;
    private Integer weight;
}
