package s30.Trees-4;

public class problem1 {
    class Solution {
        //TC:- O(h)
        //SC:- O(h)
        int res;
        int count;
        public int kthSmallest(TreeNode root, int k) {
            if(root == null) return 0;
            
             helper(root, k);
            return res;
        }
        
        private void helper(TreeNode root, int k){
            //base
            if(root == null) return;
            
            //logic
            helper(root.left,k);
             count++;;
            if(count == k){
                res = root.val;
                return;
            }
            helper(root.right,k);
            
            return;
        }
    }
}
