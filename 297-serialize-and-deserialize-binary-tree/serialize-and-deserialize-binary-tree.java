/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper1(root,sb);
        return sb.toString();
    }
    public void helper1(TreeNode root , StringBuilder sb){
        if(root ==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        helper1(root.left,sb);
        helper1(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] node = data.split(",");
        LinkedList<String> list = new LinkedList<>();

        for(String str : node){
            list.add(str);

        }
        return helper2(list);

    }

    public TreeNode helper2(LinkedList<String> list){
        if(list.isEmpty())
                return null;

        String val =list.removeFirst();

        if(val.equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left=helper2(list);
        root.right=helper2(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));