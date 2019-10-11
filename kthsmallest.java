//Time Complexity:O(N) where N is the number of nodes in the binary tree.
//Space COmplexity:O(k)
//In this problem, I'll be having a helper function, that will traverse through the binary tree in inorder. As soon as I enter the helper function, I'll check if my root is null and then I'll recursively traverse to the left part of the tree. After coming from the left part, I'll increment the count and check if my count is equal to k, in that case I'll return the current root's value. Else, I'll traverse to the right part of the tree and repeat the same process. I have set the res variable to -1, so that in case, if I cannot find the kth smallest element in the tree, I'll be simply returning this value.
//This code was executed successfully and got accepted in leetcode.   

class Solution {
    int count=0;
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
        
    }
    public void inorder(TreeNode root,int k){
        if(root==null){
            return;
        }
        inorder(root.left,k);
        count++;
        if(count==k){
            res= root.val;
        }
        if(count<k){
            inorder(root.right,k);
        }
    }
}