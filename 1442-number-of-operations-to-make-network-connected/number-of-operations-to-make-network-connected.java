class Solution {
    public int makeConnected(int n, int[][] connections) {

        // if n nodes are given then minimum n-1 edges are requrired to connect all nodes in single component

        if(connections.length < n-1 ){
            return -1;
        }

        int wires = 0;
        DisjointSet dsu = new DisjointSet(n);

        for(int [] connection : connections){

            int u = connection[0];
            int v = connection[1];

            if(dsu.unionBySize(u,v)){
                wires++;
            }

        }

        // for connecting n nodes we require n-1 edges
        // so min mo of wires required = n-1 - wires used

        return n-1 - wires;
        
    }
}
  public class DisjointSet {

    int parent[];

    int size[];

    DisjointSet(int nodes){
        this.parent = new int [nodes];
       
        this.size = new int[nodes];

        

        for(int i =0 ; i< nodes ; i++){
            this.parent[i] = i;
          
            this.size[i] = 1;
        }

    }

    public int findRootParent(int node){
        if(node == parent[node]){
            return node;
        }
         parent[node] = findRootParent(parent[node]);
        return parent[node];
}

public boolean unionBySize(int node1 , int node2){
        // Find the root parent

        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        // if the parents of both nodes are same means they are of the same components
        if(rootParent1 == rootParent2){
            return false;
        }
       
        // 2 union of components
        if(size[rootParent1] > size[rootParent2]){
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        } else if(size[rootParent1] < size[rootParent2]){
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        }else {
            parent[rootParent2] = rootParent1;
            size[rootParent1]+= size[rootParent2];
        }

        return true;
}
  }