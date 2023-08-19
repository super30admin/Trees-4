//Problem 1
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//in inorde fashion traverse all the roots, then return kth root we traverse as it is kth smallest(in BST)
class Solution {
    int res,count;
    public int kthSmallest(TreeNode root, int k) {
        // this.count=k;
        // inorder(root);
        // return res;

        //iterative
        Stack<TreeNode> st= new Stack<>();
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            k--;
            if(k==0) return root.val;
            root=root.right;
        }
        return 0;
    }

    public void inorder(TreeNode root){
        //base;
        if(root==null) return;

        if(count>0)
            inorder(root.left);
        count--;
        if(count==0)
            res=root.val;
        if(count>0)
            inorder(root.right);
    }
}

//Problem 2
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//iterate all the nodes in a bst. check if p and q are smaller than root -> go left, same for right, if one is at left, one at right, then root is lowest common ancester
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
        if(root.val>p.val && root.val>q.val) root=root.left;
        else if(root.val<p.val && root.val<q.val) root=root.right;
        else 
            return root;
        }
    }
}


//Problem 3
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//2Ways -> node based recursion, void based recursion.
//until we find p , keep track of path, same with q. then iterate through them, last common element will be lowest common ancester
//each node gives left and right values , when it has found p or q values at the left or right end., when both return a value, thats our lowest common ancester
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // backtrack(root, p, q, new ArrayList<>());
        // for(int i=0;i<pathP.size();i++){
        //     if(pathP.get(i) != pathQ.get(i)){
        //         return pathP.get(i-1);
        //     }
        // }
        // return null;
        if(root==null || root==p || root==q){
            return root;
        }
            
            TreeNode left= lowestCommonAncestor(root.left, p, q);
            TreeNode right= lowestCommonAncestor(root.right, p, q);

        if(left==null && right==null)
            return null;
        else if(left!=null && right==null)
            return left;
        else if(left==null && right!=null)
            return right;
        else
            return root;

    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        // if(root==null){
        //     return;
        // }
        // //logic
        // path.add(root);
        
        // if(root==p){
        //     this.pathP=new ArrayList<>(path);
        //     this.pathP.add(root);
        // }
        // if(root==q){
        //     this.pathQ=new ArrayList<>(path);
        //     this.pathQ.add(root);
        // }
        // //action
        
        // if(pathP == null || pathQ==null)
        //     backtrack(root.left, p, q, path);
        // if(pathP == null || pathQ==null)
        //     backtrack(root.right, p, q, path);

        // path.remove(path.size()-1);
    }
}