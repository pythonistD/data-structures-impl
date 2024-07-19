package cheboksarov.unionFindDS;

import java.util.*;

public class UnionFind implements IUnionFind{
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
      //Изначально каждая нода является корневой, так как указывает на саму себя
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    @Override
    public int find(int node) {
        if(parent[node] == node) return node;
        return find(parent[node]);
    }

    @Override
    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        int compSize1 = sizeOfComponent(root1);
        int compSize2 = sizeOfComponent(root2);
        if(compSize1 >= compSize2){
            parent[root2] = root1;
        }else{
            parent[root1] = root2;
        }
    }
    private int sizeOfComponent(int root){
        return getComponent(root).size();
    }
    public List<List<Integer>> getAllComponents(){
        List<List<Integer>> components = new ArrayList<>();
        for(int root: getAllRoots()){
            components.add(getComponent(root));
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
    public List<Integer> getAllRoots(){
        int lastRoot = -1;
        List<Integer> roots = new ArrayList<>();
        for(int i: parent){
            int root = find(i);
            if(root!= lastRoot){
                roots.add(root);
                lastRoot = root;
            }
        }
        return roots;
    }

    @Override
    public String toString() {
        return Arrays.toString(parent);
    }
}
