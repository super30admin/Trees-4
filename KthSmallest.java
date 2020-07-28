<-----Brute Force--->
// Time Complexity: O(N) where N is number of nodes
// Space Complexity: O(N)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        kthSmallest(result, root, k);
        return result.get(k-1);
    }
    
    private void kthSmallest(List<Integer> result, TreeNode root, int k) {
        if(root == null)
            return;
        kthSmallest(result, root.left, k);
        result.add(root.val);
        kthSmallest(result, root.right, k);
    }
}

<---Iterative Approach--->
// Time Complexity: O(H) where H is the height of the tree
// Space Complexity: O(H)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = root.left;
        
        while(true) {        
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }      
            curr = stack.pop();           
            if(--k == 0) 
                return curr.val;           
            curr = curr.right;
        }
    }   
}