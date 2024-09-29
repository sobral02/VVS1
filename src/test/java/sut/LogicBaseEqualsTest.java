package sut;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LogicBaseEqualsTest {

	
	@Test
    public void testEqualsCase1() {
        // A:T, B:T, C:T, P:T
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(2);
        ArrayNTree<Integer> tree2 = tree1;
        
        assertTrue(tree1.equals(tree2));
    }

    @Test
    public void testEqualsCase2() {
        // A:F, B:T, C:T, P:T
    	ArrayNTree<Integer> tree1 = new ArrayNTree<>(1,2);
    	ArrayNTree<Integer> tree2 = new ArrayNTree<>(1,2);
        
        assertTrue(tree1.equals(tree2));
    }

    @Test
    public void testEqualsCase3() {
        // A:F, B:T, C:F, P:F
    	ArrayNTree<Integer> tree1 = new ArrayNTree<>(2);
    	ArrayNTree<Integer> tree2 = new ArrayNTree<>(2);
        tree1.insert(1);
        tree2.insert(2);
        
        assertFalse(tree1.equals(tree2));
    }

    @Test
    public void testEqualsCase4() {
        // A:F, B:F, C:F, P:F
      	ArrayNTree<Integer> tree1 = new ArrayNTree<>(5,2);
        Object obj = new Object(); // Não é uma instância de NTree
       
        assertFalse(tree1.equals(obj));
    }
}
