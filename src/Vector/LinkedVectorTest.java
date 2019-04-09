package Vector;

public class LinkedVectorTest {
	public static void main(String[] args) {
		testEmptyVector();
		testAltEmptyVector();
		testOneElementVector();
		testOneElementSizeVector();
		testElemAtRank();
		testRemoveAtRank();
		testRemoveAtEnd();
		testReplaceAtRank();
		testInsertAtRankFirst();
		testInsertAtRankRear();
	}

	/**
	 * test calling the isEmpty() method to check if the vector is empty, namely
	 * size == 0
	 */
	public static void testEmptyVector() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			if (!vector.isEmpty()) {
				System.out.println("testEmptyVector(): FAILURE");
				System.out.println("Expected vector to be empty");
			} else {
				System.out.println("testEmptyVector(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testEmptyVector(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * test that calls the size() method to see if vector is empty, namely size == 0
	 */
	public static void testAltEmptyVector() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			if (vector.size() != 0) {
				System.out.println("testAltEmptyVector(): FAILURE");
				System.out.println("Expected vector to be empty");
			} else {
				System.out.println("testAltEmptyVector(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testAltEmptyVector(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * test that calls the method vector.size() to check if the insertion method
	 * insertAtRank() was successful and to see if vector.size() works
	 */
	public static void testOneElementVector() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.insertAtRank(0, "A");
		} catch (RuntimeException e) {
			System.out.println("testOneElementVector(): FAILURE");
			System.out.println("insertAtRank(...) threw an exeception");
			e.printStackTrace();
			return;
		}

		try {
			if (vector.size() != 1) {
				System.out.println("testOneElementVector(): FAILURE");
				System.out.println("Expected vector to be empty");
			} else {
				System.out.println("testOneElementVector(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testOneElementVector(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * test that does the same as above, but within a smaller scope
	 */
	public static void testOneElementSizeVector() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.insertAtRank(0, "A");

			if (vector.size() != 1) {
				System.out.println("testOneElementSizeVector(): FAILURE");
				System.out.println("Expected vector.size() to be 1");
			} else {
				System.out.println("testOneElementSizeVector(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testOneElementSizeVector(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * test calling the elemAtRank() method to see the element in the specified rank
	 */
	public static void testElemAtRank() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.insertAtRank(0, "A");
			vector.insertAtRank(1, "B");

			if (vector.elemAtRank(1) != "B") {
				System.out.println("testElemAtRank(): FAILURE");
				System.out.println("Expected vector.elemAtRank() to be 'B'");
			} else {
				System.out.println("testElemAtRank(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testElemAtRank(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * test calling the removeAtRank() method to remove the element at the specified
	 * rank
	 */
	public static void testRemoveAtRank() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.insertAtRank(0, "A");
			
			if (vector.removeAtRank(0) != "A") {
				System.out.println("testRemoveAtRank(): FAILURE");
				System.out.println("Expected vector.removeAtRank() to be 'A'");
			} else {
				System.out.println("testRemoveAtRank(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testRemoveAtRank(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}
	
	/**
	 * test calling the removeAtRank() method to remove the element at the specified
	 * rank
	 */
	public static void testRemoveAtEnd() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.insertAtRank(0, "A");
			vector.insertAtRank(1, "B");
			vector.insertAtRank(2, "C");
			
			if (vector.removeAtRank(1) != "B") {
				System.out.println("testRemoveAtEnd(): FAILURE");
				System.out.println("Expected vector.removeAtRank() to be 'B'");
			} else {
				System.out.println("testRemoveAtEnd(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testRemoveAtEnd(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * test calling the replaceAtRank() method to replace the element with the
	 * specified element, at the specified rank
	 */
	public static void testReplaceAtRank() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.insertAtRank(0, "A");
			/*
			 * if (vector.size() == 1 && vector.replaceAtRank(0, "B") != "B") {
			 * System.out.println("testReplaceAtRank(): FAILURE");
			 * System.out.println("Expected vector.replaceAtRank() to be 'B'"); }
			 * 
			 * else if (vector.size() > 1 && vector.replaceAtRank(0, "B") != "B") {
			 * System.out.println("testReplaceAtRank(): FAILURE");
			 * System.out.println("Expected vector.replaceAtRank() to be 'B'");
			 */

			if (vector.replaceAtRank(0, "B") != "A") {
				System.out.println("testReplaceAtRank(): FAILURE");
				System.out.println("Expected vector.replaceAtRank() to be 'A'");
			} else {
				System.out.println("testReplaceAtRank(): SUCCESS");
			}
		} catch (RuntimeException e) {
			System.out.println("testReplaceAtRank(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * Test calling the insertAtRank() method. This test will see if any two ranks
	 * exist, it will prioritize the latest entry with a higher rank, and will also
	 * show that we can insert at the start
	 */
	public static void testInsertAtRankFirst() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.insertAtRank(0, "A");
			vector.insertAtRank(0, "B");
			
			
			if (vector.elemAtRank(0) != "B") {
				System.out.println("testInsertAtRankFirst(): FAILURE");
				System.out.println("Expected vector.testReplaceAtRankFirst() to be 'B'");
			} else {
				System.out.println("testInsertAtRankFirst(): SUCCESS");
			}

		} catch (RuntimeException e) {
			System.out.println("testInsertAtRankFirst(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}

	/**
	 * Test calling the insertAtRank() method. This test will see if any two ranks
	 * exist, it will prioritize the latest entry with a higher rank, and will also
	 * show that we can insert at the end
	 */
	public static void testInsertAtRankRear() {
		Vector<String> vector = new LinkedVector<String>();

		try {
			vector.insertAtRank(0, "A");
			vector.insertAtRank(1, "B");
			vector.insertAtRank(2, "C");

			if (vector.elemAtRank(2) != "C") {
				System.out.println("testInsertAtRankRear(): FAILURE");
				System.out.println("Expected vector.testReplaceAtRankRear() to be 'C'");
			} else {
				System.out.println("testInsertAtRankRear(): SUCCESS");
			}

		} catch (RuntimeException e) {
			System.out.println("testInsertAtRankRear(): MAJOR FAILURE");
			e.printStackTrace();
		}
	}
}