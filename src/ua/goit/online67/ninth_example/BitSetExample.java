package ua.goit.online67.ninth_example;

import java.util.BitSet;

/**
 * Example for bit-set
 *
 * @author andreymi on 3/13/2017.
 */
public class BitSetExample {
    // In java exists special structure for storing bits of some number.
    private static BitSet bitSet = new BitSet();
    public static void main(String[] args) {
        bitSet.set(0);
        bitSet.set(1);
        // upp result is 3
        // you can use also and, or, xor operations.
        // It is used when you want to manipulate bits in hashes, serialization, soon.
        // When you structure consists of flags - you can use bit set.
    }
}
