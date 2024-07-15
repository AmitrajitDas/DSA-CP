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
    private TreeNode buildTree(int currNodeVal, Map<Integer, int[]> mp) {
        TreeNode node = new TreeNode(currNodeVal);
        if(mp.containsKey(currNodeVal)) {
            int[] children = mp.get(currNodeVal);
            if(children[0] != -1) {
                node.left = buildTree(children[0], mp);
            }
            if(children[1] != -1) {
                node.right = buildTree(children[1], mp);
            }
        }

        return node;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, int[]> childrenMap = new HashMap<>();
        Set<Integer> childrenSet = new HashSet<>();

        for(int[] desc : descriptions) {
            int parent  = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            childrenMap.putIfAbsent(parent, new int[]{-1, -1});
            childrenSet.add(child);

            if(isLeft) {
                childrenMap.get(parent)[0] = child;
            } else {
                childrenMap.get(parent)[1] = child;
            }
        }

        int headNodeVal = -1;
        for(int parent : childrenMap.keySet()) {
            if(!childrenSet.contains(parent)) {
                headNodeVal = parent;
            }
        }

        return buildTree(headNodeVal, childrenMap);
    }
}