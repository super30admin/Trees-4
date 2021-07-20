// Time Complexity : O(N) where N is the number of elements
// Space Complexity : O(2*H) H is the longest path to node
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
	1. traverse through all the elements in the BT and add them to a path ArrayList
	2. When we reach the required destination copy the arraylist as a path an arraylist
	3. Compare the 2 arraylist to find the last matching node
	4. Return the last matching node
*/


// Your code here along with comments explaining your approach
class Solution {
    ArrayList<TreeNode> pathp = new ArrayList<>(); 
    ArrayList<TreeNode> pathq = new ArrayList<>();
    ArrayList<TreeNode> curr = new ArrayList<>();
    TreeNode LCA;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        curr.add(root);
        findPath(root, p, q);
        // pathq.forEach(part -> System.out.print(part.val+" "));
        for(int i=0;i<Math.min(pathp.size(), pathq.size());i++) {
            if(pathp.get(i) == pathq.get(i)) LCA = pathp.get(i);
        }
        
        return LCA;
    }
    
    public void findPath(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val) {
            pathp = new ArrayList<>(curr);
        }
        if(root.val == q.val) {
            pathq = new ArrayList<>(curr);
        }
        
        if(root.left != null) {
            curr.add(root.left);
            findPath(root.left, p, q);
            curr.remove(curr.size() - 1);
        }
        if(root.right != null) {
            curr.add(root.right);
            findPath(root.right, p, q);
            curr.remove(curr.size() - 1);
        }
    }
}
