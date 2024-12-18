# TC: O(n)
# SC: O(1)

def kthSmallest(root, k):
        klargest = [-1]
        count = [0]
        def helper(root, count, klargest):
            if not root: return

            helper(root.left, count, klargest)
            count[0] += 1
            if count[0] == k:
                klargest[0] = root.val
            helper(root.right, count, klargest)
        
        helper(root, count, klargest)
        return klargest[0]