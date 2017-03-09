package ua.goit.online67.third_example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Examples of linked lists.
 *
 * @author andreymi
 */
public class LinkedListExample {
    // Another java list implementation is based on linked lists.
    // Linked list structure in java is doubly linked list.
    // Each node of linked list hold link to prev and next element.
    private static List<Integer> integers = new LinkedList<>();
    public static void main(String[] args) {
        // Basic structure of linked list is : Node <-> Node <-> Node -> null
        // To add element into linked list - java creates new node and add it to the end of list and prev last
        // node now links to new node.
        // As you might see no matter what happens add element will give constrant time.
        integers.add(1);
        // As linked list implements list interface it supports all
        // methods of list, but with one major change: all index operations now will take O(N) time.
        System.out.println(integers.get(0));
        // Why is this? Because everytime we need to get element from list we have to traverse all elements from the start till
        // we find needed index.
        // So why we need LinkedList?
        // Main advantage of using linked list is that he implements another interface we need : Queue.
        // 1 -> 2 -> 3
        Queue<Integer> queue = new LinkedList<>();
        // Queue is the data structure which holds element in FIFO order: first in - first out.
        // To add element into queue you can use either add or offer:
        queue.add(1);
        queue.offer(2);
        // Offer adds element to the end. To get them you have to use poll or peek.
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        // Difference in poll and peak is that: poll gets and removes values, peek - get and not remove.
        // Using linked list you can implement stack.
        // Linked list is also implement another interface: Deque which allowes to add elements either to the end or not the beginning.
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(2);
        deque.addLast(1);
        deque.addFirst(1);
        deque.pollFirst();
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        // Upper example is simple stack.
        // Linked lists use also more space then ArrayLists because of linked list node overhead.
    }

}
