// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Optimized approach - w/o creation of lists
// Your code here along with comments explaining your approach
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root.val == p.val || root.val == q.val)  return root;
        
        TreeNode left = helper(root.left, p, q); // Will return the left child
        TreeNode right = helper(root.right, p, q); // Will return the right child
        
        if(left == null && right == null)   return null;    // If left - right === null
        else if(left != null && right == null)  return left;  //Return not-null node
        else if(right != null && left == null)  return right; // Return not-null node
        
        
        return root;
    }
}

/*

// Time Complexity : O(N)

// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<TreeNode> list1;
    List<TreeNode> list2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        //2 lists for storing path of both the nodes p and q
        helper(root, p, q, new ArrayList<>());
        
        for(int i = 0; i< list1.size(); i++){ // When node are different, previous node will be LCA for p and q
            if(list1.get(i) != list2.get(i)){
                return list1.get(i-1);
            }
        }
        
        return null;
    }
    
    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //Base
        if(root == null)    return;
        
        if(root.val == p.val){ // If current root's value is same as p's value, initialize list1 with path and then add node p 2 times, adding one more for checking inequalities for ancestors
            list1 = new ArrayList<>(path);
            list1.add(p); list1.add(p);
        }
        if(root.val == q.val){// If current root's value is same as q's value, initialize list2 with path and then add node q 2 times, adding one more for checking inequalities for ancestors
            list2 = new ArrayList<>(path);
            list2.add(q); list2.add(q);
        }        
        
        path.add(root);// Adding curr root into path
        
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);        
        
        //Backtracking = removing curr node from path after stack.pop() happens
        path.remove(path.size() - 1);
    }
}


*/