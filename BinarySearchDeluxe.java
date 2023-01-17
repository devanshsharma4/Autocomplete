import edu.princeton.cs.algs4.StdOut;
 
import java.util.Comparator;
 
public class BinarySearchDeluxe {
 
    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key,
                                         Comparator<Key> comparator) {
 
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException();
 
        if (a.length == 0)
            return -1;
 
        int lo = 0;
        int hi = a.length - 1;
 
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int compare = comparator.compare(key, a[mid]);
            if (compare <= 0) hi = mid;
            else lo = mid + 1;
        }
 
        if (comparator.compare(key, a[hi]) == 0)
            return hi;
        else return -1;
    }
 
    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key,
                                        Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException();
 
        if (a.length == 0)
            return -1;
 
        int lo = 0;
        int hi = a.length - 1;
 
        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);
            int compare = comparator.compare(key, a[mid]);
            if (compare >= 0) lo = mid;
            else hi = mid - 1;
        }
        if (comparator.compare(key, a[hi]) == 0)
            return hi;
        else return -1;
    }
 
 
    // unit testing (required)
    public static void main(String[] args) {
        // Test 1 of firstIndexOf method
        String[] a = { "A", "A", "C", "G", "G", "T" };
        int index = BinarySearchDeluxe.firstIndexOf(a, "G",
                                                    String.CASE_INSENSITIVE_ORDER);
        StdOut.println("Must print index of 3:");
        StdOut.println(index);
 
        // Test 2 of firstIndexOf method
        String[] b = { "A", "A", "A", "G", "G", "T" };
        int index2 = BinarySearchDeluxe.firstIndexOf(b, "A",
                                                     String.CASE_INSENSITIVE_ORDER);
        StdOut.println("Must print index of 0:");
        StdOut.println(index2);
 
        // Test 3 of firstIndexOf method
        String[] c = { "A", "A", "G", "G", "T", "T" };
        int index3 = BinarySearchDeluxe.firstIndexOf(c, "T",
                                                     String.CASE_INSENSITIVE_ORDER);
        StdOut.println("Must print index of 4:");
        StdOut.println(index3);
 
 
        // Test 1 of lastIndexOf method
        int index4 = BinarySearchDeluxe.lastIndexOf(a, "G",
                                                    String.CASE_INSENSITIVE_ORDER);
        StdOut.println("Must print index of 4:");
        StdOut.println(index4);
 
        // Test 2 of lastIndexOf method
        int index5 = BinarySearchDeluxe.lastIndexOf(b, "A",
                                                    String.CASE_INSENSITIVE_ORDER);
        StdOut.println("Must print index of 2:");
        StdOut.println(index5);
 
        // Test 3 of lastIndexOf method
        int index6 = BinarySearchDeluxe.lastIndexOf(c, "T",
                                                    String.CASE_INSENSITIVE_ORDER);
        StdOut.println("Must print index of 5:");
        StdOut.println(index6);
 
        // Testing with empty array (length 0)
        String[] empty = new String[0];
        int result = BinarySearchDeluxe.firstIndexOf(empty, "T",
                                                     String.CASE_INSENSITIVE_ORDER);
        StdOut.println("Must print -1");
        StdOut.println(result);
    }
}