package ua.goit.online67.third_example;

import java.io.File;
import java.nio.file.FileVisitor;

/**
 * Created by andreymi on 3/7/2017.
 */
public class LinkedListCuston {
    private static class Node {
        private Object value;
        private Node next;
        //private Node prev;
    }

    private static class LList {
        private Node head;
        private Node tail;

        public void add(Object o) {
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

    public static void main(String[] args) {
        LList l = new LList();
        l.add(1);
        l.add(2);
        System.out.println(l);

        //File file = new File("/path/to/dir").listFiles();
        //file.isDirectory();file.getUsableSpace();file.isFile();
    }

}
