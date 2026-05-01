class Node {
    Node[] children;
    int total;
    public Node(){
        children = new Node[2];
        total=0;
    }
}
class Trie {
    Node root;
    int maxBits;
    public Trie(){
        root = new Node();
        maxBits = 15;
    }
    public void add(int num){
        root.total+=1;
        Node n = root;
        for(int i=maxBits-1; i>=0; i--){
            int bit = (num>>i) & 1;
            if(n.children[bit]==null){
                n.children[bit] = new Node();
            }
            n.children[bit].total+=1;
            n = n.children[bit];
        }
    }

    public int countPairs(int num, int limit){
        Node n = root;
        int count = 0;
        for(int i=maxBits-1; i>=0&&n!=null; i--) {
            int bitNum = (num>>i) & 1;
            int bitLim = (limit>>i) & 1;
            if(bitNum==0 && bitLim==1){
                count+= (n.children[0]!=null)? n.children[0].total :0;
                n = n.children[1];
            }
            else if(bitNum==1 && bitLim==1) {
                count+= (n.children[1]!=null)? n.children[1].total :0;
                n=n.children[0];
            }
            else n = n.children[bitNum];
        }
        return count;
    }
}
class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int count = 0;
        Trie trie = new Trie();
        for(int num : nums){
            int highLimit = trie.countPairs(num, (high+1));
            int lowLimit = trie.countPairs(num, low);
            count += (highLimit-lowLimit);
            trie.add(num);
        }
        return count;
    }

}