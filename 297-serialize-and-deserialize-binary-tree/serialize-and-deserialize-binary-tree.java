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
        List<String> list=new ArrayList<>();
        helper(root,list);

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append(",");//we need a delimeter ","
        }
        return sb.toString();
    }
    public void helper(TreeNode node,List<String> list){
        if(node==null){
            list.add("null");
            return ;
        }
        list.add(String.valueOf(node.val));

        helper(node.left,list);
        helper(node.right,list);
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));   //here also we use a delimeter like a "," seperator
        Collections.reverse(list);
        TreeNode node=helper2(list);
        return node;
    }

    public TreeNode helper2(List<String> list){
        String val=list.remove(list.size()-1);
        if(val.equals("null")){//it means that the first value in the string starts with n meaning it can only be null
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=helper2(list);
        node.right=helper2(list);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));