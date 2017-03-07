package ua.goit.online67.sixth_example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet implementation examples.
 *
 * @author andreymi on 3/7/2017.
 */
public class TreeSetExample {
    // TreeSet is another implementation of set.
    // Inside tree set is black-red tree which makes elements inside always sorted.
    private static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) {
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(2);
        System.out.println(set);
        // TreeSet elements must be comparable (implements comparable interface) or you can specify special order to do this.
        Set<Integer> descSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        descSet.add(1);
        descSet.add(4);
        descSet.add(3);
        descSet.add(2);
        System.out.println(descSet);
        // As long as all elements must be compared to put into set - null elements are not allowed.
        //descSet.add(null);
        //
        // Elements in tree set is compared by comparator, not by hash! So if comparator says objects are equal - they are equal
        // even their equal method return true.
        Set<A> aSet = new TreeSet<>();
        System.out.println(aSet.add(new A()));
        System.out.println(aSet.add(new A()));
        // All operations in tree set will always give you O(N)
    }

    private static class A implements Comparable<A> {

        @Override
        public int compareTo(A o) {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
}
