package de.hbrs.se.learning.service;

import de.hbrs.se.learning.collections.ArrayBackedStack;
import de.hbrs.se.learning.operations.RpnOperation;

import java.util.List;

public class RpnExecutor {
    private RpnParser parser;

    public RpnExecutor(RpnParser parser) {
        this.parser = parser;
    }

    public double execute(String s) {
        ArrayBackedStack<Double> stack = new ArrayBackedStack<>();
        List<RpnOperation> operations = parser.parse(s);
        for (RpnOperation operation : operations) {
            operation.execute(stack);
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Final stack size is != 1: " + stack.size());
        }

        return stack.pop();
    }
}
