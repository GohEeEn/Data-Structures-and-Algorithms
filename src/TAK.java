/**
 * A recursive function used as a benchmark for languages which try to optimize recursion
 * @author 
 */
public class TAK{
	
	public static int tak( int x , int y , int z ) {
		
		if(y < x) {												// 1
			return tak(tak(x-1,y,z),tak(y-1,z,x),tak(z-1,x,y)); // Each recursion call creates 3 new operations 3 ^ ( x , y , z )
		}
		else 
			return z;											// 1
		
		// Total = 1 + max(O( f(m,n,p) , O(1) )) = O( f( m , n , p ) )  
	}
	
	public static void main(String[] args) {
		
		final long startTime = System.currentTimeMillis();
		System.out.println(tak(31,61,51));
		final long endTime = System.currentTimeMillis() - startTime;
		
		System.out.print("Input with time " + endTime);
	}
}