// Time Complexity : O(k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    List<Integer> inorderList = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }

        TreeNode node = root;

        inorder(node,k);

        return inorderList.get(k-1);

    }

    private void inorder(TreeNode node, int k){
        if(node == null){
            return;
        }

        if(inorderList.size() >= k){
            return;
        }

        inorder(node.left,k);
        inorderList.add(node.val);
        inorder(node.right,k);
    }
}
