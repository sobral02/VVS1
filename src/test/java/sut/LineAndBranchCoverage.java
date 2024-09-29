package sut;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;


import org.junit.Test;

public class LineAndBranchCoverage {

	
	/// CONTAINS

	/**
	 *teste para o método contains de um elemento numa árvore vazia
	 */
	@Test
	public void testContainsEmptyTree() {
		ArrayNTree<Integer> tree = new ArrayNTree<>(3);

		boolean contains = tree.contains(1);
		assertFalse(contains);
	}

	/**
	 * teste para o método contains de um elemento que é a raíz da árvore
	 */
	@Test
	public void testContainsElementAtRoot() {
		ArrayNTree<Integer> tree = new ArrayNTree<>(1, 1);

		boolean contains = tree.contains(1);
		assertTrue(contains);
	}



	/**
	 * teste para o método equals de um elemento existente nos childrens
	 */
	@Test
	public void testContainsInChildren() {
		List<Integer> list = Arrays.asList(23, 99, 70, 95, 31, 45);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list, 3);

		boolean contains = tree.contains(45); //testar um dos filhos, tambem funcionaria com o 70 pois é filho de 31, 99 e 95 já não davam
		assertTrue(contains);
	}
	
	

	
	/// EQUALS
	

	/**
	 *  teste para o método equals a comparar duas árvores com a mesma
	 * referência
	 */
	@Test
	public void testEqualsTreesSameReferences() {
		List<Integer> list1 = Arrays.asList(10, 20, 21);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 3);
		ArrayNTree<Integer> tree2 = tree;

		boolean equals = tree2.equals(tree);
		assertTrue(equals);
	}

	/**
	 * teste para o método equals a comparar duas árvores iguais
	 */
	@Test
	public void testEqualsEqualTrees() {
		List<Integer> list1 = Arrays.asList(10, 20, 21);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 3);
		ArrayNTree<Integer> tree2 = new ArrayNTree<>(list1, 3);

		boolean equals = tree.equals(tree2);
		assertTrue(equals);
	}

	/**
	 *teste para o método equals a comparar duas árvores, com a primeira
	 * superior à segunda
	 */
	@Test
	public void testEqualsFirstTreeBigger() {
		List<Integer> list1 = Arrays.asList(10, 20, 21);
		List<Integer> list2 = Arrays.asList(10, 20);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 3);
		ArrayNTree<Integer> tree2 = new ArrayNTree<>(list2, 2);

		boolean equals = tree.equals(tree2);
		assertFalse(equals);
	}

	/**
	 *teste para o método equals a comparar duas árvores, com a segunda
	 * superior à primeira
	 */
	@Test
	public void testEqualsSecondTreeBigger() {
		List<Integer> list1 = Arrays.asList(10, 20);
		List<Integer> list2 = Arrays.asList(10, 20, 22);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 2);
		ArrayNTree<Integer> tree2 = new ArrayNTree<>(list2, 3);

		boolean equals = tree.equals(tree2);
		assertFalse(equals);
	}
	
	

	/**
	 * teste para o método equals a comparar uma árvore com um outro objeto
	 */
	@Test
	public void testEqualsObjectOther() {
		List<Integer> list1 = Arrays.asList(10, 20, 21);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 3);

		boolean equals = tree.equals(0);
		assertFalse(equals);
	}

	/**
	 * teste para o método equals para uma árvore cujos elementos intersetam
	 * parte dos elementos de uma árvore maior
	 */
	@Test
	public void testEqualsTreeContainsOther() {
		List<Integer> list1 = Arrays.asList(10, 20, 21, 30, 35, 40);
		List<Integer> list2 = Arrays.asList(10, 21, 30, 35);
		ArrayNTree<Integer> tree = new ArrayNTree<>(list1, 3);
		ArrayNTree<Integer> tree2 = new ArrayNTree<>(list2, 3);

		boolean equals = tree.equals(tree2);
		assertFalse(equals);
	}
	
	 /**
     * Teste para verificar se o método equalTrees verifica quando apenas a segunda árvore está vazia.
     */
    @Test
    public void testEqualTreesSecondEmpty() {
        List<Integer> list1 = Arrays.asList(10, 20, 21);
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(list1, 3);
        ArrayNTree<Integer> tree2 = new ArrayNTree<>(1);

        boolean equals = tree1.equals(tree2);
        assertFalse(equals);
    }

    /**
     * Teste para verificar se o método equalTrees verifica quando apenas uma árvore está inicializada.
     */
    @Test
    public void testEqualTreesOneInitialized() {
        List<Integer> list1 = Arrays.asList(10, 20, 21);
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(list1, 3);
        ArrayNTree<Integer> tree2 = null;

        boolean equals = tree1.equals(tree2);
        assertFalse(equals);
    }
	
	
	
	//os proximos testes exempleficam de verificações em falta no metod equalTrees
	
	/**
	 * teste para o método equals a comparar duas árvores vazias
	 */
	@Test
	public void testEqualsTwoEmptyTrees() {
		ArrayNTree<Integer> tree1 = new ArrayNTree<>(1);
		ArrayNTree<Integer> tree2 = new ArrayNTree<>(1);
		assertThrows(NullPointerException.class, () -> {tree1.equals(tree2);}); //deveria ser true
	}

    /**
     * Teste para verificar se o método equalTrees verifica quando apenas a primeira árvore está vazia.
     */
    @Test
    public void testEqualTreesFirstEmpty() {
        ArrayNTree<Integer> tree1 = new ArrayNTree<>(1);
        List<Integer> list2 = Arrays.asList(10, 20, 21);
        ArrayNTree<Integer> tree2 = new ArrayNTree<>(list2, 3);

        assertThrows(NullPointerException.class, () -> {tree1.equals(tree2);}); //deveria ser false como o dois ultimos testes feitos para o equalsTree
    }

   

	
	
	
	
}