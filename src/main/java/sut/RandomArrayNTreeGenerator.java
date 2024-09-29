package sut;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;


public class RandomArrayNTreeGenerator extends Generator<ArrayNTree<Integer>> {

    public static final int MAX_SIZE = 25;
    public static final int MAX_ELEMENT = 100; //Na  verdade vai ser até 200

    public RandomArrayNTreeGenerator(Class<ArrayNTree<Integer>> type) {
        super(type);
    }

    @Override
    public ArrayNTree<Integer> generate(SourceOfRandomness src, GenerationStatus status) {
        int size = src.nextInt(1, MAX_SIZE); // Tamanho aleatório da árvore
        int nChildrens = src.nextInt(2, 4); // Capacidade de cada nó, escolhida arbitrariamente entre 2 e 4
        ArrayNTree<Integer> tree = new ArrayNTree<>(nChildrens);

        for (int i = 0; i < size; i++) {
            int element = src.nextInt(0, MAX_ELEMENT) * 2;
            tree.insert(element);
        }

        return tree;
    }
}

