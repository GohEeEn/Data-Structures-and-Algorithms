package Searching_Algorithms;

/**
 * Knuth-Morris-Platt Pattern Matching Algorithm<br>
 * Time-Complexity : O(m + n), which m is the length of pattern P and n is the length of given text T
 * @author Ee En Goh
 */
public class KMP {
	
	/** Number of pattern matching made in a matching-call */
    private static int comparisons = 0;

    public static void main(String[] args) {
    	
    	System.out.println(" === Test Case 1 === ");
        String T = "a pattern matching algorithm";
        comparisons = 0;
        System.out.println("First match index\t: " + match(T, "rithm"));	// Not repeat occurrence of characters in pattern P, thus 0
        System.out.println("Comparisons made\t: " + comparisons);

        System.out.println("");
        
        System.out.println(" === Test Case 2 === ");
        T = "abacaabaccabacabaabb";
        comparisons = 0;
        System.out.println("First match index\t: " + match(T, "abacab"));
        System.out.println("Comparisons made\t: " + comparisons);
        
        System.out.println(" === Test Case 3 === ");
        T = "mommyiscommingbackfromhome";
        comparisons = 0;
        System.out.println("First match index\t: " + match(T, "mm"));
        System.out.println("Comparisons made\t: " + comparisons);
        
        System.out.println("");
        
        System.out.println("Test Case for failure method : ");
        
        System.out.println("== Test Case 1 ==");
        failureFunction("mimicmicdropdance");
        
        System.out.println("== Test Case 2 ==");
        failureFunction("seashellseashoresmlj");
        
        System.out.println("== Test Case 3 ==");
        failureFunction("iknowwhatyouwantnow");
    }

    /**
     * Knuth-Morris-Pratt Algorithm (KMP) to do the pattern matching of given text T and given pattern P
     * @param T		Given text T
     * @param P		Given pattern P, which is the target pattern in text T
     * @return		
     */
    public static int match(String T, String P) {
    	
        int n = T.length();
        int m = P.length();
        int[] F = failureFunction(P);	// Preprocessing the pattern P
        
        int i = 0;	// Character counter of given String T
        int j = 0;	// Pattern matching counter 
        
        // Search for the whole String T
        while (i < n) {
        	
        	// Case if a character match between T and P
            if (T.charAt(i) == P.charAt(j)) { 
            	
            	// Case if the full pattern found
                if (j == m - 1) {
                    comparisons++;
                    return i - j;	// TODO
                    
                } else {	// Increment of i and j (continuous character match counter until pattern match)
                    i++;
                    j++;
                }
                
            } // Not a character match 
            else {
                
            	// A mismatch right after character matching
            	if (j > 0) {
                    j = F[j - 1];	// Get the failure 
                    
                } else { // Normal mismatch
                    i++;
                }
            }
            comparisons++;
        }
        return -1;	// No pattern P found in text T
    }
    
    /**
     * Preprocessing the pattern P, to find out the largest prefix which is also a suffix, of the pattern P[0..i];
     * Run-Time : O(m)
     * @param P		Given pattern P
     * @return		An integer array that contains the largest index of pattern while doing matching
     */
    public static int[] failureFunction(String P) {
    	
    	/** integer array to store the length of the maximum matching prefix, which is also a suffix of given pattern P */
        int[] F = new int[P.length()];
        int pLength = P.length();
        
        int i = 1;	// Character counter, increment by 1 for every comparison made	
        int j = 0;	// Matching counter, increment by 1 once char match (keep increment if continuous char match, else mismatch it will be restored to 0)
        
        while(i < pLength) {
        	
        	// If the current prefix matches its suffix , eg. P[] = aba -> P[0] == P[2] 
        	if(P.charAt(i) == P.charAt(j)) {
        		
        		F[i] = j + 1;	// Increment skipping counter
        		i++;			
        		j++;			// A matching found
        		
        	} 	// Case of current char matches the previous prefix 
        		// Not a current matching, while can't be counted as a mismatch too 
        	else if(j > 0)
        		j = F[j - 1];	//  
        	
        	// Continuous Mismatch 
        	else {
        		F[i] = 0;		// No match -> 0
        		i++;
        	}
        }
        
        displayPatternInP(P,F);
        
        return F; // Contain the string index of where the searching should starts from, for each corresponding character after a mismatch
    }
    
    public static void displayPatternInP(String P, int[] F) {
    	
    	/* Display all the pattern found in pattern P */
        System.out.println("Pattern found within the given pattern : " + P);
        
        int counter = 0;
        boolean patternFound = false;
        
        for(int k = 1 ; k < P.length() ; k++) {
        	
        	// Character with pattern match found
        	if(F[k] > counter) {
        		System.out.print(P.charAt(k));
        		patternFound = true;
        		counter++;
        		
        	}else if(F[k-1] > F[k]) {
        		System.out.println("");
        		counter = 0;
        	}
        }
        
        if(!patternFound)
        	System.out.println("Pattern Not Found");
        else
        	System.out.println("");
    }
}
