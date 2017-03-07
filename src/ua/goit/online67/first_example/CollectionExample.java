package ua.goit.online67.first_example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * This is first basic example for java lists.
 *
 * @author andreymi.
 */
public class CollectionExample {
    // Collections in java is just gathering of elements in some data structure.
    // Most of collection type is java came from STL C++ and inherit their functionality.
    // In java there are lots of Collections : each of them used for some algorythmic purpose
    // Most of simple collections implementations have thread-safe copies for multithreading development.
    //
    // There are two main interfaces for all java collections API.
    private static Collection<Integer> collection;
    // Map is not child of Collection interface, but as long as it is needed for
    // gather some elements inside - it is collection in general case.
    private static Map<Integer, Integer> map;
    //
    // In whole world, in any type of programming language you will have next data structures:
    // 1. List
    // 2. Queue
    // 3. Map
    // 4. SetExample
    // 5. Tree
    // 6. Trie
    // 7. Bag
    //
    // Some of them do not have implementation in java. We will cover them mostly in next examples.
    //
    // Lets create list of integers and use array list implementation.
    private static Collection<Integer> arrayInts = new ArrayList<>();

    public static void main(String[] args) {
        // Lets check what methods class collections and list have and
        // then focus on array and linked list.
        //
        // To add element into collection (java.util.Collection) you
        // must use 'add' method. It returns true when element was added.
        //
        System.out.println(arrayInts.add(1));
        // To check if element exists in collection use - contains method.
        System.out.println(arrayInts.contains(1));
        // You can check size of collection and check if it is empty
        System.out.println(arrayInts.size());
        System.out.println(arrayInts.isEmpty());
        // You can remove element from collection.
        // Method remove return true is element was in collection, false otherwise
        System.out.println(arrayInts.remove(1));
        System.out.println(arrayInts.remove(1));
        // You can remove all elements.
        // Clear is void so it will remove all elements and you might even know what was inside.
        arrayInts.clear();
        // By the way - you call all all elements in collection from existed collection using add all
        List<Integer> old = new ArrayList<>();
        old.add(3);
        arrayInts.addAll(old);
        System.out.println(arrayInts);
        /// You can also transform your collection into array.
        // There are two methods for this toArray that return Object[] and other with
        // array parameter of type T.
        Object[] array1 = arrayInts.toArray();
        // When size of array you pass is same as collection
        // java will copy all elements in that array.
        // If not - java will create new copy of this array with needed size.
        Integer[] array2 = arrayInts.toArray(new Integer[]{});
        //
        // REMEMBER! Java arrays are not covariant.
        // Next assignment wont work, even if all elements of array1 are integers.
        //Integer[] array3 = (Integer[]) array1;
        //java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
        //
        // Other methods are used in java8 and wont be covered right now :)
    }


}
