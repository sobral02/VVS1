package sut;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EdgePairCoverageTest {

	//T1
	@Test
	public void testThisEqualsOther() { //1-2
		List<Integer> list1 = Arrays.asList(10, 20, 21);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 3);
		ArrayNTree<Integer> tree2 = tree;

		boolean equals = tree.equals(tree2);
		assertTrue(equals);
	}
	
	//T2
	@Test
	public void testOtherNotInstance() { //1-3-4
		List<Integer> list1 = Arrays.asList(10, 20, 21);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 3);
		int otr = 1;

		boolean equals = tree.equals(otr);
		assertFalse(equals);
	}
	
	//T3
	@Test
	public void testOtherInstanceCallsEqulsTreeTrue() {//1-3-5-6
		List<Integer> list1 = Arrays.asList(10, 20, 21);
		List<Integer> list2 = Arrays.asList(10, 20, 21);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 3);
		ArrayNTree<Integer> tree2 = new ArrayNTree<>(list2, 3);

		boolean equals = tree.equals(tree2);
		assertTrue(equals);
	}
	
	//T4
	@Test
	public void testOtherInstanceCallsEqulsTreeFalse() {//1-3-5-7
		List<Integer> list1 = Arrays.asList(10, 20, 21);
		List<Integer> list2 = Arrays.asList(10, 20, 23);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 3);
		ArrayNTree<Integer> tree2 = new ArrayNTree<>(list2, 3);

		boolean equals = tree.equals(tree2);
		assertFalse(equals);
	}
	


}
