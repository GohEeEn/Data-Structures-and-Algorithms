package Stack;
import java.util.Random;
import java.util.Stack;
// import java.util.Timer;
// import java.util.function.Function;

/**
 * Program to test the run-time of stack operating methods in different implementations
 * Method : System.nanoTime()
 * 			Returns the current value of the most precise available system timer, in nanoseconds.
 * 
 * @author Ee En Goh
 */
public class StackRunTimeTest{
	
	// Testing performance of n push/pop operations of different implementations
	
	/**
	 * Operations test case for Stack class in JDK library
	 * @param s
	 * 		JDK library default stack class
	 * @param n
	 * 		Indicated as the size of input 
	 * @param rnd
	 * 		Random number generated as the input
	 */
	public static void stack_operation(Stack<Integer> s, int n, Random rnd) {
	for(int i = 0 ; i < n ; ++i) {
		
		if( rnd.nextFloat() < 0.3 )
			s.push(1);
		else {
				if(!s.isEmpty())
					s.pop();
			}
		}
	}
	
	/**
	 * Operations test case for LinkedList-Based Stack
	 * @param s
	 * 		JDK library default stack class
	 * @param n
	 * 		Indicated as the size of input 
	 * @param rnd
	 * 		Random number generated as the input
	 */
	// Overloaded Method
	public static void stack_operation(LinkedListStack<Integer> s, int n, Random rnd) {
		
		for(int i = 0 ; i < n ; ++i) {
			
			if( rnd.nextFloat() < 0.3 )
				s.push(1);
			else {
				if(!s.isEmpty())
					s.pop();
			}
		}
	}
	
	/**
	 * Operations test case for Array-Based Stack
	 * @param s
	 * 		JDK library default stack class
	 * @param n
	 * 		Indicated as the size of input 
	 * @param rnd
	 * 		Random number generated as the input
	 */
	// Overloaded Method
	public static void stack_operation(ArrayStack<Integer> s, int n, Random rnd) {
		
		for(int i = 0 ; i < n ; ++i) {
			
			if( rnd.nextFloat() < 0.3 )
				s.push(1);
			else {
				if(!s.isEmpty())
					s.pop();
			}
		}
	}
	
	/** Data Structure Test Case : <br/>JDK-Library Stack class */
	public static void test_stacks() {
		
		System.out.println("Analysis of DEFAULT STACK case [ JDK-Library ] ");
		Random rnd = new Random(1000);
		/*
		Function< Integer, Void > foo = (n) -> {
			
			Stack<Integer> s = new Stack<Integer>();
			// listStack<Integer> s = new listStack<Integer>();
			// TimeIt.stack_operation( s , n , rnd );
			long startTime = System.nanoTime();
			stack_operation( s , n , rnd );
			long endTime = System.nanoTime();
			
			return null;
		};
		*/
		// Stack<Integer> s = new Stack<Integer>();
		LinkedListStack<Integer> s = new LinkedListStack<Integer>();
		
		// Analysis Header 
		System.out.println( "Input" + "\t|" + "Duration (milli-second)");
		System.out.println( "================================");
		
		for( int n = 1 ; n < 10000000 ; n *= 2 ) {
			
			// double t = Timer.timeit(foo).apply(n);
			long startTime = System.nanoTime(); 
			stack_operation( s , n , rnd );
			long endTime = System.nanoTime();
			
			double duration = endTime - startTime;
			
			System.out.println( n + "\t|" + duration/1000000  );
		}
	}
	
	/** Data Structure Test Case : <br/>List-Based Stack */
	public static void test_listStacks() {
		
		System.out.println("Analysis of LIST-BASED stack case");
		Random rnd = new Random(1000);
	
		LinkedListStack<Integer> s = new LinkedListStack<Integer>();
		
		// Analysis Header 
		System.out.println( "Input" + "\t|" + "Duration (milli-second)");
		System.out.println( "================================");
		
		for( int n = 1 ; n < 10000000 ; n *= 2 ) {
			
			// double t = Timer.timeit(foo).apply(n);
			long startTime = System.nanoTime();
			stack_operation( s , n , rnd );
			long endTime = System.nanoTime();
			
			double duration = endTime - startTime;
			
			System.out.println( n + "\t|" + duration/1000000  );
		}
	}
	
	/** Data Structure Test Case : <br/>Array-Based Stack */
	public static void test_arrayStacks() {
		
		System.out.println("Analysis of ARRAY-BASED stack case");
		Random rnd = new Random(1000);
	
		ArrayStack<Integer> s = new ArrayStack<Integer>(10000);
		
		// Analysis Header 
		System.out.println( "Input" + "\t|" + "Duration (milli-second)");
		System.out.println( "================================");
		
		for( int n = 1 ; n < 10000000 ; n *= 2 ) {
			
			// double t = Timer.timeit(foo).apply(n);
			long startTime = System.nanoTime();
			stack_operation( s , n , rnd );
			long endTime = System.nanoTime();
			
			double duration = endTime - startTime;
			
			System.out.println( n + "\t|" + duration/1000000  );
		}
	}

	public static void main(String[] args) {
		test_stacks();
		System.out.println();
		test_listStacks();
		System.out.println();
		test_arrayStacks();
		
		/* 
		 * 	Result : Default > Array > List
		 * 	>> Issue : Array has finite capacity , either it is full or java heap space ( Out of Memory ) 
		 */
	}
}