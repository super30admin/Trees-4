# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class solution:
    count = 0
    result = None

    '''
    we first go till the left most root and then start counting if the element is kth element or not. 
    if the left most is not the value then we start moving to right element and then continue until our count reaches k.
    then we return the element
    '''
    def kthElement(self, root, k):
        self.count = k
        return self.result

    def helper(self,root ):

        #base
        if root == None:
            return
        #logic

        self.helper(root.left)
        self.count-=1
        if self.count == 0:
            self.result == root
        
        self.helper(root.right)

    
    def kthElement_iterative(self,root, k):

        curr = root
        stack = []

        while curr or stack:

            while curr:
                stack.append(curr)
                curr = curr.left
            
            node = stack.pop()
            k-=1

            if k==0:
                return node.val
            
            curr = node.right
        
        return None

    
