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
**/
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
