package Searching_Algorithms;

/**
 * Brute-Force Pattern Searching Algorithm
 * Run-Time : O(n * m), which n is the length of given text T and m is the length of given pattern P
 * @author Ee En Goh
 */
public class BruteForce {
	
	/** Number of pattern comparisons done in a matching-call */
    private static int comparisons = 0;

    public static void main(String[] args) {
    	
    	// Test Case 1 : Find pattern "rithm" within given String T
        String T = "a pattern matching algorithm";
        comparisons = 0;
        System.out.println("== Test Case 1 ==");
        System.out.println("index: " + match(T, "rithm"));
        System.out.println("comparisons done : " + comparisons + "\n");

    	// Test Case 2 : Find pattern "abacab" within given String T
        T = "abacaabaccabacabaabb";
        comparisons = 0;			// Reset comparison string index
        System.out.println("== Test Case 2 ==");
        System.out.println("index: " + match(T, "abacab"));
        System.out.println("comparisons done : " + comparisons + "\n");
        
    	// Test Case 3 : Find pattern "the" within given String T, with a given search starting index offset 
        T = "the cat sat on the back of the big red mat";
        comparisons = 0;			// Reset comparison string index
        System.out.println("== Test Case 3 ==");
        match(T, "the", 26);
        System.out.println("comparisons done : " + comparisons + "\n");
    }

    /**
     * Brute-Force pattern matching method to do the pattern matching from the given text T and pattern P
     * @param T		A given text in any characters sequence
     * @param P		A string pattern to do comparison and matching
     * @return		The first string index of the pattern if the pattern P is found in string T, else return -1
     */
    public static int match(String T, String P) {
        
    	int i = 0;				// Current reading string index of the given text T 
        int n = T.length(); 	// Character length of given text	
        int m = P.length();		// Character length of string pattern
        
        // Run-Time : O(n) (Generally , overall O(nm))
        while (i <= n - m) {
        
        	// Length of matching character to the pattern
        	int j = 0 ;
        	
        	// Run-Time : O(m)
            while ((j < m) && (T.charAt(i+j) == P.charAt(j))) {
                comparisons++;
                System.out.println("["+comparisons+"]\tT["+(i+j)+"]\t= "+T.charAt(i+j) +" ,\tP["+j+"]="+P.charAt(j));
                j++;
            }
            
            comparisons++;
            if (j == m) return i ; 	// The matching pattern is found within the given text
         
            System.out.println("["+comparisons+"]\tT["+(i+j)+"]\t= "+T.charAt(i+j) +" ,\tP["+j+"]="+P.charAt(j)+ "\tMISMATCH");
            
            i++;
        }
        System.out.println("Pattern " + P + " NOT FOUND");
        
        return -1;
    }
    
    /**
     * Modified version of the brute force search that uses the integer value offset to determine the index from which matching occurs
     * It is also printing out the start index of each occurrence pattern found
     * @param T			The given string to do the pattern searching
     * @param P			The string pattern to be found within text T
     * @param offset	The string index where the pattern searching start within the given text T
     * @return			The total number of pattern occurrence in the given text T
     */
    public static int match(String T, String P, int offset) {
    	
    	int i 					= offset;				// Current reading string index of the given text T    	
        int n 					= T.length(); 			// Character length of given text	
        int m 					= P.length();			// Character length of string pattern
        int patternOccurrence 	= 0;					// Count the number of occurrence of pattern P in the substring starts from offset
        int index[] = new int[(n - i)/m];				// Integer array to record all the string index(es) where the pattern is/are found
        
        if(offset > n - m) {
        	System.out.println("Invalid Parameter : Pattern won't found when the offset is larger than length of pattern P");
        	return -1;
        }
        	
        while (i <= n - m) {
        
        	// Length of matching character to the pattern
        	int j = 0 ;
        	
            while ((j < m) && (T.charAt(i+j) == P.charAt(j))) {
                comparisons++;
                System.out.println("["+comparisons+"]\tT["+(i+j)+"]\t= "+T.charAt(i+j) +" ,\tP["+j+"]="+P.charAt(j));
                j++;
            }
            
            comparisons++;
            
            // Case if the matching pattern is found within the given text
            if (j == m) {
            	index[patternOccurrence++] = i;
            	j = 0;		// Reset the counter of continuous character matching with pattern P
            }; 	
         
            System.out.println("["+comparisons+"]\tT["+(i+j)+"]\t= "+T.charAt(i+j) +" ,\tP["+j+"]="+P.charAt(j)+ "\tMISMATCH");
            
            i++;
        }
        
        // Case if no pattern P found in given text T
        if(patternOccurrence == 0) {
        	System.out.println("Pattern " + P + " NOT FOUND");
        	return -1;
        }
        
        // Output the numbers of pattern occurrence in text T and the string index(es) where they were found
        System.out.print("\nPattern found "+ patternOccurrence +" time(s) at index ");
        for(int k = 0 ; k < patternOccurrence ; k++) {
        	
        	System.out.print(index[k] + " ");
        	
        	if(k != patternOccurrence - 1)
        		System.out.print(", ");
        	else
        		System.out.println("");
        }
        
        return patternOccurrence;
    }
}
