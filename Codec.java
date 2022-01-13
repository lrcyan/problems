import java.util.*;

/**

 * This program serializes a binary tree in a single string, and deserializes a single string representation of a binary tree into a binary tree.
 
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
        StringBuilder res = new StringBuilder("");
        serializeSubtree(root, res);
        
        return res.toString();
    }
    
    public void serializeSubtree(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("null,");
            return;
        }
        res.append(root.val); res.append(",");
        serializeSubtree(root.left, res);
        serializeSubtree(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        StringTokenizer tok = new StringTokenizer(data, ",");
        return deserializeSubtree(tok);
        
    
    }
                                             
    TreeNode deserializeSubtree(StringTokenizer tok) {
        if (!tok.hasMoreTokens()) return null;
        String nextStr = (String)tok.nextToken();
        if(nextStr.equals("null")) return null;
        int nextNum = (int)Integer.parseInt(nextStr);
        TreeNode ret = new TreeNode(nextNum);
        ret.left = deserializeSubtree(tok);
        ret.right = deserializeSubtree(tok);
        
        
        return ret;
    }
}

