package ua.goit.online67.tenth_example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * Simple hash map implementation: hash table with separate chaining with list head cells
 * <p>
 * Created by andreymi on 3/21/2017.
 */
public class SimpleHashMap<K, V> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int INITIAL_CAPACITY = 1 << 4;

    private LinkedList<Entry<K, V>>[] entries;
    private int size;
    private int capacity;

    private SimpleHashMap() {
        this(DEFAULT_LOAD_FACTOR, INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    private SimpleHashMap(float loadFactor, int capacity) {
        this.capacity = capacity;
        this.entries = new LinkedList[capacity];
    }

    public V put(K key, V value) {
        // first hash code is calculated.
        // A, B
        // A != B
        // hashCode(A) == hashCode(B)
        int hashCode = key == null ? 0 : key.hashCode();
        // then bucket is calculated
        int bucket = hashCode % capacity;
        // then get linked list
        LinkedList<Entry<K, V>> list = entries[bucket];
        if (list == null) {
            // create new list if was not existed before.
            list = new LinkedList<>();
            entries[bucket] = list;
        }

        // key- A, value - V1 (A, V1) , (A, V2)
        // A - hash code 1, B - hash code 1, A != B
        // 1. elements = array[16]
        // 2. A. hashcodeA = 1. bucket = 1 % 16 = 1
        // 3. list = array[1]. (if list is empty, create)
        // 4. for (e : list): if e.key equals A (Object.equals) - rewrite value and return prev.
        // 5. add element A to end.
        //
        // [null, {A}, null, ..., null]
        //
        // 1. B. hashCodeB = 1. bucket = 1 % 16 = 1
        // 2. list = array[1].
        // 3. for (e : list) if e.key equals B.
        // 4. add element B to end.
        //
        // [null, {A -> B -> null}, null, ..., null]
        //
        // 1. Insert A. hashCode = 1
        // 2. A: hashCode = 1, bucket = 1
        // 3. list = array[bucket]
        // 4. for (e: list) if e.key equals A -> rewrite new value, return old.
        //
        // Try to find entry in the linked list.
        for (Entry<K, V> stored : list) {
            if (key == stored.getKey() || stored.getKey().equals(key)) {
                // replace entry that was found before
                return stored.setValue(value);
            }
        }
        // Increment size
        size++;
        // Create entry to insert and add it to the end.
        list.add(new Entry<>(key, value));
        // return null as nothing was found before.
        return null;
    }

    public int getSize() {
        return size;
    }

    private static class Entry<K, V>
            implements Map.Entry<K, V> {

        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V prev = value;
            this.value = value;
            return prev;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return key != null ? key.equals(entry.key) : entry.key == null;
        }

        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }


    }
}
