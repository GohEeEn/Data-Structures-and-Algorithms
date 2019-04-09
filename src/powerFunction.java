public class powerFunction{
	
	public static int power1(int a , int n) {
		
		int k = 0;			// 1
		int b = 1;			// 1
			
		while(k < n) {		// n ( k from 0 -> n )
			k++;			// n * 1
			b*=a;			// n * 1
		}
		return b;			// 1
	}						// Total = 1 + 1 + n * 3 + 1 = O(n)
	
	public static int power2(int a , int n) {
		
		int k = n;			// 1
		int b = 1;			// 1
		int c = a;			// 1
		
		while(k > 0) {		// Either log(n) or n 
			
			if(k%2==0) {	// 1
				k/=2;		// Divide k by 2 when the counter k is even , log(n) 
				c = c*c;	// log(n) * 1
			}
			else {
				k--;		// 1
				b *= c;		// 1
			}
		}
		return b;			// 1
	}						// As we see, if the value n is an even number, it will be divided by 2 multiple times (log n) -> When k = odd - 1 -> even again 
							// Thus, we can say that the occurrence of calculation for even number case will be the largest portion -> O(log n)
	
	public static void main(String[] args) {
		
		int a = 4 ; 
		int b = 3;
		
		
		System.out.println(power1(a,b)); 
		System.out.println(power2(a,b));
	}
}