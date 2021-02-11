//Problem:101- Kth Smallest Element in a BST
//TC:O(N)
//SC:O(N) for storing all eleements in a list

/*Steps
As its is a BST, do the inorder traversal, which will give all elements in the ascending order and insert all elements in the list.
Finally Return the k-1 elemnet from the list  
*/
import java.util.*;
class Solution101 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> result;
    public int kthSmallest(TreeNode root, int k) {
     //TC:O(N),SC:O(N), number of nodes in tree
        if(root==null) return 0;
        result = new ArrayList<>();
        
        helper(root);
        return result.get(k-1);
    }
    
    private void helper(TreeNode root){
        
        if(root==null) return ;
        
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}