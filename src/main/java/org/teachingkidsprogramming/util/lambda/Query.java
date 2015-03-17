package org.teachingkidsprogramming.util.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Query {
    public static <In, Out> List<Out> select(List<In> list, Function1<In, Out> function) {
        ArrayList<Out> out = new ArrayList<>();
        for (In i : list) {
            out.add(function.call(i));
        }
        return out;
    }

    public static <In, Out> List<Out> select(In[] list, Function1<In, Out> function) {
        return select(Arrays.asList(list), function);
    }

    public static <In> List<In> where(In[] list, Function1<In, Boolean> funct) {
        ArrayList<In> out = new ArrayList<>();
        for (In i : list) {
            if (funct.call(i)) {
                out.add(i);
            }
        }
        return out;
    }

}
