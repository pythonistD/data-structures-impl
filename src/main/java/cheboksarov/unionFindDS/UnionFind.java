package cheboksarov.unionFindDS;

import java.util.*;

public class UnionFind implements IUnionFind{
    private final int[] parent;
    // Кол-во нод в union find
    private final int size;
    // Кол-во нод в каждой компоненте
    private final int[] compSize;
    // Кол-во компонент
    private int compCount;

    public UnionFind(int size) {
        if(size <= 0) throw new IllegalArgumentException("The size must be greater than 0");
        parent = new int[size];
        compSize = new int[size];
      //Изначально каждая нода является корневой, так как указывает на саму себя
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            compSize[i] = 1;
        }
        this.size = size;
        this.compCount = size;
    }
    @Override
    public int find(int node) {
        if(parent[node] == node) return node;
        return find(parent[node]);
    }

    @Override
    public void union(int node1, int node2) {
        // Если ноды уже в одной компоненте, то их не нужно объединять
        if(isConnected(node1, node2)) return;
        int root1 = find(node1);
        int root2 = find(node2);
        int compSize1 = compSize[root1];
        int compSize2 = compSize[root2];
        // Определить какая нода останется корнейвой - parent, а какая станет дочерней - child
        int parentNode = root1;
        int childNode = root2;
        if(compSize1 < compSize2) {
            parentNode = root2;
            childNode = root1;
        }
        parent[childNode] = parentNode;
        compSize[parentNode] = compSize1 + compSize2;
        // compSize[node] == 0 <-- значит, что node не является корневой
        compSize[childNode] = 0;
        compCount--;
    }

    public List<List<Integer>> getAllComponents(){
        List<List<Integer>> components = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(compSize[i] > 0){
                components.add(getComponent(i));
            }
        }
        return components;
    }

    public List<Integer> getComponent(int node) {
        List<Integer> component = new ArrayList<>();
        int root = find(node);
        for(int i = 0; i< parent.length; i++){
            if(parent[i] == root || find(parent[i]) == root){
                component.add(i);
            }
        }
        return component;
    }
    public int[] getParent(){
        return parent;
    }
    // Проверка на то, что две ноды принадлежат одной компоненте
    public boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
    public int componentSize(int root){
        return compSize[root];
    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(parent);
    }
}
