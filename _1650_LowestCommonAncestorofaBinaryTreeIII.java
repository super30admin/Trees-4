// Time Complexity : o(n) where n is number of nodes
// Space Complexity : o(h) where h is height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Root is not given, use parent to go up and find root, once root is found the apply lca with root and two input nodes
// if element is found return true, if both left and right return true then root is ancestor
// handle root to be one of the element
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {

        Node root = null;

        Node temp1 = p;
        Node temp2 = q;

        while(true){
            if(p.parent == null) {
               root = p;
               break;
            }
            if(q.parent == null) {
               root = q;
               break;
            }
            q=q.parent;
            p=p.parent;
         }

        return lowestCommonAncestor(root, temp1, temp2);

    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {

        if(root == null || root == p || root == q ) return root;

        Node left =  lowestCommonAncestor(root.left, p, q);
        Node right =  lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        return left != null ? left : right;
    }

    /***************Need to understand the circle pointer approach *******************/
    // Not my solution, copied from leetcode discussion for future use
        public Node lowestCommonAncestor(Node p, Node q) {
          	Node a = p, b = q;
          	while (a != b) {
          		a = a == null? q : a.parent;
          		b = b == null? p : b.parent;
          	}
          	return a;
        }

}
