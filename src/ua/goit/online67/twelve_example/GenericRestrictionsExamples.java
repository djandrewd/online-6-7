package ua.goit.online67.twelve_example;

/**
 * Restrictions on generic types.
 * <p>
 * Created by andreymi on 3/20/2017.
 */
public class GenericRestrictionsExamples {
    private static class A<T> {
        // You cannot create array of generics..
        // Array of class T can be existed, but..
        T[] array;

        public A() {
            // Not compiling.
            //this.array = new T[1];
            // Workaround...
            this.array = (T[]) new Object[]{};
            // Of course you cannot create typed elements
            //T t = new T();
        }
    }

    public static void main(String[] args) {
        // As instance of is working with classes only - using generics is forbidden
        A<Integer> a = new A<>();
        // use class only
        System.out.println(a instanceof A);
    }
}
