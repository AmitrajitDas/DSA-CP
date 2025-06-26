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
    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();

        if(start > end) {
            trees.add(null);
            return trees;
        }

        // if(start == end) {
        //     trees.add(start);
        //     return trees;
        // }

        for(int rootVal = start; rootVal <= end; rootVal++) {
            List<TreeNode> leftBST = buildTrees(start, rootVal - 1);
            List<TreeNode> rightBST = buildTrees(rootVal + 1, end);

            for(TreeNode left : leftBST) {
                for(TreeNode right : rightBST) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }

        return trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }
}