package com.chaplinskiy.modernjavainaction.chapterThree.service;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader bf) throws IOException;
}
