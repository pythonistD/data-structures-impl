package cheboksarov.unionFindDS;

public interface IUnionFind {
    /**
     *
     * @param node - index of node
     * @return index of the root of the component(subset) it belongs to
     */
    int find(int node);

    /**
     * Merging two unions which these nodes belong to.
     * If they in the different unions we compare the size of each union
     * If they have the same size, them root node of the node2's component will point to the root node of the node1's component
     * if the second union greater than first will be merged to the second
     * if the first union greater than second will be merged to the first
     * @param node1 - index of node1
     * @param node2 - index of node2
     */
    void union(int node1, int node2);

}
