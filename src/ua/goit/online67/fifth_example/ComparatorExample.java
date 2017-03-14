package ua.goit.online67.fifth_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator examples for collections.
 *
 * @author andreymi.
 */
public class ComparatorExample {
    // Sometimes we need to sort collections.
    // For this purposes in java existed two interfaces: Comparator and Comparable.
    //
    // Comparator is comparing two objects by main principle: for parameters (a,b)
    // 1. If two objects are equal: - return 0
    // 2. If object a bigger then object b :- return 1
    // 3. If object b is bigger then a: - return -1
    private static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -Integer.compare(o1, o2);
        }
    };
    // Comparable object is interface which class can implements and methid (compareTo) will have same contract as comparator
    private Comparable<Integer> val = 1;
    //
    //this
    public static void main(String[] args) {
        // You sort only collections which are feasible for this: lists.
        // Sorting in java is made using qsort and merge sort: both of them needs index access.
        List<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(1);
        integers.add(3);
        integers.add(2);
        Collections.sort(integers);
        System.out.println(integers);
        Collections.sort(integers, comparator);
        System.out.println(integers);
        // or from java8
        integers.sort(comparator);
        System.out.println(integers);
        // When use are using objects which are implementing Comparable you do not need to specify comparator.
        Collections.sort(integers);
        // Lest sort them in desc order.
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(integers);
    }
}
