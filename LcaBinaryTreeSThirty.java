import java.util.*;

/* Approach: 
1. Store the path taken at every node. Use backtracking to do the same.
2. Whenever you match the node value, p and q, store that path taken at that point 
3. When both the paths are set, iterate through the paths till the elements match, the moment an element does not match, stop the iteration and return the last matched element.
4. Important: Also, it might happen that all the elements match, for example, for node 5 and 6, path are [3,5] and [3,5,6], in this case both 3 and 5 match. So if the node is found, add its value twice to the path. The paths become [3,5,5] and [3,5,6,6].
5. Important: Adding the element twice to the list, will also always save from index bound exception if the list was shorter. If p: 5 and q: 3, paths are [3,5,5] and [3,3]. The first mistmatch would be on index 2. 

Time complexity: O(N: N is the number of nodes till both the nodes are found) + O(m*n) : Time complexity of finding the last matching element (m is the elements in p's path and n is the element in q's path)
Space complexity: O(H)

Example: in a tree: [3,5,1,6,2,0,8,7,4,9,10], p:5, q:4, the traversal goes this way:
Node: 3
Path: [3]
Node: 5
Path: [3, 5]
Node: 6
Path: [3, 5, 6]
Node: 2
Path: [3, 5, 2]
Node: 7
Path: [3, 5, 2, 7]
Node: 4
Path: [3, 5, 2, 4]
Anc: 5

nodes 9, 10, 1, 0 , 8 are not explored as we have already found the elements 5 and 4

Time complexity: O(N): Asymptotically 
*/
public class LcaBinaryTreeSThirty {
    TreeNode node; 
    List<TreeNode> pathP = new ArrayList<>();
    List<TreeNode> pathQ = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ancestors = new ArrayList<>();
        traverseWithAncestors(root, p, q, ancestors);
        return node;
    }
    
    public void traverseWithAncestors(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> ancestors)
    {
        //base
        if(root==null || node!=null)
            return;
        
        ancestors.add(root);
    
        if(root.val == p.val)
        {
            pathP = new ArrayList<>(ancestors);
            pathP.add(root);
        }
        if(root.val == q.val)
        {
            pathQ = new ArrayList<>(ancestors);
            pathQ.add(root);
        }
    
        if(pathP.size()>0 && pathQ.size()>0)
        {
            for(int i=0; i<= pathP.size()-1; i++)
            {
                if(pathP.get(i)!=pathQ.get(i))
                {
                    node = pathP.get(i-1);
                    break;
                }
            }
        }
        
        //logic
        traverseWithAncestors(root.left, p, q, ancestors);
        traverseWithAncestors(root.right, p, q, ancestors);
        ancestors.remove(ancestors.size()-1);
    }
}


