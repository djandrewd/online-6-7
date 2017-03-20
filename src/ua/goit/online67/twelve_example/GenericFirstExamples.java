package ua.goit.online67.twelve_example;

import java.util.Comparator;

/**
 * General examples of generic usages.
 * <p>
 * Created by andreymi on 3/20/2017.
 */
public class GenericFirstExamples {
    // Generics were mustly expired of C++ templates and have much in common.
    // Base idea of generics is provide dynamic typing and templating to types.
    // What this means? For example creating of List<Integer> using generic syntax <> - we says that we are
    // working with list where every element has type Integer.
    // Why you need this?
    // For example assume you have method calculated minimum of array. Assume we have integers.
    private static Integer min(Integer[] array) {
        System.out.println("Call min int array...");
        Integer min = null;
        for (int val : array) {
            min = min == null || min.compareTo(val) > 0 ? val : min;
        }
        return min;
    }

    // And now we want to add this for longs..
    private static Long min(Long[] array) {
        Long min = null;
        for (long val : array) {
            min = min == null || min.compareTo(val) > 0 ? val : min;
        }
        return min;
    }

    // And now we want to add this for doubles.
    private static Double min(Double[] array) {
        Double min = null;
        for (double val : array) {
            min = min == null || min.compareTo(val) > 0 ? val : min;
        }
        return min;
    }

    // and maybe for strings.
    private static String min(String[] array) {
        String min = null;
        for (String val : array) {
            min = min == null || min.compareTo(val) > 0 ? val : min;
        }
        return min;
    }

    // Looks the same?
    // Generics are created for creation of template methods and classes which has common logic for all types.
    // In generics way it will looks like.
    // T is generic type we want to use, <T> - syntax for generics. Traditionally it is names T as Type.
    private static <T> T min(T[] array, Comparator<T> comparator) {
        // In this case we must pass comparator wich will help us compare two elements of some type T.
        T min = null;
        for (T val : array) {
            min = min == null || comparator.compare(min, val) > 0 ? val : min;
        }
        return min;
    }

    // Assume we want to accept not every type and we have some bound.
    // In our case we want not to pass comparator.
    // How to achieve that? If all elements in array will be of time Comparable - then we can omit it.
    // For this purposes in java generics you can set upper bound limit. (if class B extends A then A upper class of B).
    //
    // Object
    //   |
    //  Number
    //   |
    //  Long
    //
    // Using special syntax calling 'extends'
    public static <T extends Comparable<T>> T min(T[] array) {
        System.out.println("Call min generic array...");
        T min = null;
        for (T val : array) {
            min = min == null || min.compareTo(val) > 0 ? val : min;
        }
        return min;
    }

    // Now out method works for all types and acts as template for any type that can be comparable.
    public static void main(String[] args) {
        // Lets take a look on result.
        Integer valI = min(new Integer[]{1, 2, 3, 4}, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        // Lets take a look on result.
        Long valL = min(new Long[]{1L, 2L, 3L, 4L}, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o1, o2);
            }
        });
        System.out.println(valI + " : " + valL);
        // Example using without comparator.
        Integer val2 = min(new Integer[]{1, 2, 3, 4});
        // See java calls concrete integer method? why?
        // this is because java find more precisely typed as possible to call method.
        System.out.println(val2);
        // And for bytes...
        Byte valB = min(new Byte[] {1, 2, 3, 4});
        System.out.println(valB);
        // And one rule that you've mentioned already - you cannot use primitives as generics.
    }
}
