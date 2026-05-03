class TreeAncestor {

    int max=17;
    int[][] table;

    public TreeAncestor(int n, int[] parent) {
        build(parent);
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=0;i<max;i++){
            if(node==-1)return -1;
            int mask=1<<i;
            if((k&mask)>0){
                node=table[i][node];
                if(node==-1)return -1;
            }
        }
        return node;
    }
    public void build(int[] parent){
        int n=parent.length;
        table=new int[max][n];
        for(int i=0;i<n;i++){
            table[0][i]=parent[i];
        }
        for(int i=1;i<max;i++){
            for(int j=0;j<n;j++){
                int prev=table[i-1][j];
                if(prev==-1){
                    table[i][j]=-1;
                }
                else{
                    table[i][j]=table[i-1][prev];
                }
            }
        }
    }

}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */