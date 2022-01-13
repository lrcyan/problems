import java.util.*;

/**
 * Problem description: 
 * Given the root of a binary tree, verticalTraversal(TreeNode root) returns the vertical order traversal of the binary tree.
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

 * Definition for a binary tree node:
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
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList[][] tree = new ArrayList[33][33];
        for (int i = 0; i < 33; i++) for (int j = 0; j < 33; j++) tree[i][j] = new ArrayList<Integer>();
        int x = 0; int y = 0; ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        add(root, tree, x, y);
        return(traverse(tree, ret));
    }
    
    public void add(TreeNode head, ArrayList<Integer>[][] tree, int x, int y) {
        if (head == null) return;
        (tree[x][y]).add((Integer)(head.val));
        add(head.left, tree, x + 1, y);
        add(head.right, tree, x, y + 1);
    }
    
    public ArrayList<ArrayList<Integer>> traverse(ArrayList<Integer>[][] tree, ArrayList<ArrayList<Integer>> ret) {
        for (int i = 0; i < 33; i++) {
            for (int j = 0; j < 33; j++) (tree[i][j]).sort(Collections.reverseOrder(Collections.reverseOrder()));
        }
        for (int i = 32; i >= 0; i--) {
            int x = i; int y = 0; ArrayList<Integer> newList = new ArrayList<Integer>();
            while (x < 33 && y < 33) {
                for (int z = 0; z < tree[x][y].size(); z++) newList.add((Integer)((tree[x][y]).get(z)));
                x++; y++;
            }
            if (!(newList.isEmpty())) ret.add(newList);
        }
        for (int i = 1; i < 33; i++) {
            int x = 0; int y = i; ArrayList<Integer> newList = new ArrayList<Integer>();
            while (x < 33 && y < 33) {
                for (int z = 0; z < (tree[x][y]).size(); z++) newList.add((Integer)((tree[x][y]).get(z)));
                x++; y++;
            }
            if (!(newList.isEmpty())) ret.add(newList);
        }
        return ret;
    }
    
    
}
