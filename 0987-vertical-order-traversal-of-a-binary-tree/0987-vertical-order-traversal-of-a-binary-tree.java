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
    private void dfs(TreeNode root, int row, int col, TreeMap<Integer, List<int[]>> map) {
        if(root == null) return;

        dfs(root.left, row + 1, col - 1, map);
        dfs(root.right, row + 1, col + 1, map);
        // Store [row, value] for each node
        map.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, root.val});
        return;
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, 0, map);

        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> nodes = entry.getValue();
            Collections.sort(nodes, (a, b) -> {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
            List<Integer> columns = new ArrayList<>();
            for(int[] node : nodes) {
                columns.add(node[1]);
            }

            res.add(columns);
        }

        return res;
    }
}