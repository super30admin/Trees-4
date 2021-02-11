// Time Complexity :O(n)
// Space Complexity :2 *O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
    List<TreeNode> firstPath;
    List<TreeNode> secondPath;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        firstPath=new ArrayList<>();
        secondPath=new ArrayList<>();
        dfsFirst(root,p,new ArrayList<>());
        dfsSecond(root,q,new ArrayList<>());
        // System.out.println(firstPath);
        // System.out.println(secondPath);
        if(secondPath.contains(p)){
            return p;
        }
        TreeNode myNode=null;
        for(int i=0;i<firstPath.size();i++){
            if(secondPath.contains(firstPath.get(i))){
                myNode=firstPath.get(i);
            }
        }
        //System.out.println(myNode.val);
        return myNode;
    }
    
    public void dfsFirst(TreeNode node,TreeNode find,List<TreeNode> path){
        if(node==null){
            return;
        }
        if(node==find){
            path.add(node);
            firstPath=new ArrayList<>(path);
            path.remove(path.size()-1);
            //System.out.println(finalPath);
            return;
        }
        path.add(node);
        dfsFirst(node.left,find,path);
        dfsFirst(node.right,find,path);
        path.remove(path.size()-1);
        
    }
    
        public void dfsSecond(TreeNode node,TreeNode find,List<TreeNode> path){
        if(node==null){
            return;
        }
        if(node==find){
            path.add(node);
            secondPath=new ArrayList<>(path);
            //System.out.println(finalPath);
            path.remove(path.size()-1);
            return;
        }
        path.add(node);
        dfsSecond(node.left,find,path);
        dfsSecond(node.right,find,path);
        path.remove(path.size()-1);
        
    }
}