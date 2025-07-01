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
     * Recursive helper function to build binary tree from inorder and postorder traversals
     * 
     * @param inStart - start index of current subtree in inorder array
     * @param inEnd - end index of current subtree in inorder array  
     * @param postStart - start index of current subtree in postorder array
     * @param postEnd - end index of current subtree in postorder array
     * @param inMap - HashMap for O(1) lookup of element indices in inorder array
     * @param postorder - postorder traversal array
     * @return root of the constructed subtree
     */
    private TreeNode builder(int inStart, int inEnd, int postStart, int postEnd, 
                           Map<Integer, Integer> inMap, int[] postorder) {
        // Base case: invalid range means no nodes to process
        if(inStart > inEnd || postStart > postEnd) { 
            return null;
        }
        
        // In postorder, the last element is always the root of current subtree
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        // Find root's position in inorder array using HashMap for O(1) lookup
        int inRootIdx = inMap.get(root.val);
        
        // Calculate size of left subtree
        // In inorder: [left_subtree][root][right_subtree]
        // Elements from inStart to (inRootIdx-1) belong to left subtree
        int leftSubtreeSize = inRootIdx - inStart; 

        // Recursively build left subtree
        // Inorder range: [inStart, inRootIdx-1] (elements before root)
        // Postorder range: [postStart, postStart+leftSubtreeSize-1] (first leftSubtreeSize elements)
        root.left = builder(inStart, inRootIdx - 1, postStart, postStart + leftSubtreeSize - 1, 
                          inMap, postorder);
        
        // Recursively build right subtree  
        // Inorder range: [inRootIdx+1, inEnd] (elements after root)
        // Postorder range: [postStart+leftSubtreeSize, postEnd-1] (remaining elements, excluding current root)
        root.right = builder(inRootIdx + 1, inEnd, postStart + leftSubtreeSize, postEnd - 1, 
                           inMap, postorder);
        
        return root;
    }
    
    /**
     * Main function to construct binary tree from inorder and postorder traversals
     * 
     * Key insight: 
     * - Postorder: Left -> Right -> Root (last element is always root)
     * - Inorder: Left -> Root -> Right (root divides left and right subtrees)
     * 
     * @param inorder - inorder traversal of the tree
     * @param postorder - postorder traversal of the tree  
     * @return root of the constructed binary tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Create HashMap to store index of each element in inorder array
        // This enables O(1) lookup instead of O(n) search for root position
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        // Start recursive construction with full array ranges
        return builder(0, inorder.length - 1, 0, postorder.length - 1, inMap, postorder);
    }
}