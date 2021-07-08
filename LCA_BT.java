// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree (Recursive Stack in Recursion +  HashMap/HasSet in Iterative approach)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Iterative approach was challenging
/* Your code here along with comments explaining your approach: While you dont find p and q , traverse the tree. As you find p node or q node, return
the corresponding node to the parent of the current node, if both the returned nodes are not null, return the root. If any one side either left
or right node that is being returned is null, return the other non null side. In Iterative approach store the parent of the nodes till you find the
nodes p and q. At the end, retrace the p ancestor path and check if q's ancestor contains in the hashset or not, if yes return the corresponding matched node.
*/
// RECURSIVE
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){return root;}                            // If p or q is found
        TreeNode left =  lowestCommonAncestor(root.left, p, q);                                 // Go left
        TreeNode right  = lowestCommonAncestor(root.right, p, q);                               // Go right
        if(left != null && right != null){return root;}                                         // If both sides are returning non null nodes
        return left == null ? right : left;                                                             // Return the non null node side
    }
}

// ITERATIVE
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        HashMap<TreeNode, TreeNode> par = new HashMap<>();                                          // Node : Parent
        HashSet<TreeNode> ancestors = new HashSet<>();                                  // Capturing P's ancestors
        par.put(root, null);
        while(!par.containsKey(p) || !par.containsKey(q)){                      // While you get both p and q in the hashmap
            while(root.left != null) {
                par.put(root.left, root);                                                       // Get the left subtree node's with parents
                root =root.left;
                stk.push(root);
            }
            root = stk.pop();
            if(root.right != null){                                                             // Get the right subtree node's with parents
                par.put(root.right, root);
                root=root.right;
                stk.push(root); 
            }
        }
        TreeNode parent = root;
        ancestors.add(p);                                                           // Let's start capturing p's ancestors
        while(parent != null){
            parent = par.get(p);                                                // Get all the ancestors of p using the hashmap retrace
            ancestors.add(parent);
            p = parent;
        }
        parent = root;
        while(!ancestors.contains(q)){                                          // Check if the hashset contains q's any of the ancestors
            parent = par.get(q);
            q = parent;
        }
        return q;                                                               // if yes, return the matched node
    }
}