package ua.goit.online67.twelve_example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * More sophisticated examples for generics
 * <p>
 * Created by andreymi on 3/20/2017.
 */
public class MoreGenericsExamples {

    public static void main(String[] args) {
        // You create typed class that accepts every type using 'wildcard' - '?'
        // List that accepts numbers and strings....but cannot be used directly...
        List<?> anyType = new ArrayList<>();
        // this hack always works..
        List<String> strings = (List<String>) anyType;
        strings.add("Hello");
        // and this too...
        List<Integer> integers = (List<Integer>) anyType;
        integers.add(1);
        // And what is inside after this? :)
        // You have to be very caseful with this.
        // Where to use wildcards then?
        // One of examples can be usage in collections of typed classes.
        // For example - collection of any holders we have in system.
        List<GenericClasses.Holder<?>> anyHolders = new ArrayList<>();
        anyHolders.add(new GenericClasses.Holder<>(1));
        anyHolders.add(new GenericClasses.Holder<>("Hello"));
        //
        List<List<?>> a = new ArrayList<>();
        a.add(new ArrayList<Long>());
        a.add(new ArrayList<String>());

        List<List<? extends Number>> b = new ArrayList<>();
        b.add(new ArrayList<Long>());
        //b.add(new ArrayList<String>());

        List<List<? super Number>> c = new ArrayList<>();
        //c.add(new ArrayList<Long>());
        c.add(new ArrayList<Number>());
        c.add(new ArrayList<Object>());
        //
        A<?> a1 = new A();
        a1.toString();
        // What is type of wildcard?  Object
        Object val = anyHolders.get(0).value;
        // You can put lower bound also.. and put inside any of Long, Number, Object.
        // As everything is extends object you can put there everything...
        GenericClasses.Holder<? super Long> values = new GenericClasses.Holder<>("String");
        //Long valL = (Long) values.value;
        //System.out.println(valL);
        // 'super' bound works only with wildcards.
        addElements(new ArrayList<Object>());
        //
        // You can target type of object you want to use.
        List<Long> list = Collections.<Long>emptyList();
        // This is used when required type cannot be defined by compiler.
        // But in java 8 this is not required and cab be ommited.
        someMethod(Collections.<String>emptyList());
    }

    // For example this allowes to add integers.
    private static void addElements(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    private static void someMethod(List<String> list) {
        // print and do somethind..
    }

    private static class A<T> {
        @Override
        public String toString() {
            return "A{}";
        }
    }

    private interface Listener<T> {
        void onMessage(T message);
    }
    private static Collection<Listener<?>> listeners;
}
