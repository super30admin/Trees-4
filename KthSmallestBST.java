// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.List;

public class KthSmallestBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res.get(k-1);
    }

    private void helper(TreeNode root, List<Integer> res){
       if(root == null){
           return;
       }

       helper(root.left, res);
       res.add(root.val);
       helper(root.right,res);
    }
}
