package com.juc.www.atomic;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

public class LongAccumulatorExample {

    public static void main(String[] args) {
        LongAccumulator accumulator = new LongAccumulator(new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left - right;
            }
        }, 1);
        accumulator.accumulate(3);
        accumulator.accumulate(3);
        long l = accumulator.get();
        System.out.println(l);
    }
}
