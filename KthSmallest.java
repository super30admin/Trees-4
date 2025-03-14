//Time and spcae complexities written below for each approach.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;
class Solution {

    //This is basic inorder traversal.
    // Time Complexity : O(n) n is the number of nodes.
    // Space Complexity : O(n) since we are storing all the nodes in the list
    public void inorder1(TreeNode root, List<Integer> result)
    {
        if(root.left != null)
        inorder1(root.left, result);
        
        result.add(root.val);
        
        if(root.right != null)
        inorder1(root.right, result);
        
    }
    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> inorderlst = new ArrayList<Integer>();
        inorder1(root, inorderlst);
        return inorderlst.get(k-1);
    }



    //This is conditional inorder traversal, when we reach k=0 then returning.
    // Time Complexity : O(n) n is the number of nodes.
    // Space Complexity : O(h) recursive stack space.
    int count=0;
    int result=0;
    public void inorder2(TreeNode root, int k)
    {
        if(root.left != null)
        inorder2(root.left, k);
        
        count++;
        if(count == k)
        {
            result = root.val;
            return;
        }
        
        if(root.right != null)
        inorder2(root.right,k);

    }

    public int kthSmallest2(TreeNode root, int k) {
        inorder2(root, k);
        return result;
        
    }



    // This is controlled iterative recursion using stack.
    // Time Complexity : O(n) n is the number of nodes. But significantly better than the other two because, 
    //we exit the program when we find the element, no need to recursively go back like in regular recursion, here we are not processing the stack even if has elements, 
    //we exit beause we got the kth smallest element
    // Space Complexity : O(h) stack space.
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);

        while(true)
        {
            while(root != null && root.left != null)
            {
                stk.push(root.left);
                root = root.left;
            }

            TreeNode curr = stk.pop();
            if(--k==0)
                return curr.val;

            if(curr.right != null)
                stk.push(curr.right);
            root = curr.right;
        }
    }
}