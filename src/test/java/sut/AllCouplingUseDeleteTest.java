package sut;

import static org.junit.Assert.assertFalse;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AllCouplingUseDeleteTest {
	
	
	//position/index:
		//def: proposeposition 1 use:delete 11
    //children:
		//def: delete 11 use: delete 11
    
    @Test
    public void pos1to11andchildren11to11() {
    	List<Integer> list1 = Arrays.asList(6, 8, 10, 9);
        ArrayNTree<Integer> tree = new ArrayNTree<>(list1,2);
     
        
        tree.delete(8);
        assertFalse(tree.contains(8));
    }
    
    
    //position:
    	//def: delete 10 use:delete 10
    //children:
    	//def: delete 11 use: delete 11
    @Test
    public void pos10to10andchildren11to11() {
    	List<Integer> list1 = Arrays.asList(6, 8, 10, 9,11,12,13);
        ArrayNTree<Integer> tree = new ArrayNTree<>(list1,3);
       
        tree.delete(8);
        assertFalse(tree.contains(8));
    }
    
    //position:
    	//def: proposeposition 8 use:delete 11
    //children:
    	//def: delete 11 use: delete 11
    @Test
    public void pos8to11andchildren11to11() {
    	List<Integer> list1 = Arrays.asList(4, 5, 7, 6, 10);
        ArrayNTree<Integer> tree = new ArrayNTree<>(list1,2);
       
        
        tree.delete(7);
        assertFalse(tree.contains(7));
    }
    
    //position:
    	//def: proposeposition 6 use:delete 11
    //children:
    	//def: delete 11 use: delete 11
    @Test
    public void pos6to11andchildren11to11() {
    	List<Integer> list1 = Arrays.asList(4, 5, 7, 6, 10);
        ArrayNTree<Integer> tree = new ArrayNTree<>(list1,2);
        
        
        tree.delete(6);
        assertFalse(tree.contains(6));
    }
    
    //position:
    	//def: not defined use:not used
    //children:
    	//def: compact 9 use: delete 6
    @Test
    public void children9to6() {
    	List<Integer> list1 = Arrays.asList(4, 5);
        ArrayNTree<Integer> tree = new ArrayNTree<>(list1,2);
        
        tree.delete(4);
        assertFalse(tree.contains(4));
    }

}
