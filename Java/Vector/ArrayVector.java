package Vector;

import java.util.Iterator;

/**
 * Array-implementation of data structure vector
 * - Objects stored in an array
 * 		After each operation, the index of the object corresponds to the rank
 * - Keep track of n , the current size of the vector
 * - Runtime Performance :
 * 		size()				O(1)	
 * 		isEmpty()			O(1)
 * 		elemAtRank(r)		O(1)
 * 		replaceAtRank(r,e)	O(1)
 * 		insertAtRank(r,e)	O(n)	Shifting operations must be performed on the arrays (Worst from rank 0)
 * 		removeAtRank(r)		O(n)	Shifting operations must be performed on the arrays (Worst from rank 0)
 * @author Ee En Goh
 * @param <T> Any object class that determines the stored value
 */
public class ArrayVector<T> implements Vector<T>, Iterable<T> {
    private T[] array;
    private int size;

    /**
     * Default constructor : Declare an array with length 10
     */
    public ArrayVector() {
        this(10);
    }

    /**
     * Overloaded constructor : Declare an array with given length 
     * @param capacity	Length of the new array
     */
    public ArrayVector(int capacity) {
        array = (T[]) new Object[capacity];
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T elemAtRank(int rank) {
        if (rank < 0 || rank > size-1) throw new RankOutOfBoundsException();
        return array[rank];
    }

    @Override
    public T replaceAtRank(int rank, T element) {
        if (rank < 0 || rank > size-1) throw new RankOutOfBoundsException();
        T temp = array[rank];
        array[rank] = element;
        return temp;
    }

    @Override
    public void insertAtRank(int rank, T element) {
        if (rank < 0 || rank > size) throw new RankOutOfBoundsException();

//      if (size == array.length) throw new VectorFullException(); 	Finite Capacity
        if (size == array.length) {								//	Extendable Array, doubling as it is the smallest integer multiple
            T[] newArray = (T[]) new Object[array.length*2];		
            for (int i=0;i<array.length;i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        int i = size;
        while (i > rank) {
            array[i] = array[i-1];
            i--;
        }
        array[rank] = element;
        size++;
    }

    @Override
    public T removeAtRank(int rank) {
        if (rank < 0 || rank > size-1) throw new RankOutOfBoundsException();

        T temp = array[rank];
        int i = rank;
        while (i < size-1) {
            array[i] = array[i+1];
            i++;
        }
        array[size-1] =null;
        size--;
        return temp;
    }

    public String toString() {
        String output = size + " / " + array.length + " :";
        for (int i=0; i<size;i++) {
            output += " "+array[i].toString();
        }
        return output;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }
}
