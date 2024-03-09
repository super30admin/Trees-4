//1. Kth Smallest Element
//Time Comlexity -> O(n)
//Space Complexity - > O(h)
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
    //Using global result variable
    List<Integer> result;
    public int kthSmallest(TreeNode root, int k) {
        this.result = new ArrayList();
        inorder(root);
        System.out.print(result);
        return result.get(result.size() - k);
        
    }

    private void inorder(TreeNode root){
        //base case
        if(root == null) return;

        //recursive
        inorder(root.right);
        result.add(root.val);
        inorder(root.left);
    }
}

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
    //iterative method
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        Stack<TreeNode> st = new Stack();
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root= st.pop();
            k--;
            if(k == 0){
                return root.val;
            }
            root = root.right;
        }

        return -1;
        
    }
}

//2. LCA of BST
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    //Using Recursion
    //TIme Complexity -> O(h)
    //Space Complexity - > O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == null || q == null) return null;
        //if both the nodes are smaller than the root value , then we go to left tree
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if(root.val <p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
        
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    //Using Iteration
    //TIme Complexity -> O(h)
    //Space Complexity - > O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == null || q == null) return null;
        while(true){

             //if both the nodes are smaller than the root value , then we go to left tree
        if(root.val > p.val && root.val > q.val) root = root.left;
        //if both the nodes are smaller than the root value , then we go to right tree
        else if(root.val <p.val && root.val < q.val) root = root.right;
        //if both the nodes are on 2 different sides we are at the Lowest commeon ancestor
        else return root;

        }
       
        
    }
}

//3rd LCA of BT
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time Complexity - >O(h)
//Space Complexity -> O(h)
class Solution {
    //Using Storing paths
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null) return root;
       helper(root,p,q,new ArrayList<>());
       for(int i = 0 ;i<pathP.size();i++){
           if(pathP.get(i)!=pathQ.get(i)){
               return pathP.get(i-1);
           }
       } 
       return null;    
    }

    private void helper(TreeNode root,TreeNode p,TreeNode q, List<TreeNode> path){
        //base case
        if(root == null) return;
        //logic
        //action
        path.add(root);
        if(root == p){
            this.pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q){
            this.pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        
        //recurse
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        //backtrack
        path.remove(path.size()-1);


    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //Using Without list Method
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null || root == p || root == q) return root;
       TreeNode left = lowestCommonAncestor(root.left, p, q);
       TreeNode right = lowestCommonAncestor(root.right, p, q);
       if(left == null && right == null) return null;
       else if(left!=null && right == null) return left;
       else if(left == null && right!=null) return right;
       else return root;
    }

   
}