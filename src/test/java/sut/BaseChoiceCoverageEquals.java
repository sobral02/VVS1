package sut;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.Test;

public class BaseChoiceCoverageEquals {
	
	
	//[!tree1empty, !tree2empty, !tree2null, empty]
	// Testa se tree1 não está vazia, tree2 não está vazia, tree2 não é nula
    // e a interseção entre tree1 e tree2 é vazia.
    @Test
    public void testEquals_NotEmptyNotEmptyNotNull_EmptyIntersection() {
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(Arrays.asList(1, 2, 3), 3);
        ArrayNTree<Integer> tree2 = new ArrayNTree<>(Arrays.asList(4, 5, 6), 3);
        
        assertFalse(tree1.equals(tree2));
    }

    //[!tree1empty, !tree2empty, !tree2null, parcial]
    // Testa se tree1 não está vazia, tree2 não está vazia, tree2 não é nula
    // e a interseção entre tree1 e tree2 é parcial.
    @Test
    public void testEquals_NotEmptyNotEmptyNotNull_PartialIntersection() {
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(Arrays.asList(1, 2, 3), 3);
        ArrayNTree<Integer> tree2 = new ArrayNTree<>(Arrays.asList(3, 4, 5), 3);
        
        assertFalse(tree1.equals(tree2));
    }
    
    //[!tree1empty, !tree2empty, !tree2null, full]
    // Testa se tree1 não está vazia, tree2 não está vazia, tree2 não é nula
    // e a interseção entre tree1 e tree2 é completa.
    @Test
    public void testEquals_NotEmptyNotEmptyNotNull_FullIntersection() {
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(Arrays.asList(1, 2, 3), 3);
        ArrayNTree<Integer> tree2 = new ArrayNTree<>(Arrays.asList(1, 2, 3), 3);
        
        assertTrue(tree1.equals(tree2));
    }
    
    //[tree1empty, !tree2empty, !tree2null, empty]
    // Testa se tree1 está vazia, tree2 não está vazia, tree2 não é nula
    // e a interseção entre tree1 e tree2 é vazia.
    @Test
    public void testEquals_EmptyNotEmptyNotNull() {
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(3);
        ArrayNTree<Integer> tree2 = new ArrayNTree<>(Arrays.asList(1, 2, 3), 3);
        
        assertThrows(NullPointerException.class, () -> {tree1.equals(tree2);});  //da erro porque o equlas tem bugs...
    }
    //[!tree1empty, tree2empty, !tree2null, empty]
    // Testa se tree1 não está vazia, tree2 está vazia, tree2 não é nula
    // e a interseção entre tree1 e tree2 é vazia.
    @Test
    public void testEquals_NotEmptyEmptyNotNull() {
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(Arrays.asList(1, 2, 3), 3);
        ArrayNTree<Integer> tree2 = new ArrayNTree<>(3);
        
        assertFalse(tree1.equals(tree2));
    }
    
    //[!tree1empty, !tree2empty, tree2null, empty]
    // Testa se tree1 não está vazia, tree2 não é vazia, tree2 é nula
    // e a interseção entre tree1 e tree2 é vazia.
    @Test
    public void testEquals_NotEmptyNotEmptyNull() {
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(Arrays.asList(1, 2, 3), 3);
        ArrayNTree<Integer> tree2 = null;
        
        assertFalse(tree1.equals(tree2));
    }
    
    

}
