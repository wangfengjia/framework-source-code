package com.juc.www.atomic;

import java.util.concurrent.atomic.LongAdder;

public class LongAddrExample {

    public static void main(String[] args) {

        LongAdder adder = new LongAdder();
        adder.add(2);
    }
}
