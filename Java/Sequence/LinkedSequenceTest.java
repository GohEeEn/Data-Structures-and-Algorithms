package Sequence;

import Common.Position;

public class LinkedSequenceTest {
	
	public static void main(String[] args) {
		
		// LinkedSequence<String> seq = new LinkedSequence<String>();
		insertByPosTest();
//		insertByRankTest();
		// System.out.println(seq);
	}
	
	private static void insertByPosTest() {
		
		LinkedSequence<String> seq = new LinkedSequence<String>();
		Position<String> pos;
		
		try {
			
			pos = seq.insertFirst("First");
			pos = seq.insertAfter(pos, "After First");
			pos = seq.insertAfter(pos, "After First Twice");
			pos = seq.insertLast("Last");
			pos = seq.insertBefore(pos, "Before Last");
			System.out.println(seq);
			System.out.println("insertByPosTest()\t\t: SUCCESS");
		} catch(Exception e) {
			System.out.println("insertByPosTest()\t\t: FAILURE");
			e.printStackTrace();
		}
	}
	
	private static void insertByRankTest() {
		
		LinkedSequence<String> seq = new LinkedSequence<String>();
		
		try {
			seq.insertAtRank(0, "new First");
			seq.insertAtRank(seq.size(), "new Last");
			seq.insertAtRank(seq.size() - 4, "rank 4");
			System.out.println("insertByRankTest()\t\t: SUCCESS");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(seq);
			System.out.println("insertByRankTest()\t\t: FAILURE");
		}
	}
}
