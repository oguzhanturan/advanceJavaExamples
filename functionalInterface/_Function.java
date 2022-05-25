package functionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        Integer apply = incrementByOne.apply(5);
        System.out.println(apply);
    }

    static Function<Integer, Integer> incrementByOne = number -> ++number;
}


