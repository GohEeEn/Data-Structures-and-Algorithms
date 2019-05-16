package Pattern_Matching_Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Boyer-Moore Pattern-Searching Algorithm : <br>
 * - Enhancement of Brute-Force Pattern Matching Algorithm, that reduce the redundant comparison 
 * by pre-processing pattern P, with last occurrence function that list out 
 * all the unique character last occurrence in text T<br>
 * - Run-Time : O(nm), while significantly faster than Brute-Force Algorithm in Englishw<br>
 * @author Ee En Goh
 */
public class BoyerMoore {
	
	/** Number of pattern comparisons done in a matching-call */
    private static int comparisons = 0;

    public static void main(String[] args) {
    	
    	System.out.println("=== Test Case 1 ===");
        String T = "a pattern matching algorithm";
        comparisons = 0;
        System.out.println("First Occurrence Index\t: " + match(T, "rithm"));
        System.out.println("Comparisons done\t: " + comparisons);

        System.out.println("");
        
        System.out.println("=== Test Case 2 ===");
        T = "abacaabadcabacabaabb";
        comparisons = 0;
        System.out.println("First Occurrence Index\t: " + match(T, "abacab"));
        System.out.println("Comparisons done\t: " + comparisons);
        
        System.out.println("");
        
        // Test Case 3 : Find pattern "the" within given String T, with a given search starting index offset 
        System.out.println("=== Test Case 3 ===");
        T = "the cat sat on the back of the big red mat";
        comparisons = 0;			// Reset comparison string index
        match(T, "the", 0);
        System.out.println("Comparisons done\t: " + comparisons + "\n");
    }

    /**
     * Default Boyer-Moore Matching Algorithm, that return the index of first occurrence pattern P in given text T
     * @param T		Given text T to find the first occurrence of pattern P
     * @param P		Given pattern P
     * @return		The index of first occurrence pattern P in text T
     */
    public static int match(String T, String P) {
    	
        int n = T.length();
        int m = P.length();
        
        Map<Character, Integer> L = lastOccurrenceMap(P);	// Run-Time : O(s), size of map L
        
        // Pattern searching starts from the last character of pattern P
        int i = m - 1;	// Char counter in text T
        int j = m - 1;	// Match counter in pattern T

        do {
        	// System.out.print("["+ (comparisons+1) +"]\tBefore : i = " + i + "["+ T.charAt(i) +"]\t; j = " + j + " ["+ P.charAt(j) +"]  -");
            if (T.charAt(i) == P.charAt(j)) {
                // System.out.print("[ Match ]->\t");
            	
            	// Case if the full pattern P is found 
            	if (j == 0) {
            		comparisons++;
            		return i;
                    // System.out.println("Pattern [" + P + "] found!");
                    
                } // Else continue the character matching
            	else {
                    i--;
                    j--;
                }
            }  
            else {
                
                // if(j <= l + 1) {
            	// 		System.out.print("[Enter 1]->\t");
            	// }else
            	// 		System.out.print("[Enter 2]->\t");
            	
            	int l = lastOccurrence(L, T.charAt(i));	// Get the last occurrence of current character in pattern P
                i = i + m - Math.min(j, 1 + l); 		// ** 2 cases in here
                j = m - 1;
            }
            // System.out.print("After : i = " + i + "["+ T.charAt(i) +"]\t; j = " + j + " ["+ P.charAt(j) +"]\n");
            comparisons++;
        } while (i < n);

        return -1;
    }
    
    /**
     * Modified version of the Boyer-Moore pattern search that uses the integer value offset to determine the index of where the matching 
     * It is also printing out the start index of each occurrence pattern found
     * @param T			The given string to do the pattern searching
     * @param P			The string pattern to be found within text T
     * @param offset	The string index where the pattern searching start within the given text T
     * @return			The total number of pattern occurrence in the given text T
     */
    public static int match(String T, String P, int offset) {
    	
    	 int n = T.length();
         int m = P.length();
         
         // Case if the starting offset is too large to get a string with size m within text T
         if(offset > n - m) {
        	 System.out.println("Invalid Parameter : Pattern won't found in given text T when the offset is larger than length of pattern P");
        	 return 0;
         }
                 
         Map<Character, Integer> L = lastOccurrenceMap(P);		// Run-Time : O(s), size of map L
         ArrayList<Integer> index = new ArrayList<Integer>();	// ArrayList to store all the starting indexes of pattern P found in text T
         
         int patternOccurrence = 0;								// The number of pattern P found in text T
         int i = offset + m - 1; 								// Pattern search need to be start at offset
         int j = m - 1;
         
         do {
        	 System.out.print("["+ (comparisons+1) +"]\tBefore : i = " + i + "["+ T.charAt(i) +"]\t; j = " + j + " ["+ P.charAt(j) +"]  -");
         	 
        	 if(T.charAt(i) == P.charAt(j)) {
                
             	if (j == 0) {
                     comparisons++;
                     index.add(i);
                     patternOccurrence++;
                     System.out.print("[ Found ]->\t");
                     j = m - 1 ;
                     i += m ;
                 }else{
                     i--;
                     j--;
                     System.out.print("[ Match ]->\t");
                 }
             	
             } else {
            	 int l = lastOccurrence(L, T.charAt(i));
                 
            	 if(j <= l + 1) {
                 	System.out.print("[Enter 1]->\t");
                 }else
                 	System.out.print("[Enter 2]->\t");
            	 
                 i = i + m - Math.min(j, 1 + l);
                 j = m - 1;
             }
             System.out.print("After : i = " + i + "["+ T.charAt(i) +"]\t; j = " + j + " ["+ P.charAt(j) +"]\n");
             comparisons++;
         } while (i < n - m);
         
         System.out.println("\n=> Result <=");
         System.out.println("Text T\t\t\t: \"" + T + "\"");
         System.out.println("Pattern \'"+ P +"\' Found\t: " + patternOccurrence + " times") ;
         System.out.println("Pattern Found in\t: " + index.toString());
         

         return patternOccurrence;
    }

    /**
     * Method to create a map that store characters that appeared in pattern P, and pairing with an Integer object<br>
     * Run-Time : O(m)
     * @param P		The given pattern P
     * @return		The mapping of unique characters found in pattern P, and the occurrence of that character
     */
    public static Map<Character, Integer> lastOccurrenceMap(String P) {
    	
    	Map<Character, Integer> lof = new HashMap<Character, Integer>();
    	
    	// Insert new entry / update the last occurrence of current char to the entry
    	for(int i = 0 ; i < P.length() ; i++ ) 
    		lof.put(P.charAt(i), i);		
    	
    	// DEBUG
    	// System.out.println(lof);
    	
        return lof;
    }

    /**
     * Implementation of Last Occurrence Function by using Map, that record the last-occurrence of characters given in pattern  
     * @param L		Generated map of Character-Integer pair with unique characters in pattern P and its last occurrence index
     * @param c		Given character c
     * @return		The last occurrence index of character c in pattern P, else -1 (not exist)
     */
    public static int lastOccurrence(Map<Character, Integer> L, Character c) {
    	if(L.containsKey(c))
    		return L.get(c);
        return -1;
    }
}
