package Sorting_Algorithms;

import java.lang.reflect.Array;
import java.util.Random;
import List.LinkedList;
import List.List;

public class RadixSort {
    private static final int BASE = 10;

    private static Random random = new Random();
    private static List<Integer>[] buckets;

    /**
     * Static initialisation of the bucket array (here we are assuming that
     * the numbers are base 10 - hence 10 buckets)
     */
    static {
        buckets = (List<Integer>[]) Array.newInstance(List.class, BASE);
        for (int i=0; i < BASE; i++) {
            buckets[i] = new LinkedList<Integer>();
        }
    }

    /**
     * Simple test method
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> L = new LinkedList<Integer>();
        while (L.size() < 10) {
            L.insertLast(random.nextInt(100));
        }
        System.out.println(L);
        radixSort(L, 2);
        System.out.println(L);
    }

    /**
     * The top level radix sort method for Vectors of Integer values (with d digits)
     * @param V the values to be sorted
     * @param d the max number of digits in each value
     */
    public static void radixSort(List<Integer> V, int d) {
        for (int i=1; i<=d; i++) {
            bucketSort(V, i);
        }
    }

    /**
     * Performs a stable bucket sort for a given digit
     * @param V the vector to be sorted
     * @param i the digit to be sorted on
     */
    private static void bucketSort(List<Integer> V, int i) {
        int DIVISOR = pow(BASE, i-1);
        int MODULO = pow(BASE, i);

        // Put the values in the buckets
        while (!V.isEmpty()) {
            Integer value = V.remove(V.first());
            int index = (value / DIVISOR) % MODULO;
            buckets[index].insertLast(value);
        }

        // Put the values back into the vector
        for (List<Integer> bucket : buckets) {
            while (!bucket.isEmpty()) {
                V.insertLast(bucket.remove(bucket.first()));
            }
        }
    }

    /**
     * Method to return base to the power i
     * - could have used Math.pow(..) but that required casts (didn't like)
     * @param base the base
     * @param i the power that the base is raised to
     * @return the result
     */
    private static int pow(int base, int i) {
        int pow = 1;
        while (i > 0) {
            pow *= base;
            i--;
        }
        return pow;
    }
}
