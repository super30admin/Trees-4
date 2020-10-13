// TC: O(k) where k is the number of element requested as output
// SC: O(k)

import java.util.*;

public class KSmallestElementBST {
    int count = 1, res = -1;
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
        helper(root, k);
        return list.get(k-1);
    }
    public void helper(TreeNode root, int k){
        if(root == null)
            return ;
        if(root.left != null){
            helper(root.left, k);
        }
        count++;
        list.add(root.val);        
        if(root.right != null){
            helper(root.right, k);
        }
        if(k == count)
            return;
    }
}