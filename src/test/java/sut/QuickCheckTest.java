package sut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class QuickCheckTest {
		
	
    	//verifica se a invariança da arvore se mantem
	    public boolean stillInvariant(ArrayNTree<Integer> tree) {
	    	List<Integer> elems = tree.toList();
	    	for(int i = 0; i < elems.size()-1; i++) {
	    		if(elems.get(i)>=elems.get(i+1))
	    			return false;
	    	}
	    	return true;
	    }
		
		//prop1
	
		@Property
	    public void testShufflingDoesNotBreakInvariant(@From(RandomArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
			List<Integer> elems = tree.toList();
			Collections.shuffle(elems);
			    
			ArrayNTree<Integer> tree2 = new ArrayNTree<>(3);
			for(Integer elem : elems) {
				tree2.insert(elem);
			}
			
		
			assertTrue(stillInvariant(tree));
			assertTrue(stillInvariant(tree2));
		 }
		
		//prop2
		@Property
	    public void testDeleteAll(@From(RandomArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
			List<Integer> elems = tree.toList();
			    
		
			for(Integer elem : elems) {
				tree.delete(elem);
			}
			
		
			assertTrue(tree.isEmpty());
			

		 }
		
		//prop3
		@Property
	    public void testInsertAndDelete(@From(RandomArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
			ArrayNTree <Integer> backupTree = tree.clone();
			
			tree.insert(1000);
			tree.delete(1000);
	
		
			assertTrue(backupTree.equals(tree));
			

		 }
		
		//prop4
		@Property
	    public void testInsertSameElemets(@From(RandomArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
			ArrayNTree <Integer> backupTree = tree.clone();
			List<Integer> elems = tree.toList();
			
			    
			for(Integer elem : elems) {
				tree.insert(elem);
			}
			
		
			assertTrue(backupTree.equals(tree));
		 }
		
		//prop5
		@Property
	    public void testInsertSameElemetSeveralTimes(@From(RandomArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
			ArrayNTree <Integer> backupTree = tree.clone();
			List<Integer> elems = tree.toList();
			
			    
			for(int i = 0; i < 10; i++) {
				tree.insert(elems.get(0));
			}
			
		
			assertTrue(backupTree.equals(tree));
		 }
		
		
		
		
		
		

}
