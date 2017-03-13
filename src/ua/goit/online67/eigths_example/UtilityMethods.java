package ua.goit.online67.eigths_example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Example for utility methods.
 *
 * @author andreymi on 3/13/2017.
 */
public class UtilityMethods {
    // Sometimes in real life you need to create collections
    // that can be reused 1000 times:
    // 1. Collection of 1 element: requires 2 operation
    // 2. Create collection which no one can be modified.
    // 3. Create empty unmodifiable collection.
    //
    // In JDK java.util.Collections class is used for that purposes.
    // It looks inside as factory with private classes (as we have in prev lection).
    // 1. Create empty list, set, ... of any type.
    private Collection<String> emptyList = Collections.emptyList();
    private Collection<String> emptySet = Collections.emptySet();
    // 2. Create iterator which returns false on every hasNext().
    private Iterator<String> emptyIterator = Collections.emptyIterator();
    // 3. Create list, set of one element.
    private Collection<Integer> singleList = Collections.singletonList(1);
    private Collection<Integer> singleSet = Collections.singleton(1);
    // both of upper collections will have one element inside.
    // 4. Create collection (list, set) which noone can modify
    private Collection<Integer> nonMod = Collections.unmodifiableCollection(new ArrayList<>());
    private Collection<Integer> nonModList = Collections.unmodifiableList(new ArrayList<>());

    // lost of more options available.
    public static void main(String[] args) {
        // For example you want to create collection from array.
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        // btw this list is unmodifiable
        // 5. You can found min, max element (requires O(N) time).
        int max = Collections.max(integers);
        int min = Collections.min(integers);
        System.out.println(min + " : " + max);
        // method with comparator also exists
        // 6. Create list of n copies
        System.out.println(Collections.nCopies(10, 5));
        // 7. Sort lists (in java8 this method was put under List class.
        Collections.sort(integers);
        // 8. You can reverse lists.s
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Collections.reverse(list);
        System.out.println(list);
        // 9. or shuffle...
        Collections.shuffle(list);
        System.out.println(list);
        // And some other methods used in concurrent developments
    }
}
