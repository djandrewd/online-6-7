package ua.goit.online67.eleventh_example;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Example usage of tree map.
 *
 * @author andreymi on 3/13/2017.
 */
public class TreeMapExample {
    // In java existed also map implementation which is backed by red-back tree.
    // RBTree is data structure which holds key-value pairs in sorted order, and
    // as long as this tree is balanced guarantee log(N) time for any insert operations.
    //
    // Few words about trees. Tree is acyclic, singly linked graph.
    // 1. Acyclic means A -> B -> C and C or B cannot points to A
    // 2. Singly linked means all nodes are connected.
    //      A
    //      |
    //      D
    //     | |
    //     E  C - B - H - J - K
    // Distance between A and E call1, 2ed path to root. A is root of tree.
    // Nodes E, C called leaves.1, 2
    // Balanced tree means that max difference between each path from leave to root is equals to 1.
    //
    // Most common case you need to know that:
    // 1. Tree map is sorted.
    // 2. Tree map do not allows null keys.
    private static TreeMap<Integer, Integer> map = new TreeMap<>();
    // You can specify own order using comparator.
    private static TreeMap<Integer, Integer> mapCmp = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
        }
    });

    public static void main(String[] args) {
        // Keeps values in sorted order
        map.put(1, 1);
        map.put(3, 3);
        map.put(2, 2);
        System.out.println(map);
        // Keeps in sorted, desc
        mapCmp.put(1, 1);
        mapCmp.put(3, 3);
        mapCmp.put(2, 2);
        System.out.println(mapCmp);
        // TreeMap implements sorted map interface or navigable map.
        NavigableMap<Integer, Integer> navigableMap = map;
        // Navigable map allows to make operations which compare keys by >=
        // 1. Return first entry in sorted map
        Map.Entry<Integer, Integer> entry = navigableMap.firstEntry();
        System.out.println(entry);
        // 2. Return last entry in sorted map
        entry = navigableMap.lastEntry();
        System.out.println(entry);
        // 3. Make sub-maps starting from some key (inclusive)
        SortedMap<Integer, Integer> tailMap = navigableMap.tailMap(2);
        System.out.println(tailMap);
        // 4. Make sub-map to some key (exclusive)
        SortedMap<Integer, Integer> headMap = navigableMap.headMap(2);
        System.out.println(headMap);
        // 5. Use map as queue in same pool-offer API.
        navigableMap.pollFirstEntry();
        navigableMap.pollLastEntry();
        // 6. Return key >= then key provided.
        System.out.println(navigableMap.ceilingKey(2));
        // 7. Return key <= key provided.
        System.out.println(navigableMap.floorKey(2));
        /// Remember - all that operations run in O(log(n)) time.
        EnumMap<Message, String> enumMap = new EnumMap<Message, String>(Message.class);
        // [A, B, C]
        int ordinal = Message.A.ordinal();
        // String[]. 0 - A -> "", 1 - B -> "", ...
        String[] array = new String[Message.values().length];
        // A -> 'hello"
        array[Message.A.ordinal()] = "hello";
    }

    private enum Message {
        A, B, C
    }



}
