// Runtime complexity - O(n+k) where n is the number of elements in the root
// Space time complexity - O(H) where H is the height of the tree

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
class Solution {
    int count=0;
    int result=0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
        /*
        Stack<TreeNode> s1=new Stack<>();
        TreeNode curr=root;
        int index=k;
        int min=-1;
        while(curr!=null || !s1.isEmpty())
        {
            while(curr!=null)
            {
                s1.push(curr);
                curr=curr.left;
            }
            TreeNode temp=s1.pop();
            index--;
            if(index==0)
            {
                min=temp.val;
                break;
            }
            curr=temp.right;
     
        }
        return min;*/
    }
    
    public void inorder(TreeNode curr,int k)
    {
        if(curr==null)
            return;
        inorder(curr.left,k);
        //check count
        if(++count==k)
        {
            result=curr.val;
            return;
        }
        inorder(curr.right,k);
    }
    
}
