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
    private TreeNode builder(int inStart, int inEnd, int preStart, int preEnd, Map<Integer, Integer> inMap, int[] preorder) {
        if(inStart > inEnd || preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRootIdx = inMap.get(preorder[preStart]);
        int leftSubtreeSize = inRootIdx - inStart;

        root.left = builder(inStart, inRootIdx - 1, preStart + 1, preStart + leftSubtreeSize, inMap, preorder);
        root.right = builder(inRootIdx + 1, inEnd, preStart + leftSubtreeSize + 1, preEnd, inMap, preorder);

        return root;
    }

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