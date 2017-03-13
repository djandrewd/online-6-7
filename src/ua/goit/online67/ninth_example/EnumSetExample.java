package ua.goit.online67.ninth_example;

import java.util.EnumSet;
import java.util.Set;

/**
 * Example for enum sets.
 *
 * @author  andreymi on 3/13/2017.
 */
public class EnumSetExample {
    // In Java exists very specific and powerful tool as enum set.
    // This is set which hold only elements of specified enum.
    enum Messages {
        HELLO,
        BYE,
        ECHO
    }
    // To create enum set you have to use factory methods: none of, all of, one of, etc.
    private static Set<Messages> messages = EnumSet.noneOf(Messages.class);

    public static void main(String[] args) {
        System.out.println(messages);
        messages = EnumSet.allOf(Messages.class);
        System.out.println(messages);
        messages = EnumSet.of(Messages.HELLO);
        System.out.println(messages);
        // What is interesting and important here?
        // 1. it uses only 64 bits to store data (if size of enum < 64)
        // 2. it is fast.
        // How it is achieved?
        // 1. When set created - bit mask for 64 bits is created inside.
        // 2. When enum X (with ordinal Y) added Y-bit set to 1
        // 3. To check is element exists iin set you check if his ordinal bit set to 1
        // (I think it uses few tacts in processor to check this)
        // Use this structure when you are using enum as elements.

    }

}
