package ua.goit.online67.tenth_example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Example for hash maps.
 *
 * @author andreymi on 3/13/2017.
 */
public class HashMapExample {
    // In java exists also structure which is puts relations between one value to other value.
    // It is called map. This is general name, that was expired from c++ STL map.
    // So map put relation between key and value.
    private static Map<String, String> map;
    // First type parameter is type of key, second is type of value.
    // Upper example creates map between string and string.
    // In java exists three main map implementations: hash map, tree map and enum map.
    // Lets start from hash map.
    //
    // Idea of using hash map comes from hash table: for each key calculated some value named hash and stored
    // hash table mapped hash code to key and key to value.
    // But reality faces problem named hash collisions: when two elements can have same hash keys.
    // Hash collision has more serious consciences then just java hash maps: this is birthday attacks,
    // crypto collisions and soon.
    //
    // Return back to java:
    // Java map is not hash table. In classic hash table to get (add or remove) element you have to spend
    // maximum of O (1) operations. In java you might get O(N) (for large N from java8 - O (log(N)))
    //
    // How java hash map implemented and why O(N).
    // 1. Class Node actually form linked list of nodes.
    // 2. Linked lists of nodes are formed into array of buckets.
    // 3. To get element you calculate hash code X = object.hashCode()
    // 4. Calculate linked list by X % buckets.lenght
    // 5. Traverse list of node until found needed element.
    //
    // So when all elements have same hash code you will simply get same bucket and traverse of linked list
    // will always give you O(N).
    //
    // Lets create hash map and step-by-step check all possible API.
    private static Map<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        // To add relation into map key -> value use put method.
        // Method put returns previously stored element by key or null when no mapping was found.
        Object prev = hashMap.put("hello", "world");
        System.out.println(hashMap);
        System.out.println(prev);
        // To remove element from map use remove.
        prev = hashMap.remove("hello");
        System.out.println(hashMap);
        System.out.println(prev);
        // To get element by key use get method.
        hashMap.put("1", "2");
        System.out.println(hashMap.get("1"));
        // To check if element or value exists in map use containsKey
        // NOTE: values are not indexed so this method will return O(N) always.
        System.out.println(hashMap.containsKey("1"));
        System.out.println(hashMap.containsValue("2"));
        // of course size and isEmpty exists...
        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());
        // You can get set of all keys in hash map.
        // Key-value pairs may return not in same order as they was inserted.
        Set<String> keys = hashMap.keySet();
        // NOTE: removing key from this set will remove key-value mapping from map.
        // When you want to use only keys without mods: copy data from KeySet.
        System.out.println(keys);
        keys.remove("1");
        System.out.println(hashMap);
        // Also method values() exists which returns collections of all values.
        hashMap.put("3", "4");
        Collection<String> values = hashMap.values();
        System.out.println(values);
        // You can get set of key-value pairs: Map.Entry.
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        // as map do not extend iterable so using entries only option to traverse keys and values.
        // (before java8).
        for (Map.Entry<String, String> entry : entries) {
            // example how to get key and value.
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        // In java8 added new method which can return default value when mapping not found.
        System.out.println(hashMap.getOrDefault("5", "19"));;
        // To remove all entries use clear()
        hashMap.clear();
        // Other methods uses java8 specific things and will be covered later in this course.
    }

}
