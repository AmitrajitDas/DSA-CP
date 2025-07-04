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
    /**
     * Recursive helper method to build binary tree from preorder and inorder traversals
     * 
     * @param inStart Starting index of current subtree in inorder array
     * @param inEnd Ending index of current subtree in inorder array
     * @param preStart Starting index of current subtree in preorder array
     * @param preEnd Ending index of current subtree in preorder array
     * @param inMap HashMap containing value->index mapping for inorder array
     * @param preorder Preorder traversal array
     * @return Root node of the constructed subtree
     */
    private TreeNode builder(int inStart, int inEnd, int preStart, int preEnd, 
                           Map<Integer, Integer> inMap, int[] preorder) {
        // Base case: if indices are invalid, return null (empty subtree)
        if(inStart > inEnd || preStart > preEnd) {
            return null;
        }
        
        // The first element in preorder is always the root of current subtree
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // Find the position of root in inorder array using HashMap (O(1) lookup)
        int inRootIdx = inMap.get(preorder[preStart]);
        
        // Calculate size of left subtree
        // Elements before root in inorder array belong to left subtree
        int leftSubtreeSize = inRootIdx - inStart;
        
        // Recursively build left subtree
        // In inorder: from inStart to inRootIdx-1
        // In preorder: from preStart+1 to preStart+leftSubtreeSize
        root.left = builder(inStart, inRootIdx - 1, preStart + 1, 
                          preStart + leftSubtreeSize, inMap, preorder);
        
        // Recursively build right subtree
        // In inorder: from inRootIdx+1 to inEnd
        // In preorder: from preStart+leftSubtreeSize+1 to preEnd
        root.right = builder(inRootIdx + 1, inEnd, preStart + leftSubtreeSize + 1, 
                           preEnd, inMap, preorder);
        
        return root;
    }
    
    /**
     * Main method to construct binary tree from preorder and inorder traversals
     * 
     * Algorithm:
     * 1. Preorder traversal gives us the root at each step (first element)
     * 2. Inorder traversal helps us identify left and right subtrees
     * 3. Elements before root in inorder belong to left subtree
     * 4. Elements after root in inorder belong to right subtree
     * 
     * Time Complexity: O(n) where n is number of nodes
     * Space Complexity: O(n) for HashMap and recursion stack
     * 
     * @param preorder Array representing preorder traversal
     * @param inorder Array representing inorder traversal
     * @return Root of the constructed binary tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create HashMap to store index of each element in inorder array
        // This enables O(1) lookup instead of O(n) search for root position
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        // Start recursive construction with full array ranges
        return builder(0, inorder.length - 1, 0, preorder.length - 1, inMap, preorder);
    }
}