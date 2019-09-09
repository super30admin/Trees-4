/**
Time Complexity: O(n)
LeetCode: Yes
Idea: 
1. Inorder traversal upto k elements
2. return the kth element
 */
class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class KthSmallest {
    int count = -1;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return helper(root);  
    }


    public int helper(TreeNode root) {
        int leftResult = -1;
        int rightResult = -1;
        if(root != null) {
            leftResult = helper(root.left);
            count--;
            if(count == 0){                
                count--;
                return root.val;
            }
                
            rightResult = helper(root.right);
        }

        return leftResult != -1 ? leftResult : rightResult;
    }
    
}

public class Solution {
    public static void main(String[] args) {
        System.out.println("Kth Smallest");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallest obj = new KthSmallest();
        System.out.println(obj.kthSmallest(root, 4));
    }
}