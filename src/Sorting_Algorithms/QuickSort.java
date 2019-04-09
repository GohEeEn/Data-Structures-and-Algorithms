package Sorting_Algorithms;


import java.lang.reflect.Array;
import java.util.Random;

import List.LinkedList;
import List.List;
import Common.Position;

public class QuickSort {
    private static Random random = new Random();

    /**
     * Simple test method
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        while (list.size() < 100) {
            list.insertLast(random.nextInt(100));
        }
        System.out.println(list);
        quickSort(list);
        System.out.println(list);
    }

    /**
     * The main quicksort method
     * @param S the list being sorted
     * @param <T> the type of value stored in the list
     */
    public static <T extends Comparable<T>> void quickSort(List<T> S) {
        if (S.size() > 1) {
            Position<T> p = selectPivot(S);
            List<T>[] sublists = partition(S,p);
            quickSort(sublists[0]);
            quickSort(sublists[2]);
            join(S, sublists);
        }
    }

    /**
     * Method to join the lists L, E, G represented as an array of size 3
     * @param S the original list (now empty)
     * @param sublists the array of lists (L, E, G)
     * @param <T> the type of value stored in the list
     */
    private static <T extends Comparable<T>> void join(List<T> S, List<T>[] sublists) {
        for (int i=0;i<3; i++) {
            while (!sublists[i].isEmpty()) {
                S.insertLast(sublists[i].remove(sublists[i].first()));
            }
        }
    }

    /**
     * Method that selects a random pivot
     * @param S the list being sorted
     * @param <T> the type of value stored in the list
     * @return the position of the selected pivot
     */
    private static <T extends Comparable<T>> Position<T> selectPivot(List<T> S) {
        int index = random.nextInt(S.size());
        Position<T> current = S.first();
        while (index > 0) {
            current = S.next(current);
            index--;
        }
        return current;
    }

    /**
     * The partition method
     * @param S the List being partitioned
     * @param p the position of the pivot in the list
     * @param <T> the type of value stored in the list
     * @return an array of Lists containing L (index 0), E (index 1) and G (index 2)
     */
    private static <T extends Comparable<T>> List<T>[] partition(List<T> S, Position<T> p) {
        @SuppressWarnings("unchecked")
		List<T>[] sublists = (List<T>[]) Array.newInstance(List.class,3);
        sublists[0] = new LinkedList<T>();
        sublists[1] = new LinkedList<T>();
        sublists[2] = new LinkedList<T>();
        T x = (T) S.remove(p);

        while (!S.isEmpty()) {
            T y = S.remove(S.first());
            if (y.compareTo(x) < 0) {
                sublists[0].insertLast(y);
            } else if (y.compareTo(x) > 0) {
                sublists[2].insertLast(y);
            } else {
                sublists[1].insertLast(y);
            }
        }
        return sublists;
    }
}
