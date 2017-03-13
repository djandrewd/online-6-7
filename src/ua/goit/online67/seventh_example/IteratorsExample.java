package ua.goit.online67.seventh_example;

import ua.goit.online67.third_example.LinkedListCustom.LList;
import ua.goit.online67.third_example.LinkedListCustom.LinkedListIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Example working with Iterator structures.
 *
 * @author andreymi on 3/13/2017.
 */
public class IteratorsExample {
    // Word iterator comes from meaning of iterativity which means sequectially.
    // Iterator in java add possibility to traverse elements one by one.
    private static Iterator<Integer> iterator;

    // Iterator has 3 methods: hasNext(), next() and remove().
    // 1. hasNext - return true when next element is available to get.
    // 2. next - return next element in iterator.
    // 3. remove - removes current element, where iterator points to.
    //
    // Lest try to create our own iterator for array of ints.
    private static class ArrayIterator implements Iterator<Integer> {
        private int[] elements;
        private int pos;

        // We set position of cursor to -1 assume that
        // when iteration will start - next will return first element (0)
        public ArrayIterator(int[] elements) {
            this.elements = elements;
            this.pos = -1;
        }

        @Override
        public boolean hasNext() {
            // return true only in case when
            // our cursor position + 1 is less then array length
            return elements.length > pos + 1;
        }

        @Override
        public Integer next() {
            // 1. Increment position first
            // 2. Gets element on incremented position.
            return elements[++pos];
        }

        @Override
        public void remove() {
            // Do nothing in case when iteration is not started.
            if (pos < 0) {
                return;
            }
            // Create new array which holds the data with size less on 1
            int[] newArray = new int[elements.length - 1];
            // Copy all elements which was before current position into this array.
            System.arraycopy(elements, 0, newArray, 0, pos);
            // Now copy all elements that was after position
            System.arraycopy(elements, pos + 1, newArray, pos, elements.length - 1 - pos);
            pos--;
            elements = newArray;
        }
    }

    // As you already know not all collections can have methods that can get element by index.
    // So for this cases iterator is needed.
    // Also possible that collection is some reflection of data structure in database.
    // Assume it is table containing billions of records!
    // When we will load then all into memory we will simply consumer more resources that available.
    // But when we load only few records by calling next() and using iterations - will be save memory.
    // This is actually how JDBC works.
    public static void main(String[] args) {
        // Create array and assign it to iterator.
        int[] ar = {1, 2, 3, 4};
        for (Iterator<Integer> it = new ArrayIterator(ar); it.hasNext(); ) {
            Integer value = it.next();
            System.out.println(value);
        }
        // try remove some of elements.
        ArrayIterator it = new ArrayIterator(ar);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        // as you ssee our initial array is not changed, but resulting array is empty.
        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(it.elements));
        // Lets create iterator for linked list from example 3.
        LList list = new LList();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        Iterator<Object> iterator = new LinkedListIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator = new LinkedListIterator(list);
        while (iterator.hasNext()) {
            iterator.remove();
        }
        System.out.println(list);
        // In java each collection is extends interface Iterable which
        // return iterator for this collection.
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        Iterator<Integer> its = integers.iterator();
        while (its.hasNext()) {
            its.next();
            its.remove();
        }
        System.out.println(integers);
        // Remember some rules
        // 1. remove() method from iterator modifies collection.
        // 2. You cannot remove element from collection during iteration using any other options
        //    except Iterator.remove()
        //
        // Iterable interface is crusible for usage with for-each cycle.
        integers = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        for (int value : integers) {
            System.out.println(value);
        }
        // but gives error....
        //for (int value: integers) {
        //    System.out.println(value);
        //    integers.remove();
        //}
    }
}
