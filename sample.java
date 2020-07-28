/**
Problem -1: Kth Smallest Element in a BST
 */

/**
Iterative solution using stack. Iterating over the tree in the inorder manner for n-k len.
TC = O(n)
SC = (h)

*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> s = new Stack();
        int ret=0;
        // s.push(root);
        while(!s.isEmpty() || root != null){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            
            if(root != null){
                k--;
                if(k == 0){
                    ret = root.val;
                    break;
                } 
                root = root.right;
            }

        }
        
        return ret;
        
    }
}
/**
Recursive solution
*/
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        
        count = k;
        
        inorder(root);
        return result;
        
    }
    
    private void inorder(TreeNode root){
        //base
        if(root == null)return;
        inorder(root.left);
        count --;
        if(count == 0){
            result = root.val;
            return;
        }
        inorder(root.right);
    }
}
// Problem-2: Lowest Common Ancestor of a Binary Search Tree

/**
We can use the property of BST here. If p < root look in the right subtree until such a node is found which is greater than p and less than q
tc = O(n) where n is the num of tree nodes. O(n) in case the tree is skewed
sc = O(n) because there can be where one side of the has all the nodes
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //base
        if(root == null) return null; //leaf node
        
        if(q.val < root.val && p.val < root.val) return lowestCommonAncestor(root.left, p, q); //look in the left subtree
        if(q.val > root.val && p.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
// recursive solution problem-2:
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //base
        if(root == null) return null; //leaf node
        
        if(q.val < root.val && p.val < root.val) return lowestCommonAncestor(root.left, p, q); //look in the left subtree
        if(q.val > root.val && p.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}

// Problem-3: Lowest Common Ancestor of a Binary Tree

/**
Recursive solution where every time node is checked against p and q. if it matches that node is returned in the recursive call. in recursion when both left and right are not null, then the ancestor is found
TC = O(n)
SC = O(h) stack space or height of the tree
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //base
        if(root == null || root == p || root == q) return root;
        
        //recurse
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //logic
        if( left != null && right != null ) return root; // then root is the answer;
        else if( left != null) return left; // then left is one of the node that we are looking for
        else return right; // then right is one of the node that we are looking for
        
        
    }
}
