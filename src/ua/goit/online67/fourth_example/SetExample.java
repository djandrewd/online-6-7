package ua.goit.online67.fourth_example;

import java.util.HashSet;
import java.util.Set;

/**
 * Example for sets collection.
 *
 * @author andreymi.
 */
public class SetExample {
    // Set is data structure which is holding only unique elements.
    // There two main implementation of Set in java: TreeSet and HashSet.
    // First lets cover hash set.
    private static Set<Integer> integers = new HashSet<>();

    private static class State {
        int val;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            State state = (State) o;
            return val == state.val;
        }

        @Override
        public int hashCode() {
            return val;
        }
    }

    public static void main(String[] args) {
        // To add element into set you can use already known method add:
        System.out.println(integers.add(1));
        // Now add will return false in case when set already contains same element.
        System.out.println(integers.add(1));
        System.out.println(integers);
        // As you see only only number exists in collection: how hash set keeping uniqueness?
        // Hash set is backed (inside) by hash map (will be covered in next lesson more)
        // which means that every time we add element into set next thing happens:
        // 1. Calculation of hash code and get of hash bucked.
        // 2. When two elements have equal hash code - java will search in bucked (linked list inside)
        // until found corresponding element
        ///
        // buckets = LinkedList[X];
        // 1. int hash = o.hashCode();
        // 2. LinkedList list = buckets[hash % X]
        // 3. if (!list.contains(o)) {
        //       list.add(o);
        // }
        // Worst case: O(N), best case - O(1).
        integers.add(1);
        System.out.println(integers.contains(1));
        // When we cannot use hash set?
        // 1. Storing arrays: arrays hash code are calculated using natives and changes everytime.
        int[] val1 = {1};
        int[] val2 = {1};
        Set<int[]> elements = new HashSet<>();
        System.out.println(elements.add(val1));
        System.out.println(elements.contains(val2));
        //2. Objects with mutable hash code.
        State s = new State();
        s.val = 10;
        Set<State> states = new HashSet<>();
        states.add(s);
        s.val = 20;
        // As you see event for same object reference element not found.
        System.out.println(states.contains(s));
        s.val = 10;
        System.out.println(states.contains(s));
        // So main rule - hash code and equals fields must be immutable.
    }
}
