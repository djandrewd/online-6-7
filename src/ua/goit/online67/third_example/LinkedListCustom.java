package ua.goit.online67.third_example;

import java.io.File;
import java.nio.file.FileVisitor;
import java.util.Iterator;

/**
 * Custom implementation of linked list.
 *
 * @author andreymi on 3/7/2017.
 */
public class LinkedListCustom {
    private static class Node {
        private Object value;
        private Node next;
    }

    public static class LList {
        private Node head;
        private Node tail;

        /**
         * Adds element to the end of linked list.
         */
        public void addLast(Object o) {
            Node node = new Node();
            node.value = o;
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            // a, head, tail = null
            // a, head = tail = a
            // b, tail.next = 'b' : a ->  b
            // b, tail = b, head = a
            tail.next = node;
            tail = node;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node node = head;
            // 1. node = a, node.next = b
            // 2. node = b, node.next = null
            // 3. node = null
            int i = 0;
            while (node != null) {
                builder.append(node.value);
                builder.append(" ");
                node = node.next;
                i++;
            }
            return builder.toString();
        }
    }

    public static class LinkedListIterator implements Iterator<Object> {
        private Node currNode;
        private LList list;

        public LinkedListIterator(LList list) {
            // Assign to current node head of the list.
            this.currNode = list.head;
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            // Return true in case when current node != null
            return currNode != null;
        }

        @Override
        public Object next() {
            Object value = currNode.value;
            currNode = currNode.next;
            return value;
        }

        @Override
        public void remove() {
            if (currNode == null) {
                return;
            }
            if (currNode.next == null) {
                if (list.head == currNode) {
                    list.head = null;
                }
                currNode = null;
                return;
            }
            // Nice? one of quizzes from interviews.
            currNode.value = currNode.next.value;
            currNode.next = currNode.next.next;
        }
    }

    public static void main(String[] args) {
        LList l = new LList();
        l.addLast(1);
        l.addLast(2);
        System.out.println(l);
    }

}
