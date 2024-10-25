class Solution {

    // here nodes start from 1
    public int[] findRedundantConnection(int[][] edges) {

       int totalNodes = edges.length;

        int res [] = new int[2];

        DisjointSet dsu = new DisjointSet(totalNodes);

        for(int edge [] : edges){
            if(!dsu.unionBySize(edge[0]-1 , edge[1]-1)){ // nodes starts from 1 not zero hence we have subtracted 1 
            // if the union is not possible then the edge is of same component
           res = edge;
            }
        }
        return res;
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