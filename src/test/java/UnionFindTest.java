import cheboksarov.unionFindDS.UnionFind;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnionFindTest {

    @Test
    public void findTest(){
        UnionFind uf = new UnionFind(5);
        System.out.println(uf);
        assertEquals(4, uf.find(4));
    }
    @Test
    public void pathCompressionTest(){
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(2, 1);
        uf.union(3, 2);
        uf.union(4, 3);
        System.out.println(Arrays.toString(uf.getParent()));
        assertArrayEquals(new int[]{0,0,0,0,0}, uf.getParent());
    }

    @Test
    public void unionSingleNodesMergeTest(){
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(4, 3);
        uf.union(1, 4);
        System.out.println(uf.getAllComponents().toString());
        System.out.println(uf.find(0));
        System.out.println(Arrays.toString(uf.getParent()));
        assertEquals(2, uf.find(1));
    }

    @Test
    public void unionNodesAlreadyInTheSameComponentTest(){
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(2, 1);
        uf.union(0, 2);
        System.out.println(uf.getAllComponents().toString());
        System.out.println(uf.find(0));
        System.out.println(Arrays.toString(uf.getParent()));
        System.out.println(uf.componentSize(0));
        assertEquals(List.of(0, 1, 2), uf.getComponent(2));
    }
}
