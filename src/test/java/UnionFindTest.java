import cheboksarov.unionFindDS.UnionFind;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnionFindTest {

    @Test
    public void findTest(){
        UnionFind uf = new UnionFind(5);
        System.out.println(uf);
        assertEquals(4, uf.find(4));
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
        assertEquals(2, uf.find(1));
    }
}
