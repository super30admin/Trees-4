//time complexity: O (log N)
//space complexity: O(1)

class Solution {
    //Binary Search method
    /*
    1. count left nodes to root
    2. if k is less than or equal to the number of nodes on left then repeat process for left
    3. if k is greater than countOnLeft+1(root) then repeat process on right node.
    */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int kthSmallest(TreeNode root, int k) {
        int countLeft = countNodes(root.left);
        System.out.println(countLeft);
        if(k <= countLeft)
            return kthSmallest(root.left, k);
        else if (k > countLeft+1)
        {
            return kthSmallest(root.right, k-1-countLeft);
        }
        return root.val;
    }
    
    public int countNodes(TreeNode root)
    {
        if(root==null)
            return 0;
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}