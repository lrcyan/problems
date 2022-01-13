/**
 * @author Lena Ruiz <lenaruiz @ uvic.ca>
 *
 * <p>
 * 
 * This program returns the maximum sum over a path in a binary tree with integer-valued nodes.
 * 
 * <p>
 * 
 * Description of TreeNode class from leetcode.com/problems/binary-tree-maximum-path-sum/
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeMaximumPathSum {
    int maxPath = Integer.MIN_VALUE;
    
    /**
     * Finds the maximum path sum.
     *
     * @param TreeNode root: the root of a binary tree of size at most 3000 with integer values bounded by -1000 and +1000.
     * @return int maxPath: the maximum path sum.
     */
    public int maxPathSum(TreeNode root) {
        recursivePathSum(root);
        
        return maxPath;
    }
    
    /**
     * Finds the maximum vertical and horizontal path sums reaching their highest point at each node.
     *
     * @param TreeNode root: the root of a binary tree of size at most 3000 with integer values bounded by -1000 and +1000.
     * @return int maxPath: the maximum vertical path sum with its highest point at root.
     */
    int recursivePathSum(TreeNode root) {
        if (root == null) return 0;
        
        int left = recursivePathSum(root.left);
        int right = recursivePathSum(root.right);
        int maxVertical = root.val + (int)Math.max((int)Math.max(left, right), 0);
        int maxHorizontal = root.val + (int)Math.max(left, 0) + (int)Math.max(right, 0);
        int max = (int)Math.max(maxVertical, maxHorizontal);
        if (max > maxPath) maxPath = max;
        
        return maxVertical;
    }
    
}
