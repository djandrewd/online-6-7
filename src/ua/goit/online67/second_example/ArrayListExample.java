package ua.goit.online67.second_example;

import java.util.ArrayList;
import java.util.List;

/**
 * Example using list that base on array.
 *
 * @author andreymi
 */
public class ArrayListExample {
    // First and most commonly used implementation of Collection is List.
    // Lists are collections in which you can add, get and remove element using index.
    // So this is list in arrays with only difference that list is dynamic sized.
    //
    // First implementation of list we will cover is ArrayList. We used it in previous
    // example.
    // ArrayList is List which holds array inside or backed by array (second you will always
    // see in tech literature).
    // What this means? When you create ArrayList it will create array of elements.
    // When def-constructor called - empty array will be created
    // (This is option started from java8, prior to this it will create array of size 10)
    private static List<Integer> integers1 = new ArrayList<>();
    // There are two main properties of array list: size and capacity
    // Size - is actual size of collection and capacity is size of array inside array list.
    // You can create array list with some predefined capacity.
    private static List<Integer> integers2 =  new ArrayList<>(1);

    public static void main(String[] args) {
        // Lets add element into array list.
        integers1.add(1);
        // Check size and capacity.
        System.out.println(integers1.size());
        // When size overflow capacity - capacity is increased into 1.5 times, new array created and
        // all elements copied.
        for (int i = 0; i < 10; i++) {
            integers1.add(i);
        }
        // Any get by index operation from array list will have complexity O (1) as array is used.
        System.out.println(integers1.get(0));
        // But add operation can last O(n) max time but balanced by O(1)
        // You can remove element from list by index.
        // This method will return previously stored element in that size.
        // When index is larger then size - IndexOutOfBoundsException will be thrown.
        System.out.println(integers1.remove(0));
        // Remove by index operation can sometimes cause all array be recopied so O(N) is max for this operation.
        // You can add element in specified index. In worst case you have to shift all elements
        // after this operation so that O (N) time is also complexity.
        integers1.add(0, 1);
        // Last operation is indexOf - you can get index of element by object or -1 if it is missed.
        // As long as it will traverse whole elements - it will bring you O (N) complexity.
        System.out.println(integers1.indexOf(1));

    }
}
