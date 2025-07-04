
/*
int based recursion
Space Complexity : O(H) ,O(logN) if balanced O(N) if skewed
Time Complexity : O(N) ~ O(K)

Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class KthSmallestElementInBST_LC_230 {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.result=Integer.MAX_VALUE;
        count = k;
        return helper(root);
    }
    private int helper(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        //logic
        helper(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        helper(root.right);
        return result;
    }
}

/*
-----------Approach 2 ------------
int based recursion non-elegant way

class Solution {
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return helper(root);
    }
    private int helper(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        //System.out.print(root.val);
        //logic
        int left = helper(root.left);
        count--;
        if(count == 0){
            return root.val;
        }
        int right = helper(root.right);
        if(left != Integer.MAX_VALUE) return left;
        if(right != Integer.MAX_VALUE) return right;
        return Integer.MAX_VALUE;
    }
}

-------------Approach 3-----------
 Void based Conditional recursion

class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        this.result = Integer.MAX_VALUE;
        count = k;
        helper(root);
        return result;

    }
    private void helper(TreeNode root){
        if(root == null) return;
        if(result != Integer.MAX_VALUE) return;
        System.out.print(root.val);
        //logic
        helper(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        helper(root.right);
    }
}

--------------- Approach 4 -----------------
Void based Non Conditioanl recursive approach

class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return result;

    }
    private void helper(TreeNode root){
        if(root == null) return;

        //logic
        helper(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        helper(root.right);
    }
}

 */