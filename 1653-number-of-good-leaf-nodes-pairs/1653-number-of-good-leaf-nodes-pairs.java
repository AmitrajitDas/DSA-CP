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
    private void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> adj, Set<TreeNode> st) {
        if (root == null) {
            return;
        }

        // storing all the leaf nodes in set
        if (root.left == null && root.right == null) {
            st.add(root);
        }

        // creating bidirectional edges between nodes
        if (prev != null) {
            adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }

        // Recurse for left and right subtrees
        makeGraph(root.left, root, adj, st);
        makeGraph(root.right, root, adj, st);
    }

    public int countPairs(TreeNode root, int distance) {
        // Adjacency list for the graph
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        // Set to store leaf nodes
        Set<TreeNode> st = new HashSet<>();
        int count = 0;

        // Create the graph and identify all leaf nodes
        makeGraph(root, null, adj, st);

        // BFS from each leaf node
        for (TreeNode leaf : st) {
            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> vis = new HashSet<>();
            q.add(leaf);
            vis.add(leaf);

            // Count pairs of leaves within the given distance
            for (int i = 0; i <= distance; i++) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNode currNode = q.poll();

                    // avoid counting source leaf node twice in a single BFS traversal
                    if (st.contains(currNode) && currNode != leaf) {
                        count++;
                    }

                    // Visit all neighbors
                    for (TreeNode nbr : adj.getOrDefault(currNode, new ArrayList<>())) {
                        if (!vis.contains(nbr)) {
                            vis.add(nbr);
                            q.add(nbr);
                        }
                    }
                }
            }
        }

        // Each pair is counted twice, so divide by 2
        return count / 2;
    }
};