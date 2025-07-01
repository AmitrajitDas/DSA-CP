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
    private TreeNode builder(int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> inMap, int[] postorder) {
        if(inStart > inEnd || postStart > postEnd) { 
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRootIdx = inMap.get(root.val);
        int leftSubtreeSize = inRootIdx - inStart;

        root.left = builder(inStart, inRootIdx - 1, postStart, postStart + leftSubtreeSize - 1, inMap, postorder);
        root.right = builder(inRootIdx + 1, inEnd, postStart + leftSubtreeSize, postEnd - 1, inMap, postorder);
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return builder(0, inorder.length - 1, 0, postorder.length - 1, inMap, postorder);
    }
}