package Vector;

public class VectorTest {
    public static void main(String[] args) {
        
    	ArrayVector<String> vector = new ArrayVector<String>();			// Testing Array-based implementation vector
    	// LinkedVector<String> vector = new LinkedVector<String>();	// Testing Linked-based implementation vector
        
        vector.insertAtRank(0, "A");
        System.out.println("After insertion of element A at rank 0 :");
        System.out.println(vector);	// A
        
        System.out.println();
        
        vector.insertAtRank(1, "B");
        System.out.println("After insertion of element B at rank 1 :");
        System.out.println(vector);	// A B
        
        System.out.println();
        
        vector.insertAtRank(2, "C");
        System.out.println("After insertion of element C at rank 2 :");
        System.out.println(vector);	// A B C
        
        System.out.println();
        
        vector.insertAtRank(1, "D");     
        System.out.println("After insertion of element D at rank 1 :");
        System.out.println(vector);	// A D B C 
        
        System.out.println();
        
        vector.insertAtRank(1, "E");
        System.out.println("After insertion of element E at rank 1 :");
        System.out.println(vector);	// A E D B C
        
        // ----- insertAtRank method test cases done -----
        
        System.out.println();
        // System.out.println(vector.elemAtRank(-1)); 	// out of range of rank
        System.out.println("Element in rank 0 : " + vector.elemAtRank(0));		// A, front element
        System.out.println("Element in rank 3 : " + vector.elemAtRank(3));		// B, middle element
        System.out.println("Element in rank 4 : " + vector.elemAtRank(4));		// C, rear element
        // System.out.println(vector.elemAtRank(5)); 	// out of range of rank
        
        // ----- elemAtRank method test cases done ------
        
        System.out.println();
        
        vector.removeAtRank(1);		// remove the middle element
        System.out.println("After removal of element at rank 1 :");
        System.out.println(vector + " , size : " + vector.size());	// A D B C
        
        System.out.println();
        
        vector.removeAtRank(3);		// remove the last element
        System.out.println("After removal of element at rank 3 :");
        System.out.println(vector + " , size : " + vector.size());	// A D B
        
        System.out.println();
        
        vector.removeAtRank(0);		// remove the front element
        System.out.println("After removal of element at rank 0 :");
        System.out.println(vector + " , size : " + vector.size());	// D B
        
        // ----- removeAtRank method test cases done -----
        
        System.out.println();
        
        vector.insertAtRank(2, "F");
        System.out.println("After insertion of element F at rank 2 :");
        System.out.println(vector + " , size : " + vector.size());	// D B F
        
        System.out.println();
        
        vector.replaceAtRank(0, "G");	// Replace the front element
        System.out.println("After replacement of element at rank 0 with value G :");
        System.out.println(vector + " , size : " + vector.size());	// G B F
        
        System.out.println();
        
        vector.replaceAtRank(2, "H");	// Replace the rear element
        System.out.println("After replacement of element at rank 2 with value H :");
        System.out.println(vector + " , size : " + vector.size());	// G B H
        
        System.out.println();
        
        vector.replaceAtRank(1, "I");	// Replace the middle element
        System.out.println("After replacement of element at rank 1 with value I :");
        System.out.println(vector + " , size : " + vector.size());	// G I H
        
        // ----- replaceAtRank method test cases done -----
    }
}
