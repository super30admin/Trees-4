

/**
 * Definition for a binary tree node.
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
 /*
class Solution {
    int result;
    int count;
    boolean flag=false;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        
        inorder(root.left);
        count--;
        if(count==0){
            result=root.val;
            flag=true;
        }
        if(!flag)
            inorder(root.right);
    }
}
*/

/*
class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        int[] arr=new int[1];
        arr[0]=k;
        return inorder(root,arr);
    }

    private int inorder(TreeNode root,int[] arr){
        if(root==null){
            return 0;
        }
        
        int left= inorder(root.left,arr);
        arr[0]--;
        if(arr[0]==0){
            return root.val;
        }
        if(left!=0){
            return left;
        }
        int right= inorder(root.right,arr);
        if(right!=0){
            return right;
        }
        return 0;
    }
}
*/
//iterative inorder: advantage: once k is 0 -> stop, in recursion we come back to previous states.
// TC: O(n)
// SC: O(h)
class KthSmallestelementInBST {
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk=new Stack<>();
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.push(root);
                root=root.left;
            }
            root=stk.pop();
            k--;
            if(k==0){
                return root.val;
            }
            root=root.right;

        }
        return 89798;
    }
}
