package ua.goit.online67.twelve_example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 * Example of generic classes.
 * <p>
 * Created by andreymi on 3/20/2017.
 */
public class GenericClasses {
    // You already know that we can use generics for methods.
    // Java has possibility to make generic classes.
    static class Holder<T> {
        // This is class which holds any element of type T inside.
        T value;
        //

        Holder(T value) {
            this.value = value;
        }

        // You can use this type when calling class methods.
        private T getValue() {
            return value;
        }

        // NOTE! static methods as they are not bounded to class variable have to possibility to access class type.
        // Example below will give you exception.
        //private static void someMethod(T type) {
        //}

        // You can combine methods generics with class generics.
        private <V> V convert(Function<T, V> converter) {
            return converter.apply(value);
        }
    }

    // Now we want to create holder only for Numbers..
    // We upper bounded class to number so we assure nothing but number will be holded here.
    private static class NumbersHolder<T extends Number> extends Holder<T> {
        public NumbersHolder(T value) {
            super(value);
        }
    }

    // But we want it be comparable too? Possible! You can make strict bound to any number of classes.
    private static class NumbersCmpHolder<T extends Number & Comparable<T>> extends Holder<T> {
        public NumbersCmpHolder(T value) {
            super(value);
        }
    }

    public static void main(String[] args) {
        // And now our Holder can be parameterized.
        // Since java 7 you can omit second time generic declaration.
        // This is called 'diamond' operator, because it is 'shines bright like a diamond.'
        Holder<Integer> holder = new Holder<>(1);
        Integer value = holder.getValue();
        Long converted = holder.convert(new Function<Integer, Long>() {
            @Override
            public Long apply(Integer integer) {
                return integer.longValue();
            }
        });
        // Now lets use NumbersHolder.
        holder = new NumbersHolder<>(10);
        // Below example wont compile.
        //NumbersHolder<String> stringHolder = new NumbersHolder<String>("");
        //
        // Generics were introduced in java 5. Sun/Oracle guys tries somehow make generics
        // be backward compatible with code written in java before.
        // So they created simply but very painful method - type erasure.
        // Generics existed at compile time, but eraised in runtime and cannot be accessed no more.
        Holder holderRaw = holder;
        // This example called 'raw' typing.
        // Why is it problem? Assume we do not know what is inside and try to get long out of holder.
        // And get as expected : Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Long
        // Because holder is holding integer value, not longs.
        //Long v = (Long) holderRaw.getValue();
        //System.out.println(v);
        //
        // Lets try same with collections.
        // It is holding integers.
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List rawList = integers;
        //Long v1 = (Long) rawList.get(0);
        //Date v2 = (Date) rawList.get(0);
        // as we know that types are erased we can make this convertions.
        // Class cast exception only occurs when class names are not the same - but here we have lists.
        List<Long> longs = (List<Long>) rawList;
        // Sure that when we change type parameter - elements inside remained integers.
        System.out.println(longs.contains(1L));
        System.out.println(longs.contains(1));
        //As expected : Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Long
        //Expected? Really? :)
        Long val = longs.get(0);

    }
}
