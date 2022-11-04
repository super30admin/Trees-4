//approach - in BST if we perform in order, the kth root will be the answer. 
//tc = O(h) - it's never K, consider tree when it's just on the left side or right side 
//sc - O(h) - still same because we will not generate new calls, but whateever in the stack has to be completed. 

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
    int count, answer;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null ) return 0;
        
        count = 0;
        answer =-1;
        
         inorder(root, k);
        
        return answer;
    }
    
    private void inorder(TreeNode root, int k)
    {
        //base case
        if(root == null) return;
        
        //logic
        if(answer == -1)
        {
            inorder(root.left, k);
        }
        count++;
        if(count == k)
        { 
            answer = root.val;
            return;
        }
        if(answer == -1)
        {
            inorder(root.right, k);
        }
    }
    
}


//iterative approach
//approach - in BST if we perform in order, the kth root will be the answer. 
//tc = O(h) - it's never K, consider tree when it's just on the left side or right side 
//sc - O(h) - still same because we will not generate new calls, but whateever in the stack has to be completed. 

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
    int count, answer;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null ) return 0;
        
        count = 0;
        answer =-1;
        
        Stack<TreeNode> s = new Stack<>();
         
        while(root != null || !s.isEmpty())
         {
                while(root != null && answer == -1)
                {
                    s.push(root);
                    root = root.left;
                }
                root = s.pop();
                count++;

                //process
                if(count == k)
                {
                  return root.val;
                }

                if(answer == -1) root = root.right;
         }
        return answer;
    }
}