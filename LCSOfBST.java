/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
Brute force approach :
// if both the node are on different side of tree return root
maintain the parent list for both the node if both the node are in same side of tree
// tranvese the parent list and return last matching parent

Time complexity : O(N) N = number of node in tree
Space complexity : O(maximum depth of the tree)
worked on leetcode : YES

class Solution {
   
    
      List<TreeNode> pList;
        List<TreeNode> qList;
    int pVal ;
        int qVal ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)  return null;
        
       pVal = p.val;
       qVal = q.val;
        
        int rootVal = root.val;
        // if both the node are on the different branch left or right root is the LCS
        if( (pVal < rootVal && qVal > rootVal) || (qVal < rootVal && pVal > rootVal ) )         {
            return root;
        }   
        
       
        List<TreeNode> parentList = new ArrayList();
        parentList.add(root);
        pList = new ArrayList();
        qList = new ArrayList();
        dfs(root,  parentList);
        // if on same depth both parent should be same
        
        int len1 = pList.size();
        int len2 = qList.size();
        
        int counter = len1<len2 ? len1: len2;
        int start =0;
        while(counter-->0){
            if(pList.get(start).val != qList.get(start).val) {
                return pList.get(start-1);
            }
            start++;
        }
    
       return pList.get(start-1);
           
        
       
    }
    
    private void dfs(TreeNode node,  List<TreeNode> parentList) {
        
        // process and check
        
        List<TreeNode> temp  = new ArrayList(parentList);
        temp.add(node);
        
        if(node.val == pVal ) {
            pList = temp;
            
        }
        
        if(node.val == qVal ) {
            qList = temp;
           
        }
        if(node.left == null && node.right == null) {
            return;
        }
//         if both find return
        
        
        
        if(node.left != null) {
            
            dfs(node.left,  temp);
        }
        
        if(node.right != null) {
            dfs(node.right,temp);
        }
        
    }
}

**/


// optimized code :

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;
        return dfsLCA(root, p, q);
        
    }
    
    private TreeNode dfsLCA(TreeNode node, TreeNode p, TreeNode q) {
        // Case 1 : p and q are not on same side of root
        // return root
        if(p.val < node.val && q.val > node.val || 
           q.val < node.val && p.val > node.val
          ) {
            
            return node;
            
        } 
        
        // Case 2 :
        // if we find the p or q while traversing
        // return it.
        // because we are now traversing in any one side of tree.
        // what ever we find fist will be LCA
        // node can be LCA of it self
        if(p.val == node.val || q.val == node.val) {
            return node;
        }
        
        // Case 3 :
        
        // if both the node are less than current root
        // return LCA of left
        
        if(p.val < node.val && q.val < node.val) {
            return dfsLCA(node.left, p, q);
        }
        
        // Case 4 :
        
        // if both the node are greater than current root
        // return LCA of right
        
        if(p.val > node.val && q.val > node.val ) {
            return dfsLCA(node.right, p, q);
        }
        
        return null;
    }
}
