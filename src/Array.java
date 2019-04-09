import java.util.Arrays;
import java.util.ArrayList;

public class Array{
	
	// Testing the Arrays class of Java
	public static void main(String[] args) {
		
		int[] a = { 3,4,45,5,6,6,4,2,12,3 };
		
		// toString
		System.out.println(a.toString()); // Output the hash code only
		
		// Arrays.toString
		System.out.println(Arrays.toString(a)); // Output of the array value
		
		// Sort the array ascendingly
		Arrays.sort(a); 
		
		System.out.println(Arrays.toString(a));
		
		// Fill the array with the same value 
		Arrays.fill(a,5);
		
		System.out.println(Arrays.toString(a));
		
		ListTest();
	}
	
	public static void ListTest() {
	
		ArrayList<Integer> list = new ArrayList<Integer>(1);
		
		int integer = 5;
		
		Integer what = Integer.valueOf(integer); // int -> Integer
		
		integer = what;							 // Auto-convert : int -> Integer
		
		String string = Integer.toString(integer); // int -> String
		string += "20";	 // String concatenation operation
		
		System.out.println(integer + " " + string );
		
		integer = Integer.parseInt(string);		// String -> int
		
		System.out.println(integer + " " + string );
		
		list.add(integer);
		list.add(integer);
		list.add(integer);
		list.add(integer);
		
		System.out.println(list.toString()); // Instantiate with 1 capacity but allows to store more elements
		// Automatically capacity extended
		
		System.out.println(list.size());
		list.trimToSize();	// Re-adjust the size of list to minimum used capacity to save memory space
		
		// Enhanced for-loop : for(ClassName currentObj : arrayListName)
		for(Integer e : list) {
			System.out.print(e + " ");
		}
	}
}