package de.hbrs.se.learning.service;

import de.hbrs.se.learning.operations.AddOperation;
import de.hbrs.se.learning.operations.DivideOperation;
import de.hbrs.se.learning.operations.MultiplyOperation;
import de.hbrs.se.learning.operations.PushOperation;
import de.hbrs.se.learning.operations.RpnOperation;
import de.hbrs.se.learning.operations.SubtractOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class RpnParser {

    private Map<String, Function<String, RpnOperation>> functions;

    public RpnParser() {
        functions = new HashMap<>();
        functions.put("\\+", s -> new AddOperation());
        functions.put("-", s -> new SubtractOperation());
        functions.put("\\*", s -> new MultiplyOperation());
        functions.put("/", s -> new DivideOperation());
        functions.put("\\d+|\\d*\\.\\d+", s -> new PushOperation(Float.parseFloat(s)));
    }

    public List<RpnOperation> parse(String expression) {
        List<RpnOperation> result = new ArrayList<>();

        if (!expression.trim().isEmpty()) {
            for (String cmd : expression.trim().split("\\s+")) {
                result.add(convertCommand(cmd));
            }
        }

        return result;
    }

    private RpnOperation convertCommand(String cmd) {
        for (Map.Entry<String, Function<String, RpnOperation>> entry : functions.entrySet()) {
            final String pattern = entry.getKey();
            final Function<String, RpnOperation> converter = entry.getValue();

            if (cmd.matches(pattern)) {
                return converter.apply(cmd);
            }
        }

        throw new IllegalArgumentException("Unknown string: " + cmd);
    }
}
