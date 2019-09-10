//TC : O(N) n is the no of elements in Treee
//SC : O(N) n is the no of elements in Tree. and storing them in a list.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private static List<Integer> s = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null ) return 0;
        inOrder(root);
        System.out.println(s);
        return s.get(k-1);
    }
    
    private void inOrder(TreeNode root){
        
        if(root == null) return;
          inOrder(root.left);
          s.add(root.val);
          inOrder(root.right);  
        
    }
}
