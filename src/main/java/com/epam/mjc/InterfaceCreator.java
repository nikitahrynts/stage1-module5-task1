package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(str -> Character.isUpperCase(str.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evenValues = list.stream()
                    .filter(i -> i % 2 == 0)
                    .collect(Collectors.toList());
            list.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () ->
                values.stream()
                        .filter(str -> Character.isUpperCase(str.charAt(0))
                                && str.endsWith(".")
                                && str.split(" ").length > 3)
                        .collect(Collectors.toList());

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> result = new HashMap<>();
            for (String s : list) {
                result.put(s, s.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (firstList, secondList) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(firstList);
            result.addAll(secondList);
            return result;
        };
    }
}
