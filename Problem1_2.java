//Time Complexity: O(n)
//Space Complexity: O(h)
//Code run successfully on LeetCode.

public class Problem1_2 {

    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return -1;
        
        Stack<TreeNode> s = new Stack<>();
        
        while(!s.isEmpty() || root != null){
            
            while(root != null){
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            
            k--;
            if(k == 0)
                return root.val;
            
            root = root.right;
        }
        
        return -1;
    }
}
